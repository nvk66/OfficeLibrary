package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.dto.BookDto;
import ru.officelibrary.officelibrary.dto.HistoryDto;
import ru.officelibrary.officelibrary.entity.Author;
import ru.officelibrary.officelibrary.entity.Book;
import ru.officelibrary.officelibrary.entity.Genre;
import ru.officelibrary.officelibrary.entity.History;
import ru.officelibrary.officelibrary.service.*;
import ru.officelibrary.officelibrary.validator.BookValidator;

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

    @Autowired
    private BookValidator bookValidator;


    @RequestMapping("/book")
    public ModelAndView bookHome() {
        List<Book> listBook = bookService.getAll().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("book");
        mav.addObject("listBook", listBook);
        return mav;
    }

    @GetMapping(value = "book/new")
    public ModelAndView newBookForm(ModelAndView model) {
        BookDto bookDto = new BookDto();
        model.addObject("book", bookDto);
        List<Genre> genreList = genreService.getAll();
        List<Author> authorList = authorService.getAll();
        model.addObject("genreList", genreList);
        model.addObject("authorList", authorList);
        model.setViewName("form_book");
        return model;
    }

    @GetMapping("book/edit")
    public ModelAndView editBookForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("form_book");
        Book book = bookService.get(id);
        mav.addObject("book", book);
        return mav;
    }

    @PostMapping(value = "book/new/save")
    public ModelAndView saveBook(@ModelAttribute Book book, BindingResult result, ModelAndView model) {
        bookValidator.validate(book, result);
        if (result.hasErrors()) {
            model.addObject("books", book);
            model.addObject("error", "Data was not updated");
            model.setViewName("form_book");
            return model;
        } else {
            try {
                if (book.getId() == 0) {
                    bookService.addBook(book);
                } else {
                    bookService.get(book.getId());
                }
                bookService.addBook(book);
                return new ModelAndView("redirect:/book");
            } catch (Exception e) {
                model.addObject("books", book);
                model.addObject("error", e.getMessage());
                model.setViewName("form_book");
                return model;
            }
        }
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
        HistoryDto historyDto = new HistoryDto();
        historyDto.setBook(String.valueOf(id));
        historyDto.setUser(String.valueOf(6));
        historyDto.setStats("busy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        historyDto.setStartDate(Date.valueOf(simpleDateFormat.format(calendar.getTime())));
        model.addObject("reservation", historyDto);
        model.addObject("book", bookService.get(id));
        model.addObject("user", userService.getByID(6));
        model.addObject("status", "Busy");
        model.setViewName("from_history");
        return model;
    }

    @PostMapping("/book/reserve/{id}/save")
    public ModelAndView saveReservation(@ModelAttribute HistoryDto historyDto, @PathVariable long id) {
        History history = new History();
        history.setUser(userService.getByID(Long.parseLong(historyDto.getUser())));
        history.setBook(bookService.get(Long.parseLong(historyDto.getBook())));
        history.setStartDate(historyDto.getStartDate());
        history.setDueDate(historyDto.getDueDate());
        history.setStats(historyDto.getStats());
        history.setId(historyDto.getHistoryId());
        if (history.getId() == 0) {
            historyService.addHistory(history);
        } else {
            historyService.getById(history.getId());
        }
        historyService.addHistory(history);
        return new ModelAndView("redirect:/book");
    }
}
