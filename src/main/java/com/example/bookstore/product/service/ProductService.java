package com.example.bookstore.product.service;

import com.example.bookstore.product.entity.Product;
import com.example.bookstore.product.model.ProductInput;

import java.util.List;

public interface ProductService {

    void add(ProductInput parameter);

    List<Product> list();

    Product detail(String id);

    void update(ProductInput parameter, String id);

    void delete(String productId);

}
