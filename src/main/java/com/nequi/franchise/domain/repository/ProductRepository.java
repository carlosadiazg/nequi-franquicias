package com.nequi.franchise.domain.repository;

import com.nequi.franchise.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Mono<Product> save(Product product);

    Mono<Product> findById(Long id);
    Flux<Product> findAll();

    Mono<Void> delete(Long id);
}
