package ru.officelibrary.officelibrary.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.officelibrary.officelibrary.entity.User;

@Component
public class UserValidator extends AbstractValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
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
