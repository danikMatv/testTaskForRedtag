package org.example.redtag.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class AddNewBookRequest {

    public static final String YEAR = "^\\d{4}$";

    @NotBlank(message = "Name cannot be empty! ")
    @Pattern(regexp = "[A-Z][a-z]+",
            message = "Must start with a capital letter")
    private String mame;

    @NotBlank(message = "Year cannot be empty! ")
    @Pattern(regexp = YEAR,message = "Year must be a 4 digit number")
    private Long year;

    private String description;

    @NotNull(message = "Author cannot be empty")
    private String author;

    @NotNull(message = "Genre cannot be empty")
    private String genre;
}
