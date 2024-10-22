package com.etiya.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Product_Charecteristic_Values")
public class ProductCharacteristicValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name="value")
    private String value;

//    @ManyToOne
//    @JoinColumn(name = "characteristic_id")
//    private Characteristic characteristic;
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
}
