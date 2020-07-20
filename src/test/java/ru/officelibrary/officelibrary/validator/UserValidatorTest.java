package ru.officelibrary.officelibrary.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import ru.officelibrary.officelibrary.entity.User;

class UserValidatorTest {
    UserValidator userValidator;


    @BeforeEach
    void setUp() {
        userValidator = new UserValidator();
    }

    @Test
    void validate() {
        User user = new User();
        BeanPropertyBindingResult error = new BeanPropertyBindingResult(user, "user");
        user.setName("");
        user.setLastName("LastName");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(user, "user");
        user.setName("Name");
        user.setLastName("");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(user, "user");
        user.setName("Name");
        user.setLastName(null);
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(user, "user");
        user.setName(null);
        user.setLastName("NameNameNameNameNameNameNameNameNameNamee");
        userValidator.validate(user, error);
        Assertions.assertEquals(3, error.getErrorCount());

        error = new BeanPropertyBindingResult(user, "user");
        user.setName("Anna-Maria");
        user.setLastName("LastName");
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(user, "user");
        user.setName("Abu");
        user.setLastName("Ab");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(user, "user");
        user.setName("Abu");
        user.setLastName("Abu");
        user.setPatronymicName("");
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(user, "user");
        user.setPatronymicName(null);
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(user, "user");
        user.setPatronymicName("Petro-Petro");
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(user, "user");
        user.setPatronymicName("Я-Русский");
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());
    }
}