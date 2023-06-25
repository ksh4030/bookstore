package com.example.bookstore.user.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@ToString
@Valid
public class UserInput {

    @NotNull
    @Size(min = 5, max = 15)
    private String userId;   //로그인 아이디

    @NotNull
    @Size(min = 6)
    private String password;

    @NotNull
    private String userName;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private LocalDateTime regDate;   //가입일

    @NotNull
    private String role;             //역할(ex 관리자, 일반 회원, 점장 등)
}
