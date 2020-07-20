package ru.officelibrary.officelibrary.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.officelibrary.officelibrary.entity.Author;

public class AuthorValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Author.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Author author = (Author) o;
        if (author.getName() == null || author.getName().isEmpty()) {
            errors.reject("name", "Empty message");
        } else {
            if (author.getName().length() < 2 || author.getName().length() > 40) {
                errors.reject("name", "Message is too small or too long");
            }
            if (!author.getName().matches("[a-zA-z[\\u0401\\u0451\\u0410-\\u044f]\\-]{3,40}")) {
                errors.reject("name", "Input error");
            }
        }

        if (author.getLastName() == null || author.getLastName().isEmpty()) {
            errors.reject("lastName", "Empty message");
        } else {
            if (author.getLastName().length() < 2 || author.getLastName().length() > 40) {
                errors.reject("lastName", "Message is too small or too long");
            }
            if (!author.getLastName().matches("[a-zA-z[\\u0401\\u0451\\u0410-\\u044f]\\-]{3,40}")) {
                errors.reject("lastName", "Input error");
            }
        }

        if (author.getPatronymicName() != null && !author.getPatronymicName().isEmpty()) {
            if (!author.getPatronymicName().matches("[a-zA-z[\\u0401\\u0451\\u0410-\\u044f]\\-]{3,40}")) {
                errors.reject("patronymicName", "Input error");
            }
        }

        if (author.getBirthYear() < -2000 || author.getBirthYear() > 2010){
            errors.reject("birthYear", "InputError");
        }

        if (author.getBiography() == null || author.getBiography().isEmpty()){
            errors.reject("biography", "Empty message");
        } else{
            if (author.getBiography().length() < 40 || author.getBiography().length() > 1000) {
                errors.reject("name", "Message is too small or too long");
            }
            if (!author.getBiography().matches("[a-zA-z0-9[\\u0401\\u0451\\u0410-\\u044f]\\\\.,!?+-\\\\\"' ]{40,1000}")) {
                errors.reject("name", "Input error");
            }
        }
    }
}
