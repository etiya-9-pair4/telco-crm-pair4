package com.etiya.productservice.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Catalog_Product_Offers")
public class CatalogProductOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_offer_id")
    private ProductOffer productOffer;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;
}