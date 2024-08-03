package org.example.redtag.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.redtag.dto.BookResponce;
import org.example.redtag.dto.UpdateBookRequest;
import org.example.redtag.entity.Book;
import org.example.redtag.exeption.BookNotFoundException;
import org.example.redtag.mapper.BookMapper;
import org.example.redtag.repository.BookRepository;
import org.springframework.stereotype.Service;

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
    public Book save(Book book){
        return bookRepository.save(book);
    }

    @Transactional
    public void delete(String name){
        Book book = bookRepository.findBookByName(name);
        bookRepository.deleteById(Math.toIntExact(book.getId()));
    }

    @Transactional
    public BookResponce update(int id, UpdateBookRequest updateBookRequest){
        Book oldBook = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

        Book updatedBook = bookRepository.save(bookMapper.updateBook(oldBook,updateBookRequest));
        return bookMapper.mapToBookResponce(updatedBook);
    }

}
