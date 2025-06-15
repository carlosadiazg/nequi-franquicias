package com.nequi.franchise.infrastructure.r2dbc;

import com.nequi.franchise.infrastructure.entity.BranchEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface BranchR2dbcRepository extends R2dbcRepository<BranchEntity, Long> {
}
