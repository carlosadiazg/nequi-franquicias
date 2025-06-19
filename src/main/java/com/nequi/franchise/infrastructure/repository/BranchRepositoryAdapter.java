package com.nequi.franchise.infrastructure.repository;

import com.nequi.franchise.domain.Branch;
import com.nequi.franchise.domain.repository.BranchRepository;
import com.nequi.franchise.infrastructure.mapper.BranchRepositoryMapper;
import com.nequi.franchise.infrastructure.mapper.ProductRepositoryMapper;
import com.nequi.franchise.infrastructure.r2dbc.BranchR2dbcRepository;
import com.nequi.franchise.infrastructure.r2dbc.ProductR2dbcRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@Component
public class BranchRepositoryAdapter implements BranchRepository {

    private final BranchR2dbcRepository branchR2dbcRepository;
    private final ProductR2dbcRepository productR2dbcRepository;
    private final BranchRepositoryMapper branchRepositoryMapper;
    private final TransactionalOperator transactionalOperator;
    private final ProductRepositoryMapper productRepositoryMapper;

    public BranchRepositoryAdapter(BranchR2dbcRepository branchR2dbcRepository, ProductR2dbcRepository productR2dbcRepository, BranchRepositoryMapper branchRepositoryMapper, TransactionalOperator transactionalOperator, ProductRepositoryMapper productRepositoryMapper) {
        this.branchR2dbcRepository = branchR2dbcRepository;
        this.productR2dbcRepository = productR2dbcRepository;
        this.branchRepositoryMapper = branchRepositoryMapper;
        this.transactionalOperator = transactionalOperator;
        this.productRepositoryMapper = productRepositoryMapper;
    }

    @Override
    public Mono<Branch> save(Branch branch) {
        return branchR2dbcRepository
                .save(branchRepositoryMapper.toEntity(branch))
                .map(branchRepositoryMapper::toDomain);
    }

    @Override
    public Mono<Branch> findById(Long id) {
        return branchR2dbcRepository.findById(id)
//                .switchIfEmpty(Mono.error(new NoSuchElementException()))
                .flatMap(f -> getProducts(branchRepositoryMapper.toDomain(f)))
                .as(transactionalOperator::transactional);
    }

    @Override
    public Flux<Branch> findAll() {
        return branchR2dbcRepository
                .findAll()
                .map(branchRepositoryMapper::toDomain);
    }

    private Mono<Branch> getProducts(Branch branch) {

        return Mono.just(branch)
                .zipWith(productR2dbcRepository.findAllByIdBranch(branch.getId()).collectList())
                .as(transactionalOperator::transactional)
                .map(result -> new Branch(
                        result.getT1().getId(),
                        result.getT1().getName(),
                        result.getT1().getIdFranchise(),
                        result.getT2().stream()
                                .map(productRepositoryMapper::toDomain)
                                .toList()
                ));
    }
}
