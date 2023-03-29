package mk.ukim.finki.backend.service;


import mk.ukim.finki.backend.model.Author;
import mk.ukim.finki.backend.model.Dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    Author addAuthor(AuthorDto author);
    Author editAuthor(Long id, AuthorDto author);
    Author deleteAuthor(Long id);

}
