package com.example.customer_service;

import com.example.customer_service.entities.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(CustomerConfigParam.class)

public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration configuration){
        return args -> {
            configuration.exposeIdsFor(Customer.class);
            // Sample data
            customerRepository.save(new Customer("john","john@gmail.com"));
            customerRepository.save(new Customer("jane","jane@gmail.com"));
            customerRepository.save(new Customer("tom","tom@gmail.com"));



        };

}}
