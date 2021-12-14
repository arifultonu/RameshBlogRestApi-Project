package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student ahnaf = new Student(

                    "Ahnaf",
                    "ahnaftahseen@gmail.com",
                    LocalDate.of(1995, Month.SEPTEMBER, 1),
                    27

            );

            Student shuvo = new Student(

                    "Shuvo",
                    "shuvo@gmail.com",
                    LocalDate.of(1995, Month.SEPTEMBER, 1),
                    27

            );

            repository.saveAll(
                    List.of(ahnaf, shuvo)
            );
        };
    }
}
