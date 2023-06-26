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
    Long productId;

    String productName;
    ProductType productType;
    Long price;       //금액(정가)
    Long salePrice;   //판매 금액

    @Lob
    String productDetail; //상품 설명
    Long stock;
    LocalDateTime regDate; //등록일

}
