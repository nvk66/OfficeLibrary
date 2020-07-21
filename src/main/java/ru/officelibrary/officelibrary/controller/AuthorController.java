package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.entity.Author;
import ru.officelibrary.officelibrary.service.AuthorService;
import ru.officelibrary.officelibrary.service.BookService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AuthorController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;


    @RequestMapping("/author")
    public ModelAndView authorHome() {
        List<Author> listAuthor = authorService.getAll().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("author");
        mav.addObject("listAuthor", listAuthor);
        return mav;
    }

    @GetMapping(value = "/new")
    public ModelAndView newAuthorForm(ModelAndView model) {
        Author author = new Author();
        model.addObject("author", author);
        model.setViewName("form_history");
        return model;
    }

    @GetMapping("author/edit")
    public ModelAndView editAuthorForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("form_history");
        Author author = authorService.get(id);
        mav.addObject("author", author);
        return mav;
    }

    @PostMapping(value = "author/save")
    public ModelAndView saveAuthor(@ModelAttribute Author author) {
        if (author.getAuthorId() == 0) {
            authorService.addAuthor(author);
        } else {
            authorService.get(author.getAuthorId());
        }
        authorService.addAuthor(author);
        return new ModelAndView("redirect:/author");
    }

    @RequestMapping("author/delete")
    public String deleteAuthor(@RequestParam long id) {
        authorService.deleteAuthor(id);
        return "redirect:/author";
    }

}
