package com.etiya.customerservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Corporate_Customers")
public class CorporateCustomer extends Customer {

    @Column(name = "corporate_name")
    private String corporateName;
    @Column(name = "tax_no")
    private String taxNo;
    @Column(name = "phone")
    private String phone;

}
