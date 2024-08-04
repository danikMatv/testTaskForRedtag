package org.example.redtag.exeption;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException() {

    }

    public AuthorNotFoundException(String message) {
        super(message);
    }
}
