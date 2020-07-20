package ru.officelibrary.officelibrary.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.officelibrary.officelibrary.entity.Genre;

@Component
public class GenreValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Genre.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Genre genre = (Genre) o;
        if (genre.getGenreName() == null || genre.getGenreName().isEmpty()) {
            errors.reject("genreName", "Empty message");
        } else {
            if (genre.getGenreName().length() < 2 || genre.getGenreName().length() > 40) {
                errors.reject("genreName", "Message is too small or too long");
            }
            if (!genre.getGenreName().matches("[a-zA-z[\\u0401\\u0451\\u0410-\\u044f]\\-]{3,40}")) {
                errors.reject("genreName", "Input error");
            }
        }
    }
}
