package org.sid.billingservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private Double price;
    private int quantity;
}
