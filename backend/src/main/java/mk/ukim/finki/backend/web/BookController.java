package mk.ukim.finki.backend.web;

import jakarta.validation.Valid;
import mk.ukim.finki.backend.model.Book;
import mk.ukim.finki.backend.model.Dto.BookDto;
import mk.ukim.finki.backend.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping
    public List<Book> getAllWithPagination(Pageable pageable){
        return bookService.getAllBooksByPage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        var book = bookService.getBookById(id);

        if (book == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(book);
    }
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookDto bookDto){
        var book = bookService.addBook(bookDto);

        if (book == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(book);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        var book = bookService.editBook(id, bookDto);
        if (book == null)
            return ResponseEntity.notFound().build();
        return  ResponseEntity.ok(book);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
        var book = bookService.deleteBook(id);
        if (book == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(book);
    }

    @PutMapping("mark/{id}")
    public ResponseEntity<Book> markBook(@PathVariable Long id){
        var book = bookService.markBookAsTaken(id);
        if (book == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(book);
    }
}
