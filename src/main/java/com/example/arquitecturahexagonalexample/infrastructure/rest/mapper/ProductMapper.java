package com.example.arquitecturahexagonalexample.infrastructure.rest.mapper;

import com.example.arquitecturahexagonalexample.domain.model.Product;
import com.example.arquitecturahexagonalexample.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;
@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
           //@Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "dateUpdated", target = "dateUpdated")
            }
    )
    ProductMapper toProduct(ProductEntity producto);
    Iterable<Product> toProducts(Iterable<ProductEntity> productoEntity);

    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);

}
