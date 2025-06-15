package com.nequi.franchise.presentation.mappers;

import com.nequi.franchise.domain.Branch;
import com.nequi.franchise.presentation.dto.branch.BranchPresentationRequest;
import com.nequi.franchise.presentation.dto.branch.BranchPresentationResponse;
import org.springframework.stereotype.Component;

@Component
public class BranchPresentationMapper {

    public Branch toApplication(BranchPresentationRequest request) {
        Branch branch = new Branch();
        branch.setName(request.getName());
        return branch;
    }

    public BranchPresentationResponse toInfrastructure(Branch branch) {
        BranchPresentationResponse response = new BranchPresentationResponse();
        response.setName(branch.getName());
        return response;
    }
}
