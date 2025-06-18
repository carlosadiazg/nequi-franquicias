package com.nequi.franchise.presentation.mappers;

import com.nequi.franchise.domain.Product;
import com.nequi.franchise.presentation.dto.product.ProductPresentationRequest;
import com.nequi.franchise.presentation.dto.product.ProductPresentationResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductPresentationMapper {

    public Product toApplication(ProductPresentationRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setStock(request.getStock());
        return product;
    }

    public ProductPresentationResponse toInfrastructure(Product product) {
        ProductPresentationResponse response = new ProductPresentationResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setStock(product.getStock());
        return response;
    }
}
