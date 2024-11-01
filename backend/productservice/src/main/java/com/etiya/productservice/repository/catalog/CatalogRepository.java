package com.etiya.productservice.repository.catalog;

import com.etiya.productservice.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
}
