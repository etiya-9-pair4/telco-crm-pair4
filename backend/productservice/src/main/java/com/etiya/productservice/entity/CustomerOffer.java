package com.etiya.productservice.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer_Offers")
public class CustomerOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = false)
    private Offer offer;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

//    @ManyToOne
//    @JoinColumn(name = "productoffer_id")
//    private ProductOffer productOffer;
}
