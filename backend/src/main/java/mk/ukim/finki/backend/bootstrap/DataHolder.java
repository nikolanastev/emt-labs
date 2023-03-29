package mk.ukim.finki.backend.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.backend.model.Author;
import mk.ukim.finki.backend.model.Book;
import mk.ukim.finki.backend.model.Country;
import mk.ukim.finki.backend.model.Enums.Genre;
import mk.ukim.finki.backend.repository.AuthorRepository;
import mk.ukim.finki.backend.repository.BookRepository;
import mk.ukim.finki.backend.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataHolder {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public DataHolder(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        if (countryRepository.findAll().size() == 0 || authorRepository.findAll().size() == 0 || bookRepository.findAll().size() == 0) {
            var country1 = new Country("Macedonia", "Europe");
            countryRepository.save(country1);
            var country2 = new Country("USA", "North America");
            countryRepository.save(country2);
            var country3 = new Country("China", "Asia");
            countryRepository.save(country3);
            var country4 = new Country("Brazil", "South America");
            countryRepository.save(country4);
            var country5 = new Country("Congo", "Africa");
            countryRepository.save(country5);

            var author1 = new Author("Petre", "Andreevski", country1);
            authorRepository.save(author1);
            var author2 = new Author("Ernest", "Hemingway", country2);
            authorRepository.save(author2);
            var author3 = new Author("Zhang", "Ailing", country3);
            authorRepository.save(author3);
            var author4 = new Author("Lorem 1", "Ipsum 1", country4);
            authorRepository.save(author4);
            var author5 = new Author("Lorem 2", "Ipsum 2", country5);
            authorRepository.save(author5);

            var book1 = new Book("Pirej", Genre.HISTORY, author1,50);
            bookRepository.save(book1);
            var book2 = new Book("For Whom the Bell Tolls", Genre.NOVEL, author2, 10);
            bookRepository.save(book2);
            var book3 = new Book("Lorem Book 1", Genre.BIOGRAPHY, author3, 5);
            bookRepository.save(book3);
            var book4 = new Book("Lorem Book 2", Genre.DRAMA, author4, 2);
            bookRepository.save(book4);
            var book5 = new Book("Lorem Book 3", Genre.THRILLER, author5, 0);
            bookRepository.save(book5);

        }
    }

}
