package org.example.redtag.mapper;


import org.example.redtag.dto.AddNewBookRequest;
import org.example.redtag.dto.BookResponce;
import org.example.redtag.dto.UpdateBookRequest;
import org.example.redtag.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    BookResponce mapToBookResponce(Book newBook);
    Book map(AddNewBookRequest bookRequest);

    Book updateBook(@MappingTarget Book book, UpdateBookRequest updateBookRequest);
}
