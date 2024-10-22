package com.etiya.productservice.entity;

import com.etiya.productservice.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ProductOffer")
public class ProductOffer extends BaseEntity {
    @Column(name="description")
    private String description;
    @Column(name="start_date")
    private LocalDateTime startDate;
    @Column(name="end_date")
    private LocalDateTime endDate;
    @Column(name="status")
    private boolean status;
    @Column(name="discount_rate")
    private short discountRate;

//    @OneToMany(mappedBy = "productOffer")
//    private List<CatalogProductOffer> catalogProductOffers;
//    @OneToMany(mappedBy = "productOffer")
//    private List<CustomerProductOffer> customerProductOffers;
}
