package com.nequi.franchise.infrastructure.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;


@Table(name = "franchises", schema = "public")
@Data
@NoArgsConstructor
public class FranchiseEntity {

    @Id
    private Long id;
    private String name;

    @Transient
    private List<BranchEntity> branches;

    public List<BranchEntity> getBranches() {
        return branches == null ? new ArrayList<>() : branches;
    }
}
