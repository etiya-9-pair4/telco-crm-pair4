package com.etiya.customerservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "individual_customers")
public class IndividualCustomer extends Customer {
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @JsonIgnore
    private Customer customer;

    @Column(name = "NAT_id", unique = true)
    private int nationalityId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "father_name")
    private String fatherName;

    //TODO: noluyo hocam
    @Column(name = "gender_id")
    private Integer genderId;
}
