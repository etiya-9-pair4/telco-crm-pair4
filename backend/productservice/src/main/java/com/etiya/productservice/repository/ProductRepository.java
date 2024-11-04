package com.etiya.productservice.repository;

import com.etiya.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByNameIgnoreCase(String name);

    Optional<List<Product>> findByNameLikeIgnoreCase(String name);

    List<Product> findByIdIn(List<Integer> ids);


}