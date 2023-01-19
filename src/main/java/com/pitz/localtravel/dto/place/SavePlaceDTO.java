package com.pitz.localtravel.dto.place;

import com.pitz.localtravel.dto.city.SaveCityDTO;

public class SavePlaceDTO {

    private String name;

    private SaveCityDTO city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SaveCityDTO getCity() {
        return city;
    }

    public void setCity(SaveCityDTO city) {
        this.city = city;
    }
}
