package com.nequi.franchise.application;

import com.nequi.franchise.domain.Product;
import com.nequi.franchise.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Mono<Product> create(Product product) {
        return productRepository.save(product);
    }

    public Flux<Product> list() {
        return productRepository.findAll();
    }
}
