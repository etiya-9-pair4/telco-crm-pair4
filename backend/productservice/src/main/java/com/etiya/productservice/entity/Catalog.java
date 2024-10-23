package com.etiya.productservice.entity;

import com.etiya.productservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Catalogs")
public class Catalog extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Integer parentId;

    @ManyToOne
    @JoinColumn(name = "parent_id", insertable = false, updatable = false) // İncelenecek !!!
    private Catalog parent;

    @OneToMany(mappedBy = "parent")
    private List<Catalog> children;

    @OneToMany(mappedBy = "catalog")
    private List<Product> products;

    @OneToMany(mappedBy = "catalog")
    private List<CatalogProductOffer> catalogProductOffers;


}
