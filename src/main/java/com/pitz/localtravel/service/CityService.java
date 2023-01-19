package com.pitz.localtravel.service;

import com.pitz.localtravel.domain.City;
import com.pitz.localtravel.repositories.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City save(String name, String uf, String country) {
        Optional<City> city = cityRepository.findCityByNameAndCountryAndUf(name, country, uf);
        if (city.isPresent()) return city.get();

        validateSave(name, uf, country);

        City newCity = new City(name, uf, country);
        newCity = cityRepository.save(newCity);
        return newCity;
    }

    private void validateSave(String name, String uf, String country) {
        if (name.isBlank()) throw new IllegalStateException("Please, inform a valid Name for the City.");
        if (uf.isBlank()) throw new IllegalStateException("Please, inform a valid UF for the City.");
        if (country.isBlank()) throw new IllegalStateException("Please, inform a valid Country for the City.");
    }
}
