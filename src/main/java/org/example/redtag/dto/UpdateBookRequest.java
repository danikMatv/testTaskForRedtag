package org.example.redtag.dto;

import lombok.Builder;
import lombok.Data;
import org.example.redtag.entity.Author;
import org.example.redtag.entity.Genre;
import org.hibernate.annotations.processing.Pattern;

@Data
@Builder
public class UpdateBookRequest {

    private Genre genre;
    private String name;
    private Long year;
    private String description;
    private Author author;

}
