package com.pitz.localtravel.dto.place;

public class SavePlaceDTO {

    private String name;

    private CityDTO city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
}
