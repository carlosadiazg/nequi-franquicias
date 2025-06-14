package com.nequi.franchise.domain.repository;

import com.nequi.franchise.domain.Franchise;
import reactor.core.publisher.Mono;

public interface FranchiseRepository {
    Mono<Franchise> save(Franchise franchise);
}
