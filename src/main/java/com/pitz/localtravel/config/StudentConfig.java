package com.pitz.localtravel.config;

import com.pitz.localtravel.domain.Student;
import com.pitz.localtravel.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student eduardo = new Student("Eduardo",
                    "eduardo@pitz.dev",
                    LocalDate.of(1995, Month.JULY, 1));

            Student raquel = new Student("Raquel",
                    "raquel@pitz.dev",
                    LocalDate.of(1997, Month.JULY, 1));
//            repository.saveAll(List.of(eduardo, raquel));
        };
    }
}
