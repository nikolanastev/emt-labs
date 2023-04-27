package mk.ukim.finki.backend.service.impl;

import mk.ukim.finki.backend.model.Book;
import mk.ukim.finki.backend.model.Dto.BookDto;
import mk.ukim.finki.backend.repository.BookRepository;
import mk.ukim.finki.backend.service.AuthorService;
import mk.ukim.finki.backend.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book addBook(BookDto bookDto) {
        var book = new Book();
        return saveBook(bookDto, book);
    }

    @Override
    public Book editBook(Long id, BookDto bookDto) {
        var book = bookRepository.findById(id).orElse(null);

        if (book == null)
            return null;

        return saveBook(bookDto, book);
    }

    @Override
    public Book deleteBook(Long id) {
        var book = getBookById(id);
        if (book == null)
            return null;
        bookRepository.deleteById(id);
        return book;
    }

    @Override
    public Book markBookAsTaken(Long id) {
        var book = bookRepository.findById(id).orElse(null);

        if (book == null)
             return null;

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> getAllBooksByPage(Pageable withPage) {
        return bookRepository.findAll(withPage).getContent();
    }

    private Book saveBook(BookDto bookDto, Book book){
        var author = authorService.getAuthorById(bookDto.author());

        if (author == null)
            return null;

        book.setName(bookDto.name());
        book.setGenre(bookDto.genre());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.availableCopies());

        return bookRepository.save(book);
    }
}
