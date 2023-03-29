package mk.ukim.finki.backend.service.impl;

import mk.ukim.finki.backend.model.Author;
import mk.ukim.finki.backend.model.Dto.AuthorDto;
import mk.ukim.finki.backend.repository.AuthorRepository;
import mk.ukim.finki.backend.service.AuthorService;
import mk.ukim.finki.backend.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author addAuthor(AuthorDto authorDto) {
        var author = new Author();
        return saveAuthor(authorDto, author);
    }

    @Override
    public Author editAuthor(Long id, AuthorDto authorDto) {
        var author = authorRepository.findById(id).orElse(null);

        if (author == null)
            return null;

        return saveAuthor(authorDto, author);
    }

    @Override
    public Author deleteAuthor(Long id) {
        var author = getAuthorById(id);
        if (author == null)
            return null;
        authorRepository.deleteById(id);
        return author;
    }

    private Author saveAuthor(AuthorDto authorDto, Author author){
        var country = countryService.getCountryById(authorDto.countryId());

        if (country == null)
            return null;

        author.setName(authorDto.name());
        author.setSurname(authorDto.surname());
        author.setCountry(country);

        return authorRepository.save(author);
    }
}
