package com.nequi.franchise.presentation.mappers;

import com.nequi.franchise.domain.Branch;
import com.nequi.franchise.presentation.dto.branch.BranchPresentationRequest;
import com.nequi.franchise.presentation.dto.branch.BranchPresentationResponse;
import org.springframework.stereotype.Component;

@Component
public class BranchPresentationMapper {

    private final ProductPresentationMapper productPresentationMapper;

    public BranchPresentationMapper(ProductPresentationMapper productPresentationMapper) {
        this.productPresentationMapper = productPresentationMapper;
    }

    public Branch toApplication(BranchPresentationRequest request) {
        Branch branch = new Branch();
        branch.setName(request.getName());
        branch.setIdFranchise(request.getIdFranchise());
        return branch;
    }

    public BranchPresentationResponse toInfrastructure(Branch branch) {
        BranchPresentationResponse response = new BranchPresentationResponse();
        response.setId(branch.getId());
        response.setName(branch.getName());
        response.setIdFranchise(branch.getIdFranchise());
        response.setProducts(branch.getProducts()
                .stream()
                .map(productPresentationMapper::toInfrastructure)
                .toList());
        return response;
    }
}
