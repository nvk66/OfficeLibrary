package ru.officelibrary.officelibrary.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.officelibrary.officelibrary.entity.Book;

import java.util.Calendar;

@Component
public class BookValidator implements Validator {
    private final int maxLength = 200;

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;
        if (book.getName() == null || book.getName().isEmpty()) {
            errors.reject("name", "Empty message");
        } else {
            if (book.getName().length() > maxLength) {
                errors.reject("name", "Message is too small or too long");
            }
            if (!book.getName().matches("[a-zA-z0-9А-Яа-я\\- ,!?&@#$%^*()+_=\\\\\"']+")) {
                errors.reject("name", "Input error");
            }
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if (book.getPublishingYear() < -2000 || book.getPublishingYear() > year) {
            errors.reject("publishingYear", "Input error");
        }
    }
}
