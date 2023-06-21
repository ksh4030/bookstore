package com.example.bookstore.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderNum;

    Long productId;
    Long id;   //회원 고유 식별 아이디
    Long addressId;   //배송지 아이디
    String productName;
    LocalDateTime orderDate;  //주문 날짜
    boolean deliveryYn;     //배송 여부

    @Lob
    String reqComment;      //요청사항

}
