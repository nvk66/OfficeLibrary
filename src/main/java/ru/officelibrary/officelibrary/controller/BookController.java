package ru.officelibrary.officelibrary.controller;

import lombok.extern.log4j.Log4j2;
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
import ru.officelibrary.officelibrary.exception.ReservationException;
import ru.officelibrary.officelibrary.exception.SearchException;
import ru.officelibrary.officelibrary.service.*;
import ru.officelibrary.officelibrary.validator.BookValidator;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Controller
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final UserService userService;
    private final HistoryService historyService;
    private final BookValidator bookValidator;

    public BookController(BookService bookService, AuthorService authorService, GenreService genreService,
                          UserService userService, HistoryService historyService, BookValidator bookValidator) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
        this.userService = userService;
        this.historyService = historyService;
        this.bookValidator = bookValidator;
    }

    @RequestMapping("/book")
    public ModelAndView bookHome() {
        List<Book> listBook = bookService.getAll().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("bookPage");
        mav.addObject("listBook", listBook);
        return mav;
    }

    @GetMapping(value = "book/new/")
    public ModelAndView createNewBook(ModelAndView model) {
        BookDto bookDto = new BookDto();
        model.addObject("book", bookDto);
        List<Genre> genreList = genreService.getAll();
        List<Author> authorList = authorService.getAll();
        model.addObject("genreList", genreList);
        model.addObject("authorList", authorList);
        model.setViewName("bookFormPage");
        return model;
    }

    @GetMapping("book/edit/{id}")
    public ModelAndView editBook(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("bookFormPage");
        Book book = bookService.get(id);
        mav.addObject("book", book);
        return mav;
    }

    @PostMapping(value = "book/new/save")
    public ModelAndView saveBook(@ModelAttribute Book book, BindingResult result, ModelAndView model) {
        bookValidator.validate(book, result);
        if (result.hasErrors()) {
            model.addObject("books", book);
            model.addObject("error", "Input error");
            model.setViewName("bookFormPage");
            return model;
        }
        try {
            book.setStats("Free");
            bookService.addBook(book);
            return bookHome();
        } catch (Exception e) {
            log.error("There was an exception in attempt to save book");
            model.addObject("books", book);
            model.addObject("error", e.getMessage());
            model.setViewName("bookFormPage");
            return model;
        }
    }

    @RequestMapping("book/delete/{id}")
    public ModelAndView deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return bookHome();
    }

    @RequestMapping("/book/{id}")
    public String viewBook(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "bookSelectedPage";
    }

    @GetMapping("/book/reserve/{id}/")
    public ModelAndView newReservationForm(ModelAndView model, @PathVariable long id) throws ReservationException {
        HistoryDto historyDto = new HistoryDto();
        if (!bookService.isItPossibleToBookABook(id)) {
            throw new ReservationException();
        }
        historyDto.setBook(String.valueOf(id));
        long userId = userService.getUserId();
        historyDto.setUser(String.valueOf(userId));
        historyDto.setStats("busy");
        bookService.get(id).setStats("Busy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        historyDto.setStartDate(Date.valueOf(simpleDateFormat.format(calendar.getTime())));
        model.addObject("reservation", historyDto);
        model.addObject("book", bookService.get(id));
        model.addObject("user", userService.getByID(userId));
        model.addObject("status", "Busy");
        model.setViewName("historyFormPage");
        return model;
    }

    @RequestMapping("/book/search")
    public ModelAndView search(@RequestParam String keyword) throws SearchException {
        List<Book> result = bookService.findBookByNameEquals(keyword);
        ModelAndView mav = new ModelAndView("searchResult");
        mav.addObject("result", result);
        return mav;
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
        return bookHome();
    }
}
