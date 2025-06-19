package com.nequi.franchise.domain.repository;

import com.nequi.franchise.domain.Branch;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchRepository {
    Mono<Branch> save(Branch branch);

    Mono<Branch> findById(Long id);

    Flux<Branch> findAll();
}
