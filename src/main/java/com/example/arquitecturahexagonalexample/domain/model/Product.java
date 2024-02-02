package com.example.arquitecturahexagonalexample.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Product {
    private Integer id;
    private  String code;
    private String name;
    private String description;
    private String urlImage;
    private Double price;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

}
