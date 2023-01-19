package com.pitz.localtravel.dto.place;

import com.pitz.localtravel.domain.Place;
import com.pitz.localtravel.dto.city.CityDetailsDTO;

import java.util.Date;

public class PlaceDetailsDTO {

    private Long id;

    private String name;

    private CityDetailsDTO city;

    private Date createdAt;

    public PlaceDetailsDTO(Place place) {
        System.out.println(place);

        this.id = place.getId();
        this.name = place.getName();
        this.city = new CityDetailsDTO(place.getCity());
        this.createdAt = place.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CityDetailsDTO getCity() {
        return city;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
