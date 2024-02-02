package com.example.arquitecturahexagonalexample.infrastructure.adaptador;

import com.example.arquitecturahexagonalexample.domain.model.Product;
import com.example.arquitecturahexagonalexample.domain.puerto.ProductRepository;
import com.example.arquitecturahexagonalexample.infrastructure.entity.ProductEntity;
import com.example.arquitecturahexagonalexample.infrastructure.exceptions.ResourceNotFoundException;
import com.example.arquitecturahexagonalexample.infrastructure.rest.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class ProductRepositoryMySQL implements ProductRepository {

    private final ProductCrudRepositoryMySQL productCrudRepository;

    @Autowired(required = false)
    private ProductMapper productMapper;

    public ProductRepositoryMySQL(ProductCrudRepositoryMySQL productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    @Override
    public Iterable<Product> getProducts() {
        return this.productMapper.toProducts(this.productCrudRepository.findAll());
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        ProductEntity product = this.productCrudRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        return Optional.of((Product) this.productMapper.toProduct(product));
    }

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = this.productMapper.toProductEntity(product);
        System.out.println("Code: "+ productEntity.getCode());
        return (Product) this.productMapper.toProduct(this.productCrudRepository.save(productEntity));
    }

    @Override
    public void deleteProductById(Integer id) {
        ProductEntity productEntity = this.productCrudRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        this.productCrudRepository.deleteById(productEntity.getId());
    }
}
