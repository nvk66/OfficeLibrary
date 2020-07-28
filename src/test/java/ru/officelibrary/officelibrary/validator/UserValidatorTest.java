package ru.officelibrary.officelibrary.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import ru.officelibrary.officelibrary.entity.User;

import java.sql.Date;
import java.time.LocalDate;

class UserValidatorTest {
    private UserValidator userValidator;
    private User user = new User();
    private BeanPropertyBindingResult error = new BeanPropertyBindingResult(user, "user");

    @BeforeEach
    void setUp() {
        userValidator = new UserValidator();
        user.setName("Name");
        user.setLastName("LastName");
    }

    @Test
    public void nameValidator(){
        error = new BeanPropertyBindingResult(user, "user");
        user.setName("");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        user.setName("Name");
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());

        user.setName(null);
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        user.setName("Anna-Maria");
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());

        user.setName("Ab");
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        user.setLastName("NameNameNameNameNameNameNameNameNameNamee");
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(2, error.getErrorCount());
    }

    @Test
    public void lastNameValidator(){
        error = new BeanPropertyBindingResult(user, "user");
        user.setLastName("");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        user.setLastName("Name");
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());

        user.setLastName(null);
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        user.setLastName("Anna-Maria");
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());

        user.setLastName("Ab");
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        user.setLastName("NameNameNameNameNameNameNameNameNameNamee");
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());
    }

    @Test
    public void patNameValidator(){
        user.setPatronymicName(null);
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());

        user.setPatronymicName("null");
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());

        user.setPatronymicName("as");
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        user.setPatronymicName("NameNameNameNameNameNameNameNameNameNamee");
        error = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(user, "user");
        user.setPatronymicName("Я-Русский");
        userValidator.validate(user, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(user, "user");
        user.setBirthDate(Date.valueOf(LocalDate.now().minusDays(3653)));
        Assertions.assertEquals(0, error.getErrorCount());
    }
}