package com.nequi.franchise.infrastructure.r2dbc;

import com.nequi.franchise.infrastructure.entity.FranchiseEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FranchiseR2dbcRepository extends R2dbcRepository<FranchiseEntity, Long> {
}
