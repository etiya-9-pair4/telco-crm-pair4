package com.etiya.productservice.entity;

import com.etiya.productservice.core.entity.BaseEntity;
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
    @JoinColumn(name = "product_id", nullable = false)
    private Catalog catalog;

    @OneToMany(mappedBy = "product")
    private List<ProductCharacteristicValue> productCharacteristicValues;

    @OneToMany(mappedBy = "product")
    private List<CampaignProduct> campaignProducts;

    @OneToMany(mappedBy = "product")
    private List<ProductOffer> productOffers;

}
