package com.example.arquitecturahexagonalexample.infrastructure.adaptador;

import com.example.arquitecturahexagonalexample.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCrudRepositoryMySQL extends JpaRepository<ProductEntity, Integer> {
}
