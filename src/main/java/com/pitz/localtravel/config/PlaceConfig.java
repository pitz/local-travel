package com.pitz.localtravel.config;

import com.pitz.localtravel.domain.City;
import com.pitz.localtravel.domain.Place;
import com.pitz.localtravel.repositories.PlaceRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaceConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlaceRepository repository) {
        return args -> {
            new Place("Padaria da Vila", new City("Joinville", "SC", "Brazil"));
            new Place("Padaria Doce Beijo", new City("Bal. Barra do Sul", "SC", "Brazil"));
        };
    }
}
