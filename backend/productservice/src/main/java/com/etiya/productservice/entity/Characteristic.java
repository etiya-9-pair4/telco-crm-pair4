package com.etiya.productservice.entity;

import com.etiya.productservice.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="characteristics")
public class Characteristic extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "characteristic")
    private List<CharacteristicValue> characteristicValues;
}
