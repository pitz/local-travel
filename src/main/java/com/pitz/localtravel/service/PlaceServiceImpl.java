package com.pitz.localtravel.service;

import com.pitz.localtravel.domain.City;
import com.pitz.localtravel.domain.Place;
import com.pitz.localtravel.dto.city.SaveCityDTO;
import com.pitz.localtravel.dto.place.PlaceDetailsDTO;
import com.pitz.localtravel.dto.place.SavePlaceDTO;
import com.pitz.localtravel.repositories.PlaceRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    private PlaceRepository placeRepository;
    private CityService cityService;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository, CityService cityService) {
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
        validateSave(placeDTO);

        val cityDTO = placeDTO.getCity();
        City city = cityService.save(cityDTO.getName(), cityDTO.getUf(), cityDTO.getCountry());

        val place = new Place(placeDTO.getName(), city);
        return placeRepository.save(place);
    }

    private void validateSave(SavePlaceDTO placeDTO) {
        if (placeDTO.getName().isBlank()) throw new IllegalStateException("Please, inform a Name for your place.");

        Predicate<String> isNameTooShort = (String name) -> { return name.length() <= Place.NAME_MIN_LENGTH; };
        if (isNameTooShort.test(placeDTO.getName())) throw new IllegalStateException("The informed Name is too short.");
    }
}
