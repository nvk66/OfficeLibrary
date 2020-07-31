package ru.officelibrary.officelibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.entity.Book;
import ru.officelibrary.officelibrary.exception.ReservationException;
import ru.officelibrary.officelibrary.exception.SearchException;
import ru.officelibrary.officelibrary.service.BookService;


@ControllerAdvice(basePackages = "ru.officelibrary.officelibrary.controller")
public class ExceptionHandlerController {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    private static final String errorView = "reservationError";
    private final BookService bookService;

    public ExceptionHandlerController(BookService bookService) {
        this.bookService = bookService;
    }

    @ExceptionHandler(ReservationException.class)
    public ModelAndView impossibleToBookABook(ReservationException e){
        String errorMessage = e.getMessage();
        Book book = bookService.get(e.getId());
        logger.error(errorMessage, e);
        ModelAndView model = new ModelAndView();
        model.setViewName(errorView);
        model.addObject("message", errorMessage);
        model.addObject("id", book.getName());
        return model;
    }

    @ExceptionHandler(SearchException.class)
    public ModelAndView impossibleToFindABook(SearchException e){
        String errorMessage = e.getErrMessage();
        logger.error(errorMessage, e);
        ModelAndView model = new ModelAndView();
        model.setViewName(errorView);
        model.addObject("message", errorMessage);
        model.addObject("id", e.getSearchRequest());
        return model;
    }
}
