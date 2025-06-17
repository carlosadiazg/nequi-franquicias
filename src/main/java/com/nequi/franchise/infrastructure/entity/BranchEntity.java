package com.nequi.franchise.infrastructure.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "branches", schema = "public")
@Data
@NoArgsConstructor
public class BranchEntity {

    @Id
    private Long id;
    private String name;
    @Column("id_franchise")
    private Long idfranchise;
}
