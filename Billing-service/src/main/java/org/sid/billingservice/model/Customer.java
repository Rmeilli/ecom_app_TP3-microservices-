package org.sid.billingservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Data
public class Customer {
    private Long id;
    private String name;
    private String email;
}
