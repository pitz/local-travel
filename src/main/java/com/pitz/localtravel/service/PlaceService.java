package com.pitz.localtravel.service;

import com.pitz.localtravel.domain.Place;
import com.pitz.localtravel.dto.place.PlaceDetailsDTO;
import com.pitz.localtravel.dto.place.SavePlaceDTO;
import java.util.List;

public interface PlaceService {
    public List<PlaceDetailsDTO> list();
    public Place save(SavePlaceDTO placeDTO);
}
