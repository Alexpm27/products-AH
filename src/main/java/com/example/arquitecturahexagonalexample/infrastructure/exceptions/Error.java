package com.example.arquitecturahexagonalexample.infrastructure.exceptions;

import lombok.Data;

@Data
public class Error {
    private String code;
    private String message;

}
