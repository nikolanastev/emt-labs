package mk.ukim.finki.backend.model.Dto;

import mk.ukim.finki.backend.model.Enums.Genre;


public record BookDto(String name, Genre genre, Long author, Integer availableCopies) {
}
