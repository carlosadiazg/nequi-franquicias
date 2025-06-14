package com.nequi.franchise.infrastructure.repository;

import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.domain.repository.FranchiseRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public class FranchiseRepositoryAdapter implements FranchiseRepository {
    @Override
    public Mono<Franchise> save(Franchise franchise) {
        Franchise newFranquise = new Franchise();
        newFranquise.setName(franchise.getName());
        newFranquise.setId(UUID.randomUUID().toString());
        return Mono.just(newFranquise);
    }
}
