package com.study.demo.user.service;

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

        System.out.println("userTmp " +user.toString());

        userRepository.save(userTmp);
    }

}
