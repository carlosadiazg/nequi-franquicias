package com.nequi.franchise.presentation.mappers;

import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.presentation.dto.franchise.FranchiseControllerRequest;
import org.springframework.stereotype.Component;

@Component
public class FranchiseMapper {

    public Franchise toApplication(FranchiseControllerRequest request) {

        Franchise franchise = new Franchise();
        franchise.setName(request.getName());
        return franchise;
    }

    public void toInfrastructure() {

    }
}
