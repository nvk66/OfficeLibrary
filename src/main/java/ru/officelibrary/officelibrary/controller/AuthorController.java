package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class AuthorController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorValidator authorValidator;

    @RequestMapping("/author/")
    public ModelAndView authorHome() {
        List<Author> listAuthor = authorService.getAll().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("author");
        mav.addObject("listAuthor", listAuthor);
        return mav;
    }

    @RequestMapping(value = "/author/new/",  method={RequestMethod.POST, RequestMethod.GET})
    public ModelAndView newAuthorForm(ModelAndView model) {
        Author author = new Author();
        model.addObject("author", author);
        model.setViewName("form_author");
        return model;
    }

    @GetMapping("author/edit/{id}/")
    public ModelAndView editAuthorForm(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("form_author");
        Author author = authorService.get(id);
        mav.addObject("author", author);
        return mav;
    }

    @PostMapping(value = "author/save/")
    public ModelAndView saveAuthor(@ModelAttribute Author author, BindingResult result, ModelAndView model) {
        authorValidator.validate(author, result);
        if (result.hasErrors()) {
            model.addObject("authors", author);
            model.addObject("error", "Data was not updated");
            model.setViewName("form_author");
            return model;
        } else {
            try {
                if (author.getAuthorId() == 0) {
                    authorService.addAuthor(author);
                } else {
                    authorService.get(author.getAuthorId());
                }
                authorService.addAuthor(author);
                return new ModelAndView("redirect:/author/");
            } catch (Exception e){
                model.addObject("authors", author);
                model.addObject("error", e.getMessage());
                model.setViewName("form_author");
                return model;
            }
        }
    }

//    @RequestMapping("author/delete")
//    public String deleteAuthor(@RequestParam long id) {
//        authorService.deleteAuthor(id);
//        return "redirect:/author";
//    }

    @RequestMapping(value = "author/delete/{id}/", method={RequestMethod.DELETE, RequestMethod.GET})
    public String deleteAuthor(@PathVariable long id) {
        authorService.deleteAuthor(id);
        return "redirect:/author";
    }

    @RequestMapping("/author/{id}/")
    public String viewAuthor(@PathVariable long id, Model model) {
        Author author = authorService.get(id);
        model.addAttribute("author", author);
        model.addAttribute("book", bookService.findBookByAuthor(author));
        return "selected_author";
    }

}
