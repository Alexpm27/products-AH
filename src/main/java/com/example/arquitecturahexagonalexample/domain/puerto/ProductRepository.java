package com.example.arquitecturahexagonalexample.domain.puerto;

import com.example.arquitecturahexagonalexample.domain.model.Product;

import java.util.Optional;

public interface ProductRepository {
    Iterable<Product> getProducts();
    Optional <Product> getProduct (Integer id);
    Product saveProduct (Product product);
    void deleteProductById(Integer id);
}
