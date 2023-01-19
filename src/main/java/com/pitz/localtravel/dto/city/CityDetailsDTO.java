package com.pitz.localtravel.dto.city;

import com.pitz.localtravel.domain.City;

public class CityDetailsDTO {

    private Long id;

    private String name;

    private String uf;

    private String country;

    public CityDetailsDTO(City city) {
        this.id = city.getId();
        this.name = city.getName();
        this.uf = city.getUf();
        this.country = city.getCountry();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUf() {
        return uf;
    }

    public String getCountry() {
        return country;
    }
}
