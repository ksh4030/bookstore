package com.example.bookstore.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;

    String productName;
    String productTag;
    Long price;      //금액
    Long salePrice;  //판매 금액

    @Lob
    String productDetail;  //상품 설명
    Long stock;
    LocalDateTime regDate; //등록일

}
