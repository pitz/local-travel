package com.pitz.localtravel.controllers;

import com.pitz.localtravel.dto.place.PlaceDetailsDTO;
import com.pitz.localtravel.dto.place.SavePlaceDTO;
import com.pitz.localtravel.service.PlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/places")
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/list")
    public List<PlaceDetailsDTO> list() {
        return placeService.list();
    }

    @PostMapping()
    public void save(@RequestBody SavePlaceDTO savePlaceDTO) {
        placeService.save(savePlaceDTO);
    }

}
