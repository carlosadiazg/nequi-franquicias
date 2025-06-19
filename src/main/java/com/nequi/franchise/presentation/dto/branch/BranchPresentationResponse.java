package com.nequi.franchise.presentation.dto.branch;

import com.nequi.franchise.presentation.dto.product.ProductPresentationResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BranchPresentationResponse {
    private Long id;
    private String name;
    private Long idFranchise;
    private List<ProductPresentationResponse> products;
}
