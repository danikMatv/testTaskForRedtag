package org.example.redtag.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.redtag.entity.Author;
import org.example.redtag.entity.Book;
import org.example.redtag.exeption.AuthorNotFoundException;
import org.example.redtag.repository.AuthorRepository;
import org.example.redtag.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Transactional
    public Author save(Author author){
        return authorRepository.save(author);
    }

    @Transactional
    public void delete(String firstName,String lastName){
        Author author = authorRepository.findAuthorByNameAndSurname(firstName, lastName);
        if (author == null) {
            throw new AuthorNotFoundException("Author " + firstName + " " + lastName + " not found ");
        }
        List<Book> authorBooks = bookRepository.getBooksByAuthor(author);

        bookRepository.deleteAll(authorBooks);
        authorRepository.delete(author);
    }


}
