package mk.ukim.finki.backend.service;

import mk.ukim.finki.backend.model.Book;
import mk.ukim.finki.backend.model.Dto.BookDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book addBook(BookDto bookDto);
    Book editBook(Long id, BookDto bookDto);
    Book deleteBook(Long id);
    Book markBookAsTaken(Long id);
    List<Book> getAllBooksByPage(Pageable withPage);

}
