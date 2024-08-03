package org.example.redtag.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.redtag.entity.Author;
import org.example.redtag.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional
    public Author save(Author author){
        return authorRepository.save(author);
    }

    @Transactional
    public void delete(String firstName,String lastName){
        Author author = authorRepository.findAuthorByNameAndSurname(firstName,lastName);
        authorRepository.deleteById(Math.toIntExact(author.getId()));
    }
}
