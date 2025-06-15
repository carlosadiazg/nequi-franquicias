package com.nequi.franchise.infrastructure.r2dbc;

import com.nequi.franchise.infrastructure.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProductR2dbcRepository extends R2dbcRepository<ProductEntity, Long> {
}
