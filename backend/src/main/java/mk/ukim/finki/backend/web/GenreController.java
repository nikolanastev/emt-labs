package mk.ukim.finki.backend.web;

import mk.ukim.finki.backend.model.Enums.Genre;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("http://localhost:3000")
public class GenreController {

    @GetMapping
    public List<Genre> getAllGenres() {
        return Arrays.asList(Genre.values());
    }
}
