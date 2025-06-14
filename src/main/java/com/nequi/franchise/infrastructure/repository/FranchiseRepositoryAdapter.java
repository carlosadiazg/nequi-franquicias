package com.nequi.franchise.infrastructure.repository;

import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.domain.repository.FranchiseRepository;
import reactor.core.publisher.Mono;

public class FranchiseRepositoryAdapter implements FranchiseRepository {
    @Override
    public Mono<Franchise> save(Franchise franchise) {
        return Mono.empty();
    }
}
