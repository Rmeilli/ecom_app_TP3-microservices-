package com.example.inventoryservice;

import com.example.inventoryservice.entities.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration configuration){
        return args -> {
            configuration.exposeIdsFor(Product.class);
            // Sample data
            productRepository.save(new Product("PC", 100.0, 100));
            productRepository.save(new Product("Com2", 200.0, 200));
            productRepository.save(new Product("Cam", 300.0, 300));
        };

    }
}

