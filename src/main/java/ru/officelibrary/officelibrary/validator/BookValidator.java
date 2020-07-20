package ru.officelibrary.officelibrary.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.officelibrary.officelibrary.entity.Book;

public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;
        if (book.getBookName() == null || book.getBookName().isEmpty()) {
            errors.reject("name", "Empty message");
        } else {
            if (book.getBookName().length() < 1 || book.getBookName().length() > 200) {
                errors.reject("name", "Message is too small or too long");
            }
            if (!book.getBookName().matches("[a-zA-z0-9[\\u0401\\u0451\\u0410-\\u044f]\\- ,!?&@#$%^*()+_=\\\\\"']{2,200}")) {
                errors.reject("name", "Input error");
            }
        }

        if (book.getPublishingYear() < -2000 && book.getPublishingYear() > 2020){
            errors.reject("publishingYear", "Input error");
        }
    }
}
