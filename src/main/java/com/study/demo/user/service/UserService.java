package com.study.demo.user.service;

import com.study.demo.user.dto.LoginInfoDto;
import com.study.demo.user.dto.UserDto;
import com.study.demo.user.entity.User;
import com.study.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void signIn(UserDto user){
        User userTmp = new User(user.getId(), user.getPwd(), user.getName(), user.getThumbUrl());

        userRepository.save(userTmp);
    }

    public String logIn(String userId, LoginInfoDto info){
       User userTmp = userRepository.findById(userId).orElse(null);
       if(userTmp.getUserId().equals(info.getId()) && userTmp.getPassword().equals(info.getPwd())) {
           return "로그인 성공";
       }

       return "로그인 정보가 일치하지 않습니다.";
    }

}
