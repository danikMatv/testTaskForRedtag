package org.example.redtag.mapper;


import org.example.redtag.dto.BookResponce;
import org.example.redtag.dto.UpdateBookRequest;
import org.example.redtag.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponce mapToBookResponce(Book newBook);

    Book updateBook(@MappingTarget Book book, UpdateBookRequest updateBookRequest);
}
