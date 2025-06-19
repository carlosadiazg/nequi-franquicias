package com.nequi.franchise.presentation.mappers;

import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.presentation.dto.franchise.FranchisePresentationRequest;
import com.nequi.franchise.presentation.dto.franchise.FranchisePresentationResponse;
import org.springframework.stereotype.Component;

@Component
public class FranchisePresentationMapper {

    private final BranchPresentationMapper branchPresentationMapper;

    public FranchisePresentationMapper(BranchPresentationMapper branchPresentationMapper) {
        this.branchPresentationMapper = branchPresentationMapper;
    }

    public Franchise toApplication(FranchisePresentationRequest request) {

        Franchise franchise = new Franchise();
        franchise.setName(request.getName());
        return franchise;
    }

    public FranchisePresentationResponse toInfrastructure(Franchise franchise) {
        FranchisePresentationResponse response = new FranchisePresentationResponse();
        response.setId(franchise.getId());
        response.setName(franchise.getName());
        response.setBranches(franchise.getBranches()
                .stream()
                .map(branchPresentationMapper::toInfrastructure)
                .toList());
        return response;
    }
}
