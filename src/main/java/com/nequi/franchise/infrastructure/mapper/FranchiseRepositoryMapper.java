package com.nequi.franchise.infrastructure.mapper;

import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.infrastructure.entity.FranchiseEntity;
import org.springframework.stereotype.Component;

@Component
public class FranchiseRepositoryMapper {

    public Franchise toDomain(FranchiseEntity franchiseEntity) {
        Franchise franchise = new Franchise();
        franchise.setId(franchiseEntity.getId());
        franchise.setName(franchiseEntity.getName());
        return franchise;
    }

    public FranchiseEntity toEntity(Franchise franchise) {
        FranchiseEntity franchiseEntity = new FranchiseEntity();
        franchiseEntity.setId(franchise.getId());
        franchiseEntity.setName(franchise.getName());
        return franchiseEntity;
    }
}
