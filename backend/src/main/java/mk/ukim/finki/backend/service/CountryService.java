package mk.ukim.finki.backend.service;

import mk.ukim.finki.backend.model.Country;
import mk.ukim.finki.backend.model.Dto.CountryDto;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();
    Country getCountryById(Long countryId);
    Country addCountry(CountryDto countryDto);
    Country editCountry(Long id, CountryDto countryDto);
    Country deleteCountry(Long id);
}
