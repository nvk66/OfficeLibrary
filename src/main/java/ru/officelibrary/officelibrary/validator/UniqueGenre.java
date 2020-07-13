package ru.officelibrary.officelibrary.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueGenreValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueGenre {

    public String message() default "This genre is already exists!";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}
