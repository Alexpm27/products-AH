package com.example.arquitecturahexagonalexample.infrastructure.conf;

import com.example.arquitecturahexagonalexample.application.service.DomainProductService;
import com.example.arquitecturahexagonalexample.application.service.ProductService;
import com.example.arquitecturahexagonalexample.domain.puerto.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProductConfiguration {

    @Bean
    ProductService productBeanService(final ProductRepository productRepository){
        return new DomainProductService(productRepository);
    }
}
