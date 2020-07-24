package ru.officelibrary.officelibrary.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.officelibrary.officelibrary.entity.Author;

import java.util.Calendar;

@Component
public class AuthorValidator extends AbstractValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Author.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Author author = (Author) o;

        if (!checkName(author.getName())) {
            errors.reject("name", "Input error");
        }

        if (!checkName(author.getLastName())) {
            errors.reject("lastName", "Input error");
        }

        if (!checkPatName(author.getPatronymicName())) {
            errors.reject("patronymicName", "Input error");
        }

        int year = Calendar.getInstance().get(Calendar.YEAR) - 10;
        if (author.getBirthYear() < -2000 || author.getBirthYear() > year) {
            errors.reject("birthYear", "InputError");
        }

        if (author.getBiography() == null || author.getBiography().isEmpty()) {
            errors.reject("biography", "Empty message");
        } else {
            if (author.getBiography().length() < 40 || author.getBiography().length() > 10000) {
                errors.reject("name", "Message is too small or too long");
            }
            if (!author.getBiography().matches("[a-zA-zА-Яа-я0-9\\\\.,!?+-\\\\\"' ]{40,10000}")) {
                errors.reject("name", "Input error");
            }
        }
    }
}
