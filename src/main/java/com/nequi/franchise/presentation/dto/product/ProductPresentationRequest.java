package com.nequi.franchise.presentation.dto.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductPresentationRequest {
    private String name;
    private int stock;
    private Long idBranch;
}
