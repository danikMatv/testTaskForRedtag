package org.example.redtag.dto;

import lombok.Builder;

@Builder
public record BookResponce(Long id,
                           String name,
                           Long year,
                           String description,
                           String genre) {
}
