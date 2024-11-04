package com.etiya.productservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Campaigns_Product")
public class CampaignProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "campaign_id",nullable = false)
    @JsonBackReference // Çocuk tarafı
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
//    @JsonBackReference("product-reference") // Unique reference name
    private Product product;

}