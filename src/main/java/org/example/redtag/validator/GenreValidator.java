package org.example.redtag.validator;

import org.example.redtag.entity.Genre;
import org.example.redtag.validator.annotation.ValidGenre;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenreValidator implements ConstraintValidator<ValidGenre,String> {

    @Override
    public void initialize(ValidGenre constrainAnnotation){
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context){
        if (name == null){
            return false;
        }
        for (Genre genre : Genre.values()){
            if(genre.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
