package com.etiya.customerservice.entity;

import com.etiya.customerservice.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends BaseEntity {

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonIgnore
//    @JsonManagedReference
    private IndividualCustomer individualCustomer;
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer")
    private List<Contact> contacts;

    @OneToMany(mappedBy = "customer")
    private List<CustomerAccount> customerAccounts;
}
