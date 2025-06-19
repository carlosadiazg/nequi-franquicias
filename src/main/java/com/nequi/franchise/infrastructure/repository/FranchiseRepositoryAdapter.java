package com.nequi.franchise.infrastructure.repository;

import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.domain.repository.FranchiseRepository;
import com.nequi.franchise.infrastructure.mapper.BranchRepositoryMapper;
import com.nequi.franchise.infrastructure.mapper.FranchiseRepositoryMapper;
import com.nequi.franchise.infrastructure.r2dbc.BranchR2dbcRepository;
import com.nequi.franchise.infrastructure.r2dbc.FranchiseR2dbcRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@Component
public class FranchiseRepositoryAdapter implements FranchiseRepository {

    private final FranchiseR2dbcRepository franchiseR2dbcRepository;
    private final BranchR2dbcRepository branchR2dbcRepository;
    private final FranchiseRepositoryMapper franchiseRepositoryMapper;
    private final TransactionalOperator transactionalOperator;
    private final BranchRepositoryMapper branchRepositoryMapper;

    public FranchiseRepositoryAdapter(FranchiseR2dbcRepository franchiseR2dbcRepository, BranchR2dbcRepository branchR2dbcRepository, FranchiseRepositoryMapper franchiseRepositoryMapper, TransactionalOperator transactionalOperator, BranchRepositoryMapper branchRepositoryMapper) {
        this.franchiseR2dbcRepository = franchiseR2dbcRepository;
        this.branchR2dbcRepository = branchR2dbcRepository;
        this.franchiseRepositoryMapper = franchiseRepositoryMapper;
        this.transactionalOperator = transactionalOperator;
        this.branchRepositoryMapper = branchRepositoryMapper;
    }

    @Override
    public Mono<Franchise> save(Franchise franchise) {
        return franchiseR2dbcRepository.save(franchiseRepositoryMapper.toEntity(franchise))
                .switchIfEmpty(Mono.error(new RuntimeException("Error trying to save a franchise " + franchise.getName())))
                .map(franchiseRepositoryMapper::toDomain);
    }

    @Override
    public Mono<Franchise> findById(Long id) {
        return franchiseR2dbcRepository.findById(id)
                .switchIfEmpty(Mono.error(new NoSuchElementException()))
                .flatMap(f -> getBranches(franchiseRepositoryMapper.toDomain(f)))
                .as(transactionalOperator::transactional);
    }

    @Override
    public Flux<Franchise> findAll() {
        return franchiseR2dbcRepository
                .findAll()
                .map(franchiseRepositoryMapper::toDomain);
    }

    private Mono<Franchise> getBranches(Franchise franchise) {

        return Mono.just(franchise)
                .zipWith(branchR2dbcRepository.findAllByIdfranchise(franchise.getId()).collectList())
                .as(transactionalOperator::transactional)
                .map(result -> new Franchise(
                        result.getT1().getId(),
                        result.getT1().getName(),
                        result.getT2().stream()
                                .map(branchRepositoryMapper::toDomain)
                                .toList())
                );
    }
}
