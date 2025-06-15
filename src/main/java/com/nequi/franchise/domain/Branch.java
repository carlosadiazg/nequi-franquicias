package com.nequi.franchise.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Branch {
    private Long id;
    private String name;
    private Long idFranchise;
}
