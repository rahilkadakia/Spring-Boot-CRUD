package com.RESTful.CRUD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(CustomerRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Customer(1, "Charlie", Double.valueOf("100"), LocalDate.of(2023, 10, 1))));
      log.info("Preloading " + repository.save(new Customer(2, "Alan", Double.valueOf("40"), LocalDate.of(2024, 1, 5))));
      log.info("Preloading " + repository.save(new Customer(3, "Jake", Double.valueOf("80"), LocalDate.of(2022, 9, 28))));
    };
  }
}