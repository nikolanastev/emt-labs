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
            var author6 = new Author("Lorem 3", "Ipsum 3", country5);
            authorRepository.save(author6);

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



            var country6 = new Country("Lorem", "Europe");
            countryRepository.save(country6);
            var country7 = new Country("Ipsiumium", "North America");
            countryRepository.save(country7);
            var country8 = new Country("Mina", "Asia");
            countryRepository.save(country8);
            var country9 = new Country("Chile", "South America");
            countryRepository.save(country9);
            var country10 = new Country("Tunis", "Africa");
            countryRepository.save(country10);

            var author12 = new Author("Loremiumius", "Ipsiumiumius", country10);
            authorRepository.save(author12);
            var author7 = new Author("Mearnest", "Wayheming", country7);
            authorRepository.save(author7);
            var author8 = new Author("Aling", "Zhang", country8);
            authorRepository.save(author8);
            var author9 = new Author("Lorem 9", "Ipsum 9", country9);
            authorRepository.save(author9);
            var author10 = new Author("Lorem 10", "Ipsum 10", country10);
            authorRepository.save(author10);
            var author11 = new Author("Lorem 11", "Ipsum 11",country10);
            authorRepository.save(author11);

            var book6 = new Book("Mirej", Genre.FANTASY, author6,15);
            bookRepository.save(book6);
            var book7 = new Book("For Bell the Whom Tolls", Genre.CLASSICS, author7, 10);
            bookRepository.save(book7);
            var book8 = new Book("Lorem Book 8", Genre.NOVEL, author8, 5);
            bookRepository.save(book8);
            var book9 = new Book("Lorem Book 9", Genre.DRAMA, author9, 4);
            bookRepository.save(book9);
            var book10 = new Book("Lorem Book 10", Genre.THRILLER, author10, 1);
            bookRepository.save(book10);
        }
    }

}
