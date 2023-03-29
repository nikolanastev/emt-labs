package mk.ukim.finki.backend.web;

import mk.ukim.finki.backend.model.Country;
import mk.ukim.finki.backend.model.Dto.CountryDto;
import mk.ukim.finki.backend.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin("http://localhost:3000")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id){
        var country = countryService.getCountryById(id);

        if (country == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(country);
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody CountryDto countryDto){
        var country = countryService.addCountry(countryDto);

        if (country == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(country);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable Long id, @RequestBody CountryDto countryDto){
        var country = countryService.editCountry(id, countryDto);

        if (country == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(country);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id){
        var country = countryService.deleteCountry(id);

        if (country == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(country);
    }
}
