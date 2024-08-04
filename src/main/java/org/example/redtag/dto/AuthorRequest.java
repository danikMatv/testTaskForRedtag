package org.example.redtag.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class AuthorRequest {

    @NotBlank(message = "Name cannot be empty! ")
    @Pattern(regexp = "[A-Z][a-z]+",
            message = "Must start with a capital letter")
    private String name;
    @NotBlank(message = "Name cannot be empty! ")
    @Pattern(regexp = "[A-Z][a-z]+",
            message = "Must start with a capital letter")
    private String surName;

    @NotBlank(message = "Year cannot be empty! ")
    private Long age;

    private String nationality;

}
