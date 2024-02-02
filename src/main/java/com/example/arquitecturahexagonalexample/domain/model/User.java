package com.example.arquitecturahexagonalexample.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String cellphone;
    private String password;

    //private List<Product> products;

}
