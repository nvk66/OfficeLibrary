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
        book.setName("We");
        BeanPropertyBindingResult error = new BeanPropertyBindingResult(book, "book");
        bookValidator.validate(book, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(book, "book");
        book.setName("");
        bookValidator.validate(book, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(book, "book");
        book.setName(null);
        bookValidator.validate(book, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(book, "book");
        book.setName("Book & 9 1 0 !?@#$*&^");
        bookValidator.validate(book, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(book, "book");
        book.setName("Book & 9 1 0 !?@#$*&^");
        book.setPublishingYear(2020);
        bookValidator.validate(book, error);
        Assertions.assertEquals(0, error.getErrorCount());
    }
}