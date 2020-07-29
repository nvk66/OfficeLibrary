package ru.officelibrary.officelibrary.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import ru.officelibrary.officelibrary.entity.Genre;

class GenreValidatorTest {
    private GenreValidator genreValidator;

    @BeforeEach
    void setUp() {
        genreValidator = new GenreValidator();
    }

    @Test
    void validate() {
        Genre genre = new Genre();
        genre.setName("Non-fiction");
        BeanPropertyBindingResult error = new BeanPropertyBindingResult(genre, "genre");
        genreValidator.validate(genre, error);
        Assertions.assertEquals(0, error.getErrorCount());

        genre.setName("add");
        genreValidator.validate(genre, error);
        Assertions.assertEquals(0, error.getErrorCount());
        error = new BeanPropertyBindingResult(genre, "genre");

        genre.setName("..1");
        genreValidator.validate(genre, error);
        Assertions.assertEquals(1, error.getErrorCount());
        error = new BeanPropertyBindingResult(genre, "genre");

        genre.setName("Привет");
        genreValidator.validate(genre, error);
        Assertions.assertEquals(0, error.getErrorCount());
        error = new BeanPropertyBindingResult(genre, "genre");

        genre.setName("GenreGenreGenreGenreGenreGenreGenreGenrea");
        genreValidator.validate(genre, error);
        Assertions.assertEquals(1, error.getErrorCount());
    }
}