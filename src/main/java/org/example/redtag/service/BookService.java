package org.example.redtag.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.redtag.dto.AddNewBookRequest;
import org.example.redtag.dto.BookResponce;
import org.example.redtag.dto.UpdateBookRequest;
import org.example.redtag.entity.Book;
import org.example.redtag.exeption.BookAlreadyUsedException;
import org.example.redtag.exeption.BookNotFoundException;
import org.example.redtag.mapper.BookMapper;
import org.example.redtag.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    public List<Book> getAll(){
        return bookRepository.getAll();
    }

    @Transactional
    public Book saveBook(AddNewBookRequest bookRequest){
        checkIfBookAlreadyExists(bookRequest);
        Book book = save(bookRequest);
        return book;
    }

    @Transactional
    public void delete(String name){
        Book book = bookRepository.findBookByName(name);
        bookRepository.deleteById(Math.toIntExact(book.getId()));
    }

    @Transactional
    public BookResponce update(int id, UpdateBookRequest updateBookRequest){
        Book oldBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));

        Book updatedBook = bookRepository.save(bookMapper.updateBook(oldBook,updateBookRequest));
        return bookMapper.mapToBookResponce(updatedBook);
    }


    private void checkIfBookAlreadyExists(AddNewBookRequest bookRequest) {
        Book checkName = bookRepository.findBookByName(bookRequest.getMame());
        if (checkName != null){
            throw new BookAlreadyUsedException("book","Book already exist");
        }
    }

    private Book save(AddNewBookRequest bookRequest){
        Book book = bookMapper.map(bookRequest);
        return bookRepository.save(book);
    }
}
