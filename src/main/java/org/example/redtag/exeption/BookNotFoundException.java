package org.example.redtag.exeption;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }

}
