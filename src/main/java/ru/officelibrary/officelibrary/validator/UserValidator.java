package ru.officelibrary.officelibrary.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.officelibrary.officelibrary.entity.User;

public class UserValidator extends AbstractValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
//        if (user.getName() == null || user.getName().isEmpty()) {
//            errors.reject("name", "Empty message");
//        } else {
//            if (user.getName().length() < 2 || user.getName().length() > 40) {
//                errors.reject("name", "Message is too small or too long");
//            }
//            if (!user.getName().matches(patternForName)) {
//                errors.reject("name", "Input error");
//            }
//        }
//
//        if (user.getLastName() == null || user.getLastName().isEmpty()) {
//            errors.reject("lastName", "Empty message");
//        } else {
//            if (user.getLastName().length() < 2 || user.getLastName().length() > 40) {
//                errors.reject("lastName", "Message is too small or too long");
//            }
//            if (!user.getLastName().matches(patternForName)) {
//                errors.reject("lastName", "Input error");
//            }
//        }
//
//        if (user.getPatronymicName() != null && !user.getPatronymicName().isEmpty()) {
//            if (!user.getPatronymicName().matches(patternForName)) {
//                errors.reject("patronymicName", "Input error");
//            }
//        }

        if (!checkName(user.getName())) {
            errors.reject("name", "Input error");
        }

        if (!checkName(user.getLastName())) {
            errors.reject("lastName", "Input error");
        }

        if (!checkPatName(user.getPatronymicName())) {
            errors.reject("patronymicName", "Input error");
        }

//        Date date = Date.valueOf(LocalDate.now().minusDays(3652));
//        if (user.getBirthDate().after(date)){
//            errors.reject("birthYear", "InputError");
//        }
    }
}
