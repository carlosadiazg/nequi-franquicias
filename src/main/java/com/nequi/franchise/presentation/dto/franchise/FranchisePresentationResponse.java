package com.nequi.franchise.presentation.dto.franchise;

import com.nequi.franchise.presentation.dto.branch.BranchPresentationResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FranchisePresentationResponse {
    private String name;
    private List<BranchPresentationResponse> branches;
}
