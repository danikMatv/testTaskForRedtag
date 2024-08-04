package org.example.redtag.mapper;

import org.example.redtag.dto.AuthorRequest;
import org.example.redtag.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author map(AuthorRequest request);
}
