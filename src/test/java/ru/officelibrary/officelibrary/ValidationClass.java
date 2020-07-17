package ru.officelibrary.officelibrary;

import org.junit.jupiter.api.Test;
import ru.officelibrary.officelibrary.entity.Genre;

public class ValidationClass {
    @Test
    public void testGenreValidation(){
        Genre genre = new Genre();
        genre.setGenreId(1);
        genre.setGenreName("привет");
//        Genre genre2 = new Genre(1, "a");
//        Genre genre3= new Genre(1, "");
//        Genre genre4 = new Genre(1, "gh");
//        Genre genre5 = new Genre(1, "genregenregenregenregenregenregenregenre");
//        GenreValidator validator = new GenreValidator();
//        validator.validate(genre, );
//        Assertions.assertFalse(result.hasErrors());
    }
}
