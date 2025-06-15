package com.nequi.franchise.infrastructure.repository;

import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.domain.repository.FranchiseRepository;
import com.nequi.franchise.infrastructure.mapper.FranchiseRepositoryMapper;
import com.nequi.franchise.infrastructure.r2dbc.FranchiseR2dbcRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FranchiseRepositoryAdapter implements FranchiseRepository {

    private final FranchiseR2dbcRepository franchiseR2dbcRepository;
    private final FranchiseRepositoryMapper franchiseRepositoryMapper;

    public FranchiseRepositoryAdapter(FranchiseR2dbcRepository franchiseR2dbcRepository, FranchiseRepositoryMapper franchiseRepositoryMapper) {
        this.franchiseR2dbcRepository = franchiseR2dbcRepository;
        this.franchiseRepositoryMapper = franchiseRepositoryMapper;
    }

    @Override
    public Mono<Franchise> save(Franchise franchise) {
        return franchiseR2dbcRepository.save(franchiseRepositoryMapper.toEntity(franchise))
                .map(franchiseRepositoryMapper::toDomain);
    }

    @Override
    public Flux<Franchise> findAll() {
        return franchiseR2dbcRepository
                .findAll()
                .map(franchiseRepositoryMapper::toDomain);
    }
}
