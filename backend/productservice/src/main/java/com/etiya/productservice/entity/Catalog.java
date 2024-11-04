package com.etiya.productservice.entity;

import com.etiya.productservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "catalogs")
public class Catalog extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Catalog parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Catalog> children = new ArrayList<>();

    @OneToMany(mappedBy = "catalog")
    private List<Product> products;

    @OneToMany(mappedBy = "catalog")
    private List<CatalogProductOffer> catalogProductOffers;


}