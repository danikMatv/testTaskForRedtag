package org.example.redtag.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.redtag.dto.AddNewBookRequest;
import org.example.redtag.dto.BookResponce;
import org.example.redtag.dto.FilterAuthor;
import org.example.redtag.dto.UpdateBookRequest;
import org.example.redtag.entity.Book;
import org.example.redtag.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @PostMapping()
    public Book addNewBook(@Valid @RequestBody AddNewBookRequest newBookRequest) {
        return bookService.saveBook(newBookRequest);
    }

    @PutMapping("/{id}")
    public BookResponce update(@PathVariable Long id, @Valid @RequestBody UpdateBookRequest request) {
        return bookService.update(Math.toIntExact(id), request);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam String name) {
        bookService.delete(name);
    }

    @PostMapping("/list")
    public List<Book> sortBooks(@RequestParam String sortCriteria) {
        List<Book> allBooks = bookService.getAll();
        return bookService.sortBySortType(sortCriteria, allBooks);
    }

    @PostMapping("/search")
    public List<Book> filterBooks(@Valid @RequestBody FilterAuthor filterAuthor){
        List<Book> allBooks = bookService.getAll();
        return bookService.filterBooksByParam(filterAuthor,allBooks);
    }

}