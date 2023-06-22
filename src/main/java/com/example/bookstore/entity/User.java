package com.example.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;         //회원 고유 식별 아이디

    String userId;   //로그인 아이디
    String password;
    String userName;
    String address;
    String email;
    String phone;
    LocalDateTime regDate;   //가입일
    String role;             //역할(ex 관리자, 일반 회원, 점장 등)

}