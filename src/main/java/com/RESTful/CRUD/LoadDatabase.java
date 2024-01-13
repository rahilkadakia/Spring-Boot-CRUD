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
      log.info("Preloading " + repository.save(new Customer("Charlie", Long.valueOf("100"), LocalDate.of(2023, 10, 1))));
      log.info("Preloading " + repository.save(new Customer("Alan", Long.valueOf("40"), LocalDate.of(2024, 1, 5))));
      log.info("Preloading " + repository.save(new Customer("Jake", Long.valueOf("80"), LocalDate.of(2022, 9, 28))));
    };
  }
}