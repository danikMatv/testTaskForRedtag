package org.example.redtag.mapper;

import org.example.redtag.dto.AuthorRequest;
import org.example.redtag.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper {
    Author map(AuthorRequest request);
}
