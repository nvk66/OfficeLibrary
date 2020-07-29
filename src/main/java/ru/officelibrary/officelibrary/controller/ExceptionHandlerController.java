package ru.officelibrary.officelibrary.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.entity.Book;
import ru.officelibrary.officelibrary.exception.ReservationException;
import ru.officelibrary.officelibrary.service.BookService;

@Log4j2
@ControllerAdvice(basePackages = "ru.officelibrary.officelibrary.controller")
public class ExceptionHandlerController {

    private static final String errorView = "reservationError";
    private final BookService bookService;

    public ExceptionHandlerController(BookService bookService) {
        this.bookService = bookService;
    }

    @ExceptionHandler(ReservationException.class)
    public ModelAndView impossibleToBookABook(ReservationException e){
        String errorMessage = e.getMessage();
        Book book = bookService.get(e.getId());
//        long id = e.getId();
        log.error(errorMessage, e);
        ModelAndView model = new ModelAndView();
        model.setViewName(errorView);
        model.addObject("message", errorMessage);
        model.addObject("id", book);
        return model;
    }
}
