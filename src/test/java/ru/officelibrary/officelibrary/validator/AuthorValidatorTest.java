package ru.officelibrary.officelibrary.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import ru.officelibrary.officelibrary.entity.Author;

class AuthorValidatorTest {

    private AuthorValidator authorValidator;
    private Author author = new Author();
    private BeanPropertyBindingResult error = new BeanPropertyBindingResult(author, "author");

    @BeforeEach
    void setUp() {
        authorValidator = new AuthorValidator();
        author.setName("Name");
        author.setLastName("LastName");
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
    }

    @Test
    public void nameValidator(){
        error = new BeanPropertyBindingResult(author, "author");
        author.setName("");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        author.setName("Name");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        author.setName(null);
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        author.setName("Anna-Maria");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        author.setName("Ab");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        author.setLastName("NameNameNameNameNameNameNameNameNameNamee");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(2, error.getErrorCount());
    }

    @Test
    public void lastNameValidator(){
        error = new BeanPropertyBindingResult(author, "author");
        author.setLastName("");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        author.setLastName("Name");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        author.setLastName(null);
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        author.setLastName("Anna-Maria");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        author.setLastName("Ab");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        author.setLastName("NameNameNameNameNameNameNameNameNameNamee");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());
    }

    @Test
    public void patNameValidator(){
        author.setPatronymicName(null);
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        author.setPatronymicName("null");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        author.setPatronymicName("as");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        author.setPatronymicName("NameNameNameNameNameNameNameNameNameNamee");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());
    }

    @Test
    public void bioValidator(){
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        author.setBiography("I was born in the heart of Siberia \" with an awesome smile");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        author.setBiography(null);
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        author.setBiography("null");
        error = new BeanPropertyBindingResult(author, "author");
        authorValidator.validate(author, error);
        Assertions.assertEquals(2, error.getErrorCount());
    }
}