package mk.ukim.finki.backend.service.impl;

import mk.ukim.finki.backend.model.Country;
import mk.ukim.finki.backend.model.Dto.CountryDto;
import mk.ukim.finki.backend.repository.CountryRepository;
import mk.ukim.finki.backend.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long countryId) {
        return countryRepository.findById(countryId).orElse(null);
    }

    @Override
    public Country addCountry(CountryDto countryDto) {
        var country = new Country();
        country.setName(countryDto.name());
        country.setContinent(countryDto.continent());
        return countryRepository.save(country);
    }

    @Override
    public Country editCountry(Long id, CountryDto countryDto) {
        var country = countryRepository.findById(id).orElse(null);
        if (country == null)
            return null;

        country.setName(countryDto.name());
        country.setContinent(countryDto.continent());

        return countryRepository.save(country);
    }

    @Override
    public Country deleteCountry(Long id) {
        var country = getCountryById(id);
        if (country == null)
            return null;
        countryRepository.deleteById(id);
        return country;
    }
}
