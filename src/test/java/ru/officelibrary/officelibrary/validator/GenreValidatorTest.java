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
        genre.setGenreName("Non-fiction");
        BeanPropertyBindingResult error = new BeanPropertyBindingResult(genre, "genre");
        genreValidator.validate(genre, error);
        Assertions.assertEquals(0, error.getErrorCount());

        String [] strings = {"Non-fiction", "ad", "add", "..1", "Привет", "GenreGenreGenreGenreGenreGenreGenreGenre"};
        genre.setGenreName("ad");
        genreValidator.validate(genre, error);
        Assertions.assertEquals(1, error.getErrorCount());
        error = new BeanPropertyBindingResult(genre, "genre");

        genre.setGenreName("add");
        genreValidator.validate(genre, error);
        Assertions.assertEquals(0, error.getErrorCount());
        error = new BeanPropertyBindingResult(genre, "genre");

        genre.setGenreName("..1");
        genreValidator.validate(genre, error);
        Assertions.assertEquals(1, error.getErrorCount());
        error = new BeanPropertyBindingResult(genre, "genre");

        genre.setGenreName("Привет");
        genreValidator.validate(genre, error);
        Assertions.assertEquals(0, error.getErrorCount());
        error = new BeanPropertyBindingResult(genre, "genre");

        genre.setGenreName("GenreGenreGenreGenreGenreGenreGenreGenrea");
        genreValidator.validate(genre, error);
        Assertions.assertEquals(2, error.getErrorCount());
    }
}