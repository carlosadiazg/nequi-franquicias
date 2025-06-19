package com.nequi.franchise.infrastructure.r2dbc;

import com.nequi.franchise.infrastructure.entity.BranchEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BranchR2dbcRepository extends ReactiveCrudRepository<BranchEntity, Long> {
    Flux<BranchEntity> findAllByIdfranchise(Long id);
}
