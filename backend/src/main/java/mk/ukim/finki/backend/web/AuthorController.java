package mk.ukim.finki.backend.web;

import mk.ukim.finki.backend.model.Author;
import mk.ukim.finki.backend.model.Dto.AuthorDto;
import mk.ukim.finki.backend.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> listAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        var author = authorService.getAuthorById(id);

        if (author == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(author);
    }

    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody AuthorDto authorDto){
        var author = authorService.addAuthor(authorDto);

        if (author == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(author);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> editAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto){
        var author = authorService.editAuthor(id, authorDto);

        if (author == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(author);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id){
        var author = authorService.deleteAuthor(id);
        if (author == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(author);
    }
}
