package com.etiya.productservice.entity;

import com.etiya.productservice.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
//TODO: characteristic_value relations
public class Product extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "catalog_id", nullable = false)
    private Catalog catalog;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductCharacteristicValue> productCharacteristicValues;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    @JsonManagedReference("product-reference") // Matching reference name
    private List<CampaignProduct> campaignProducts;

    @OneToMany(mappedBy = "product")
    private List<ProductOffer> productOffers;

}