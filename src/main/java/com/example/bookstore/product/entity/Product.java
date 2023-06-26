package com.example.bookstore.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private Long price;       //금액(정가)
    private Long salePrice;   //판매 금액

    @Lob
    private String productDetail; //상품 설명
    private long stock;
    private LocalDateTime regDate; //등록일

}
