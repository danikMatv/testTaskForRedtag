package org.example.redtag.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Genre {

    FANTASY("Fantasy"),
    SCIENCE_FICTION("Science fiction"),
    DRAMA("Drama"),
    FICTION("Fiction"),
    MYSTERY("Mystery"),
    THRILLER("Thriller"),
    ROMANCE("Romance"),
    HISTORICAL_FICTION("Historical finction"),
    COMEDY("Comedy"),
    POETRY("Poetry"),
    MEMOIR("Memoir");

    private final String name;

    @JsonCreator
    public static Genre forValue(String value) {
        return Arrays.stream(Genre.values())
                .filter(faculty -> faculty.getName().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown genre: " + value));
    }

    @JsonValue
    public String getName() {
        return name;
    }

    }
