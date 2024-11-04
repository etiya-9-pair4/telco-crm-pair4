package com.etiya.productservice.repository.productoffer;

import com.etiya.productservice.entity.ProductOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductOfferRepository extends JpaRepository<ProductOffer, Integer> {
}
