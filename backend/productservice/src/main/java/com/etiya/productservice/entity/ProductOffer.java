package com.etiya.productservice.entity;

import com.etiya.productservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ProductOffer")
public class ProductOffer extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "discount_rate")
    private short discountRate;

    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


    @OneToMany(mappedBy = "productOffer")
    private List<CatalogProductOffer> catalogProductOffers;

//    @OneToMany(mappedBy = "")
//    private List<CustomerProductOffer> customerProductOffers;
}
