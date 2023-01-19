package com.pitz.localtravel.repositories;

import com.pitz.localtravel.domain.City;
import com.pitz.localtravel.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

}
