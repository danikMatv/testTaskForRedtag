package org.example.redtag.dto;

import lombok.Builder;
import lombok.Data;
import org.example.redtag.entity.Genre;

@Data
@Builder
public class UpdateBookRequest {

    private String name;
    private Long year;
    private String description;
    private Long authorId;
    private Genre genre;

}
