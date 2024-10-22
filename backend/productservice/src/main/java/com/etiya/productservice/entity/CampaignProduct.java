package com.etiya.productservice.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CampaignsProduct")
public class CampaignProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
//    @ManyToOne
//    @JoinColumn(name = "campaign_id")
//    private Campaign campaign;
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
}
