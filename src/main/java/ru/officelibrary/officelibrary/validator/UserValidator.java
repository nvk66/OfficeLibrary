package ru.officelibrary.officelibrary.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.officelibrary.officelibrary.entity.User;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (user.getName() == null || user.getName().isEmpty()) {
            errors.reject("name", "Empty message");
        } else {
            if (user.getName().length() < 2 || user.getName().length() > 40) {
                errors.reject("name", "Message is too small or too long");
            }
            if (!user.getName().matches("[a-zA-z[\\u0401\\u0451\\u0410-\\u044f]\\-]{3,40}")) {
                errors.reject("name", "Input error");
            }
        }

        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            errors.reject("lastName", "Empty message");
        } else {
            if (user.getLastName().length() < 2 || user.getLastName().length() > 40) {
                errors.reject("lastName", "Message is too small or too long");
            }
            if (!user.getLastName().matches("[a-zA-z[\\u0401\\u0451\\u0410-\\u044f]\\-]{3,40}")) {
                errors.reject("lastName", "Input error");
            }
        }

        if (user.getPatronymicName() != null && !user.getPatronymicName().isEmpty()) {
            if (!user.getPatronymicName().matches("[a-zA-z[\\u0401\\u0451\\u0410-\\u044f]\\-]{3,40}")) {
                errors.reject("patronymicName", "Input error");
            }
        }
    }
}
