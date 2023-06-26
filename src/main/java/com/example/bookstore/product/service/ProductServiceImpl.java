package com.example.bookstore.product.service;

import com.example.bookstore.product.Repository.ProductRepository;
import com.example.bookstore.product.entity.Product;
import com.example.bookstore.product.model.ProductInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void add(ProductInput parameter) {
        Product product = Product.builder()
                .productName(parameter.getProductName())
                .productType(parameter.getProductType())
                .price(parameter.getPrice())
                .salePrice(parameter.getSalePrice())
                .productDetail(parameter.getProductDetail())
                .stock(parameter.getStock())
                .regDate(LocalDateTime.now())
                .build();

        productRepository.save(product);
    }

    @Override
    public List<Product> list() {

        //Todo 일단 모든 데이터 가져오고 추후 필요에 따라 수정 or Elasticsearch

        return productRepository.findAll();
    }

    @Override
    public Product detail(String id) {

        Optional<Product> optionalProduct = productRepository.findById(Long.parseLong(id));

        return optionalProduct.orElse(null);
    }

    @Override
    public void update(ProductInput parameter, String id) {
        Optional<Product> optionalProduct = productRepository.findById(Long.parseLong(id));

        if(optionalProduct.isEmpty()) {
            throw new IllegalStateException();
        }

        Product product = optionalProduct.get();

        product.setProductName(parameter.getProductName());
        product.setProductType(parameter.getProductType());
        product.setPrice(parameter.getPrice());
        product.setSalePrice(parameter.getSalePrice());
        product.setProductDetail(parameter.getProductDetail());
        product.setStock(parameter.getStock());

        productRepository.save(product);
    }

    @Override
    public void delete(String productId) {
        Optional<Product> optionalProduct = productRepository.findById(Long.parseLong(productId));

        if(optionalProduct.isEmpty()) {
            throw new IllegalStateException();
        }

        productRepository.delete(optionalProduct.get());

    }

}
