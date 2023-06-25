package com.example.bookstore.user.service;

import com.example.bookstore.user.dto.UserInput;
import com.example.bookstore.user.entity.Role;
import com.example.bookstore.user.entity.User;
import com.example.bookstore.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean signup(UserInput parameter) {

        Optional<User> optionalUser = userRepository.findByUserId(parameter.getUserId());
        if(optionalUser.isPresent()) {
            return false;
        }

        String encPassword = BCrypt.hashpw(parameter.getPassword(), BCrypt.gensalt());

        User user = User.builder()
                .userId(parameter.getUserId())
                .password(encPassword)
                .userName(parameter.getUserName())
                .email(parameter.getEmail())
                .phone(parameter.getPhone())
                .regDate(LocalDateTime.now())
                .role("user")
                .build();

        userRepository.save(user);

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("회원 정보가 존재하지 않습니다."));

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority(Role.USER.getRole()));

        if (user.getRole().equals("admin")) {
            grantedAuthorityList.add(new SimpleGrantedAuthority(Role.ADMIN.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), grantedAuthorityList);
    }
}
