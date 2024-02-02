package com.example.arquitecturahexagonalexample.infrastructure.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String code;
    @Size(min = 4, max = 50, message = "Nombre de producto debe contener al menos 5 caracteres")
    @NotBlank(message = "Nombre de producto no debe estar en blanco")
    private String name;
    @NotBlank(message = "Descripción de producto no debe estar vacío")
    private String description;
    private String urlImage;
    @NotNull(message = "Precio de producto es requerido")
    @Positive(message = "Precio no debe ser un número negativo o cero")
    private Double price;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;


}
