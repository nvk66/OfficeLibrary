package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.dto.request.BookDtoRequest;
import ru.officelibrary.officelibrary.dto.request.HistoryDtoRequest;
import ru.officelibrary.officelibrary.entity.Author;
import ru.officelibrary.officelibrary.entity.Book;
import ru.officelibrary.officelibrary.entity.Genre;
import ru.officelibrary.officelibrary.entity.History;
import ru.officelibrary.officelibrary.service.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private UserService userService;
    @Autowired
    private HistoryService historyService;


    @RequestMapping("/book")
    public ModelAndView bookHome() {
        List<Book> listBook = bookService.getAll().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("book");
        mav.addObject("listBook", listBook);
        return mav;
    }

    @GetMapping(value = "book/new")
    public ModelAndView newBookForm(ModelAndView model) {
        BookDtoRequest bookDtoRequest = new BookDtoRequest();
//        model.put("book", bookDtoRequest);
//        List<Genre> genreList = genreService.getAll();
//        List<Author> authorList = adminAuthorService.getAll();
//        model.put("genreList", genreList);
//        model.put("authorList", authorList);
//        return "new_book";
//        Book book = new Book();
        model.addObject("book", bookDtoRequest);
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

    @RequestMapping("/book/{id}")
    public String viewBook(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "selected_book";
    }


    @GetMapping("/book/reserve/{id}/")
    public ModelAndView newReservationForm(ModelAndView model, @PathVariable long id) {
//        History history = new History();
//        history.setBook(bookService.get(id));
//        history.setUser(userService.getByID(6));
//        history.setStats("busy");
        HistoryDtoRequest historyDtoRequest = new HistoryDtoRequest();
        historyDtoRequest.setBook(String.valueOf(id));
        historyDtoRequest.setUser(String.valueOf(6));
        historyDtoRequest.setStats("busy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
//        history.setStartDate(Date.valueOf(simpleDateFormat.format(calendar.getTime())));
        historyDtoRequest.setStartDate(Date.valueOf(simpleDateFormat.format(calendar.getTime())));
        model.addObject("reservation", historyDtoRequest);
        model.addObject("book", bookService.get(id));
        model.addObject("user", userService.getByID(6));
        model.addObject("status", "Busy");
        model.setViewName("HistoryForm");
        return model;
    }

    @PostMapping("/book/reserve/{id}/save")
    public ModelAndView saveReservation(@ModelAttribute HistoryDtoRequest historyDtoRequest, @PathVariable long id) {
//        history.setBook(bookService.get(id));
//        history.setUser(userService.getByID(6));
//        history.setStats("busy");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar calendar = Calendar.getInstance();
//        history.setStartDate(Date.valueOf(simpleDateFormat.format(calendar.getTime())));
        History history = new History();
        history.setUser(userService.getByID(Long.parseLong(historyDtoRequest.getUser())));
        history.setBook(bookService.get(Long.parseLong(historyDtoRequest.getBook())));
        history.setStartDate(historyDtoRequest.getStartDate());
        history.setDueDate(historyDtoRequest.getDueDate());
        history.setStats(historyDtoRequest.getStats());
        history.setHistoryId(historyDtoRequest.getHistoryId());
        if (history.getHistoryId() == 0) {
            historyService.addHistory(history);
        } else {
            historyService.getById(history.getHistoryId());
        }
        historyService.addHistory(history);
        return new ModelAndView("redirect:/book");
    }
}
