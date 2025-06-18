package com.nequi.franchise.presentation.dto.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductPresentationResponse {
    private Long id;
    private String name;
    private int stock;
}
