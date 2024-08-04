package org.example.redtag.controller;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.example.redtag.dto.AddNewBookRequest;
import org.example.redtag.dto.BookResponce;
import org.example.redtag.dto.UpdateBookRequest;
import org.example.redtag.entity.Book;
import org.example.redtag.service.BookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookContoller {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAll(Model model){
        model.addAttribute("library",bookService);
        return bookService.getAll();
    }

    @PostMapping("/Add")
    public Book addNewBook(@Valid @RequestBody AddNewBookRequest newBookRequest){
        return bookService.saveBook(newBookRequest);
    }

    @PutMapping("{id}")
    public BookResponce update(@PathVariable Long id, @Valid @RequestBody UpdateBookRequest request){

        return bookService.update(Math.toIntExact(id),request);
    }
}
