package com.nequi.franchise.infrastructure.repository;

import com.nequi.franchise.domain.Branch;
import com.nequi.franchise.domain.repository.BranchRepository;
import com.nequi.franchise.infrastructure.mapper.BranchRepositoryMapper;
import com.nequi.franchise.infrastructure.r2dbc.BranchR2dbcRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BranchRepositoryAdapter implements BranchRepository {

    private final BranchR2dbcRepository branchR2dbcRepository;
    private final BranchRepositoryMapper branchRepositoryMapper;

    public BranchRepositoryAdapter(BranchR2dbcRepository branchR2dbcRepository, BranchRepositoryMapper branchRepositoryMapper) {
        this.branchR2dbcRepository = branchR2dbcRepository;
        this.branchRepositoryMapper = branchRepositoryMapper;
    }

    @Override
    public Mono<Branch> save(Branch branch) {
        return branchR2dbcRepository
                .save(branchRepositoryMapper.toEntity(branch))
                .map(branchRepositoryMapper::toDomain);
    }

    @Override
    public Flux<Branch> findAll() {
        return branchR2dbcRepository
                .findAll()
                .map(branchRepositoryMapper::toDomain);
    }
}
