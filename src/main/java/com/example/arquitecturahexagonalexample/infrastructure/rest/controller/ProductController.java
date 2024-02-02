package com.example.arquitecturahexagonalexample.infrastructure.rest.controller;

import com.example.arquitecturahexagonalexample.application.service.ProductService;
import com.example.arquitecturahexagonalexample.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> getProducts(){
        return new ResponseEntity<>(this.productService.getProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        log.info("Save product");
        log.info("Product: {}",product);
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct (@PathVariable Integer id){
        log.info("Id "+id);
        log.info("Product {}",this.productService.getProductById(id));
        return new ResponseEntity<>(this.productService.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        this.productService.deleteProduct(id);
    }

}
