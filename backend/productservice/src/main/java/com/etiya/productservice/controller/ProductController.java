package com.etiya.productservice.controller;

import com.etiya.productservice.entity.Product;
import com.etiya.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String hello() {
        return "Hello product o7";
    }


    @PostMapping("search")
    public List<Product> getByIds(@RequestBody List<Integer> ids) {
        return productService.search(ids);
    }
}
