package com.example.arquitecturahexagonalexample.application.service;

import com.example.arquitecturahexagonalexample.domain.model.Product;

public interface ProductService {
    Iterable<Product> getProducts();
    Product getProductById (Integer id);
    Product saveProduct (Product product);
    void deleteProduct(Integer id);
}
