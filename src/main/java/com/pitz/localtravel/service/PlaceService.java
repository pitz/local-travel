package com.pitz.localtravel.service;

import com.pitz.localtravel.domain.City;
import com.pitz.localtravel.domain.Place;
import com.pitz.localtravel.dto.place.CityDTO;
import com.pitz.localtravel.dto.place.SavePlaceDTO;
import com.pitz.localtravel.repositories.CityRepository;
import com.pitz.localtravel.repositories.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlaceService {

    private PlaceRepository placeRepository;
    private CityRepository cityRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository, CityRepository cityRepository) {
        this.placeRepository = placeRepository;
        this.cityRepository = cityRepository;
    }

    public List<Place> list() {
        return placeRepository.findAll();
    }

    public void save(SavePlaceDTO placeDTO) {
        validateSave(placeDTO);
    }

    private void validateSave(SavePlaceDTO placeDTO) {
        CityDTO cityDTO = placeDTO.getCity();

        System.out.println(placeDTO.toString());

        System.out.println(cityDTO.getName());
        System.out.println(cityDTO.getUf());
        System.out.println(cityDTO.getCountry());

//        ; TODO:
//        VALIDATE AND SAVE
        Optional<City> city = cityRepository.findCityByNameAndCountryAndUf(cityDTO.getName(),
                                                                           cityDTO.getCountry(),
                                                                           cityDTO.getUf());

//        if (city.isPresent()) throw new IllegalStateException("Não é um erro de verdade.");
    }
}
