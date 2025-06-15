package com.nequi.franchise.infrastructure.mapper;

import com.nequi.franchise.domain.Product;
import com.nequi.franchise.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryMapper {

    public Product toDomain(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setStock(productEntity.getStock());
        return product;
    }

    public ProductEntity toEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setStock(product.getStock());
        return productEntity;
    }
}
