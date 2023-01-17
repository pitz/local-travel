package com.pitz.localtravel.repositories;

import com.pitz.localtravel.domain.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT c FROM City c " +
            "WHERE c.name    = ?1 AND " +
            "      c.country = ?2 AND " +
            "      c.uf      = ?3")
    Optional<City> findCityByNameAndCountryAndUf(String name, String country, String uf);

}
