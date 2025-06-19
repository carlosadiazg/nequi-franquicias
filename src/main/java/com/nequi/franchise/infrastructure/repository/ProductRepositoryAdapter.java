package com.nequi.franchise.infrastructure.repository;

import com.nequi.franchise.domain.Product;
import com.nequi.franchise.domain.repository.ProductRepository;
import com.nequi.franchise.infrastructure.mapper.ProductRepositoryMapper;
import com.nequi.franchise.infrastructure.r2dbc.ProductR2dbcRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductR2dbcRepository productR2dbcRepository;
    private final ProductRepositoryMapper productRepositoryMapper;

    public ProductRepositoryAdapter(ProductR2dbcRepository productR2dbcRepository, ProductRepositoryMapper productRepositoryMapper) {
        this.productR2dbcRepository = productR2dbcRepository;
        this.productRepositoryMapper = productRepositoryMapper;
    }

    @Override
    public Mono<Product> save(Product product) {
        return productR2dbcRepository
                .save(productRepositoryMapper.toEntity(product))
                .map(productRepositoryMapper::toDomain);
    }

    @Override
    public Mono<Product> findById(Long id) {
        return productR2dbcRepository.findById(id)
                .map(productRepositoryMapper::toDomain);
    }

    @Override
    public Flux<Product> findAll() {
        return productR2dbcRepository
                .findAll()
                .map(productRepositoryMapper::toDomain);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return productR2dbcRepository.deleteById(id);
    }

    @Override
    public Flux<Product> findMaxStockByIdFranchise(Long id) {
        return productR2dbcRepository.findMaxStockByIdFranchise(id)
                .map(productRepositoryMapper::toDomain);
    }
}
