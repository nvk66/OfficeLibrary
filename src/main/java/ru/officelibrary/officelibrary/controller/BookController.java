package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.entity.Author;
import ru.officelibrary.officelibrary.entity.Book;
import ru.officelibrary.officelibrary.entity.Genre;
import ru.officelibrary.officelibrary.service.AuthorService;
import ru.officelibrary.officelibrary.service.BookService;
import ru.officelibrary.officelibrary.service.GenreService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;


    @RequestMapping("/book")
    public ModelAndView bookHome() {
        List<Book> listBook = bookService.getAll();
        ModelAndView mav = new ModelAndView("book");
        mav.addObject("listBook", listBook);
        return mav;
    }

    @GetMapping(value = "book/new")
    public ModelAndView newBookForm(ModelAndView model) {
        Book book = new Book();
        model.addObject("book", book);
        List<Genre> genreList = genreService.getAll();
        List<Author> authorList = authorService.getAll();
        model.addObject("genreList", genreList);
        model.addObject("authorList", authorList);
        model.setViewName("BookForm");
        return model;
    }

    @GetMapping("book/edit")
    public ModelAndView editBookForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("BookForm");
        Book book = bookService.get(id);
        mav.addObject("book", book);
        return mav;
    }

    @PostMapping(value = "book/new/save")
    public ModelAndView saveBook(@ModelAttribute Book book) {
        if (book.getBookId() == 0) {
            bookService.addBook(book);
        } else {
            bookService.get(book.getBookId());
        }
        bookService.addBook(book);
        return new ModelAndView("redirect:/book");
    }

    @RequestMapping("book/delete")
    public String deleteBook(@RequestParam long id) {
        bookService.deleteBook(id);
        return "redirect:/book";
    }
}
