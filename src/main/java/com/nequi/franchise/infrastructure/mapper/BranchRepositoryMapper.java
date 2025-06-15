package com.nequi.franchise.infrastructure.mapper;

import com.nequi.franchise.domain.Branch;
import com.nequi.franchise.infrastructure.entity.BranchEntity;
import org.springframework.stereotype.Component;

@Component
public class BranchRepositoryMapper {

    public Branch toDomain(BranchEntity branchEntity) {
        Branch branch = new Branch();
        branch.setId(branchEntity.getId());
        branch.setName(branchEntity.getName());
        branch.setIdFranchise(branchEntity.getIdranchise());
        return branch;
    }

    public BranchEntity toEntity(Branch branch) {
        BranchEntity branchEntity = new BranchEntity();
        branchEntity.setId(branch.getId());
        branchEntity.setName(branch.getName());
        branchEntity.setIdranchise(branch.getIdFranchise());
        return branchEntity;
    }
}
