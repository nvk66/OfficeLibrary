package ru.officelibrary.officelibrary.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.entity.Author;
import ru.officelibrary.officelibrary.service.AuthorService;
import ru.officelibrary.officelibrary.service.BookService;
import ru.officelibrary.officelibrary.validator.AuthorValidator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Controller
public class AuthorController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final AuthorValidator authorValidator;

    public AuthorController(BookService bookService, AuthorService authorService, AuthorValidator authorValidator) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.authorValidator = authorValidator;
    }

    @RequestMapping("/author/")
    public ModelAndView authorHome() {
        List<Author> listAuthor = authorService.getAll().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("authorPage");
        mav.addObject("listAuthor", listAuthor);
        return mav;
    }

    @RequestMapping(value = "/author/new/", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView newAuthorForm(ModelAndView model) {
        Author author = new Author();
        model.addObject("author", author);
        model.setViewName("authorFormPage");
        return model;
    }

    @GetMapping("author/edit/{id}/")
    public ModelAndView editAuthorForm(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("authorFormPage");
        Author author = authorService.get(id);
        mav.addObject("author", author);
        return mav;
    }

    @PostMapping(value = "author/save/")
    public ModelAndView saveAuthor(@ModelAttribute Author author, BindingResult result, ModelAndView model) {
        authorValidator.validate(author, result);
        if (result.hasErrors()) {
            model.addObject("authors", author);
            model.addObject("error", "Input error");
            model.setViewName("authorFormPage");
            return model;
        }
        try {
            authorService.addAuthor(author);
            return authorHome();
        } catch (Exception e) {
            log.error("There was an exception in attempt to save author");
            model.addObject("authors", author);
            model.addObject("error", e.getMessage());
            model.setViewName("authorFormPage");
            return model;
        }
    }

    @RequestMapping(value = "author/delete/{id}/", method = {RequestMethod.DELETE, RequestMethod.GET})
    public ModelAndView deleteAuthor(@PathVariable long id) {
        authorService.deleteAuthor(id);
        return authorHome();
    }

    @RequestMapping("/author/{id}/")
    public String viewAuthor(@PathVariable long id, Model model) {
        Author author = authorService.get(id);
        model.addAttribute("author", author);
        model.addAttribute("book", bookService.findBookByAuthor(author));
        return "authorSelectedPage";
    }

}
