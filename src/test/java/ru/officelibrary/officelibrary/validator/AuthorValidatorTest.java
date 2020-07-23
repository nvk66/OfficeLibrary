package ru.officelibrary.officelibrary.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import ru.officelibrary.officelibrary.entity.Author;

class AuthorValidatorTest {

    AuthorValidator authorValidator;

    @BeforeEach
    void setUp() {
        authorValidator = new AuthorValidator();
    }

    @Test
    void validate() {
        Author author = new Author();
        BeanPropertyBindingResult error = new BeanPropertyBindingResult(author, "author");
        author.setName("");
        author.setLastName("LastName");
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setName("Name");
        author.setLastName("");
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setName("Name");
        author.setLastName(null);
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setName(null);
        author.setLastName("NameNameNameNameNameNameNameNameNameNamee");
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        authorValidator.validate(author, error);
        Assertions.assertEquals(2, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setName("Anna-Maria");
        author.setLastName("LastName");
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setName("Abu");
        author.setLastName("Ab");
        authorValidator.validate(author, error);
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setName("Abu");
        author.setLastName("Abu");
        author.setPatronymicName("");
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setPatronymicName(null);
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setPatronymicName("Petro-Petro");
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setPatronymicName("Я-Русский");
        author.setBiography("I was born in the heart of Siberia \" with an awesome smile");
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setBiography("");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setBiography(null);
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setBiography("I was born in the heart of Siberia with an awesome smile &&&");
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setPatronymicName("Petro-Petro");
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        author.setBirthYear(2011);
        authorValidator.validate(author, error);
        Assertions.assertEquals(1, error.getErrorCount());

        error = new BeanPropertyBindingResult(author, "author");
        author.setPatronymicName("Petro-Petro");
        author.setBiography("I was born in the heart of Siberia with an awesome smile");
        author.setBirthYear(2009);
        authorValidator.validate(author, error);
        Assertions.assertEquals(0, error.getErrorCount());
    }
}