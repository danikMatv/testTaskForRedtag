package org.example.redtag.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.redtag.dto.AddNewBookRequest;
import org.example.redtag.dto.AuthorRequest;
import org.example.redtag.dto.BookResponce;
import org.example.redtag.dto.UpdateBookRequest;
import org.example.redtag.entity.Author;
import org.example.redtag.entity.Book;
import org.example.redtag.exeption.BookAlreadyUsedException;
import org.example.redtag.exeption.BookNotFoundException;
import org.example.redtag.mapper.BookMapper;
import org.example.redtag.repository.AuthorRepository;
import org.example.redtag.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;

    public List<Book> getAll(){
        return bookRepository.getAll();
    }

    @Transactional
    public Book saveBook(AddNewBookRequest bookRequest){
        checkIfBookAlreadyExists(bookRequest);

        Author author = authorRepository.findById(Math.toIntExact(bookRequest.getAuthorId()))
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));

        Book book = bookMapper.map(bookRequest);
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    @Transactional
    public void delete(String name) {
        Book book = bookRepository.findBookByName(name);
        if (book == null) {
            throw new BookNotFoundException("Book with name " + name + " not found");
        }
        bookRepository.deleteBookByName(name);
    }

    @Transactional
    public BookResponce update(int id, UpdateBookRequest updateBookRequest){
        Book oldBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));

        Book updatedBook = bookRepository.save(bookMapper.updateBook(oldBook,updateBookRequest));
        return bookMapper.mapToBookResponce(updatedBook);
    }


    private void checkIfBookAlreadyExists(AddNewBookRequest bookRequest) {
        Book checkName = bookRepository.findBookByName(bookRequest.getName());
        if (checkName != null) {
            throw new BookAlreadyUsedException("book", "Book already exist");
        }
    }

}
