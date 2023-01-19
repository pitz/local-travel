package com.pitz.localtravel.service;

import com.pitz.localtravel.domain.City;
import com.pitz.localtravel.domain.Place;
import com.pitz.localtravel.dto.city.SaveCityDTO;
import com.pitz.localtravel.dto.place.PlaceDetailsDTO;
import com.pitz.localtravel.dto.place.SavePlaceDTO;
import com.pitz.localtravel.repositories.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlaceService {

    private PlaceRepository placeRepository;
    private CityService cityService;

    @Autowired
    public PlaceService(PlaceRepository placeRepository, CityService cityService) {
        this.placeRepository = placeRepository;
        this.cityService = cityService;
    }

    public List<PlaceDetailsDTO> list() {
        return placeRepository.findAll()
                              .parallelStream()
                              .map(PlaceDetailsDTO::new)
                              .collect(Collectors.toList());
    }

    public Place save(SavePlaceDTO placeDTO) {
        System.out.println(placeRepository.findAll());

        validateSave(placeDTO);

        SaveCityDTO cityDTO = placeDTO.getCity();
        City city = cityService.save(cityDTO.getName(), cityDTO.getUf(), cityDTO.getCountry());

        Place place = new Place(placeDTO.getName(), city);
        place = placeRepository.save(place);

        System.out.println(place);
        System.out.println(place.getId());
        System.out.println(place.getCreatedAt());

        return place;
    }

    private void validateSave(SavePlaceDTO placeDTO) {
        if (placeDTO.getName().isBlank()) throw new IllegalStateException("Please, inform a Name for your place.");
    }
}
