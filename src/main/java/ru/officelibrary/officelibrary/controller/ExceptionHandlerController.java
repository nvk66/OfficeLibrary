package ru.officelibrary.officelibrary.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.exception.ReservationException;

@Log4j2
@ControllerAdvice(basePackages = "ru.officelibrary.officelibrary.controller")
public class ExceptionHandlerController {
    private static final String errorView = "reservationError";

    @ExceptionHandler(ReservationException.class)
    public ModelAndView impossibleToBookABook(Exception e){
        String errorMessage = e.getMessage();
        log.error(errorMessage, e);
        ModelAndView model = new ModelAndView();
        model.setViewName(errorView);
        model.addObject("message", errorMessage);
        return model;
    }
}
