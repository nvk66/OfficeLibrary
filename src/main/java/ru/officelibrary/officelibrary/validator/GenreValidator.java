package ru.officelibrary.officelibrary.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.officelibrary.officelibrary.entity.Genre;

@Component
public class GenreValidator extends AbstractValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Genre.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Genre genre = (Genre) o;

        if (!checkName(genre.getName())) {
            errors.reject("name", "Input error");
        }
    }
}
