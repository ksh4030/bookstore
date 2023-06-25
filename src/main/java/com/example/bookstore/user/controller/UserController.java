package com.example.bookstore.user.controller;

import com.example.bookstore.user.dto.UserInput;
import com.example.bookstore.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;


    @RequestMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(Model model, UserInput parameter) {

        boolean result = userService.signup(parameter);
        model.addAttribute("result", result);

        return "user/signup_complete";
    }

}
