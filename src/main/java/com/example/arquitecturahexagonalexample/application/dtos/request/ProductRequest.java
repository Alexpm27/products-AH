package com.example.arquitecturahexagonalexample.application.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductRequest {
    private  String code;
    private String name;
    private String description;
    private String urlImage;
    private Double price;
}
