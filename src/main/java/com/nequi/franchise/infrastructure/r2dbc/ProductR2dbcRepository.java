package com.nequi.franchise.infrastructure.r2dbc;

import com.nequi.franchise.infrastructure.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface ProductR2dbcRepository extends R2dbcRepository<ProductEntity, Long> {
    Flux<ProductEntity> findAllByIdBranch(Long id);

    @Query("with max_product_stock as ( select max(p.stock) as stock, p.id_branch from products p where p.id_branch in ( select b.id from branches b where b.id_franchise = :id ) group by p.id_branch ) select p.id, p.\"name\", p.id_branch, m.stock as stock from max_product_stock m join products p on m.id_branch = p.id_branch and p.stock = m.stock")
    Flux<ProductEntity> findMaxStockByIdFranchise(Long id);
}
