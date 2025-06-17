package com.nequi.franchise.infrastructure.r2dbc;

import com.nequi.franchise.infrastructure.entity.FranchiseEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FranchiseR2dbcRepository extends ReactiveCrudRepository<FranchiseEntity, Long> {
}
