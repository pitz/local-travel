package com.pitz.localtravel.repositories;

import com.pitz.localtravel.domain.City;
import com.pitz.localtravel.domain.Place;
import com.pitz.localtravel.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Optional<Student> findPlaceByNameAndCity(String name, City city);

    @Query("SELECT s FROM Place s WHERE s.name = ?1")
    Optional<Student> findPlaceByName(String name);

}
