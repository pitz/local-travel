package com.pitz.localtravel.dto.place;

import com.pitz.localtravel.dto.city.SaveCityDTO;

import lombok.Getter;
import lombok.Setter;

public class SavePlaceDTO {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private SaveCityDTO city;

}
