package com.example.bookstore.product.Repository;

import com.example.bookstore.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
