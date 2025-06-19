package com.nequi.franchise.infrastructure.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table(name = "branches", schema = "public")
@Data
@NoArgsConstructor
public class BranchEntity {

    @Id
    private Long id;
    private String name;
    @Column("id_franchise")
    private Long idfranchise;

    @Transient
    private List<ProductEntity> products;

    public List<ProductEntity> getProducts() {
        return products == null ? new ArrayList<>() : products;
    }
}
