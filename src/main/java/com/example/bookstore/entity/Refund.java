package com.example.bookstore.entity;

import javax.persistence.*;

@Entity
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long refundNum;

    Long orderNum;

    @Lob
    String refundDetail; //환불 사유
    boolean refundYn;

}