package com.example.bookstore.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long reviewNum;

    Long productId;
    Long id;  //회원 고유 식별 아이디

    @Lob
    String review;
    LocalDateTime reviewDate; //리뷰 등록일
    LocalDateTime updateDate; //리뷰 수정일

}