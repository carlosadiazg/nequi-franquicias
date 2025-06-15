package com.nequi.franchise.infrastructure.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "franchises", schema = "public")
@Data
@NoArgsConstructor
public class ProductEntity {

    @Id
    private Long id;
    private String name;
    private int stock;
}
