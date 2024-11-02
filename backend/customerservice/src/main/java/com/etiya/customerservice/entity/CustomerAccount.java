package com.etiya.customerservice.entity;

import com.etiya.customerservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer_Accounts")
public class CustomerAccount extends BaseEntity {
    @Column(name = "account_number")
    private Integer accountNumber;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "customerAccount")
    private List<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

}
