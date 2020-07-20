package ru.officelibrary.officelibrary.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import ru.officelibrary.officelibrary.entity.Book;

class BookValidatorTest {
    BookValidator bookValidator;

    @BeforeEach
    void setUp() {
        bookValidator = new BookValidator();
    }

    @Test
    void validate() {
        Book book = new Book();
        book.setBookName("We");
        BeanPropertyBindingResult error = new BeanPropertyBindingResult(book, "book");
        bookValidator.validate(book, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(book, "book");
        book.setBookName("");
        bookValidator.validate(book, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(book, "book");
        book.setBookName(null);
        bookValidator.validate(book, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(book, "book");
        book.setBookName("Book & 9 1 0 !?@#$*&^");
        bookValidator.validate(book, error);
        Assertions.assertEquals(0, error.getErrorCount());
    }
}