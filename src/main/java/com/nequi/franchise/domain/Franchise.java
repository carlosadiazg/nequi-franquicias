package com.nequi.franchise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Franchise {
    private Long id;
    private String name;
    private List<Branch> branches = new ArrayList<>();
}
