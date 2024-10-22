package com.etiya.customerservice.entity;

import com.etiya.customerservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Billing_Accounts")
public class CustomerAccount extends BaseEntity {


    @Column(name = "status")
    private boolean status;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_name")
    private String accountName;
    //TODO: enum?
    @Column(name = "type")
    private String type;

//    private Customer customer;
//    private Address adress;

}
