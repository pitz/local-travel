package com.pitz.localtravel.service;

import com.pitz.localtravel.domain.City;

public interface CityService {
    public City save(String name, String uf, String country);
}
