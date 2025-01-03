package com.example.customer_service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="customer.params")
public record CustomerConfigParam(int x, int y) {

}
