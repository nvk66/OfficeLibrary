package ru.officelibrary.officelibrary.validator;

import org.springframework.beans.factory.annotation.Autowired;
import ru.officelibrary.officelibrary.service.GenreService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueGenreValidator implements ConstraintValidator<UniqueGenre, String> {

    @Autowired
    private GenreService genreService;

    @Override
    public void initialize(UniqueGenre constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && genreService.isGenreAlreadyExists(s);
    }
}
