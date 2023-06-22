package com.example.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long addressId;

    Long id;                //회원 고유 식별 아이디
    String name;            //받는 사람 이름
    String address;         //주소(서울특별시 마포구 등)
    String addressDetail;   //상세주소(ex 아파트 동 호 등)
    String phone;           //받는 사람 전화번호

}
