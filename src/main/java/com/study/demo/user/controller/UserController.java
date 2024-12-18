package com.study.demo.user.controller;

import com.study.demo.user.dto.UserDto;
import com.study.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserDto user){
        System.out.println("user " + user.toString());
        userService.signIn(user);
        return new ResponseEntity<String>("성공",HttpStatus.OK);
    }
}
