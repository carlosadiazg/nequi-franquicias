package com.nequi.franchise.presentation.mappers;

import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.presentation.dto.franchise.FranchisePresentationRequest;
import com.nequi.franchise.presentation.dto.franchise.FranchisePresentationResponse;
import org.springframework.stereotype.Component;

@Component
public class FranchisePresentationMapper {

    public Franchise toApplication(FranchisePresentationRequest request) {

        Franchise franchise = new Franchise();
        franchise.setName(request.getName());
        return franchise;
    }

    public FranchisePresentationResponse toInfrastructure(Franchise franchise) {
        FranchisePresentationResponse response = new FranchisePresentationResponse();
        response.setName(franchise.getName());
        return response;
    }
}
