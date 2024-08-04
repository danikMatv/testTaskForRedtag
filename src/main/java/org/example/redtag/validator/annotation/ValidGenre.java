package org.example.redtag.validator.annotation;

import org.example.redtag.validator.GenreValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GenreValidator.class)
public @interface ValidGenre {
    String message() default "Genre is not valid";

}
