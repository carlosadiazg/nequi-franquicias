package com.nequi.franchise.presentation.dto.branch;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BranchPresentationRequest {
    private String name;
    private Long idFranchise;
}
