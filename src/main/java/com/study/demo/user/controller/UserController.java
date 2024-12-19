package com.study.demo.user.controller;

import com.study.demo.Response;
import com.study.demo.user.dto.JoinReq;
import com.study.demo.user.dto.LoginReq;
import com.study.demo.user.entity.UserInfo;
import com.study.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/oh-bros")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody JoinReq req) {
        boolean duplicationById = userService.checkIdDuplication(req.getId());
        boolean duplicationByNickname = userService.checkNicknameDuplication(req.getNickName());
        if(duplicationById) {
            return new ResponseEntity<>(Response.fail("중복된 ID 입니다."), HttpStatus.OK);
        }

        if(duplicationByNickname) {
            return new ResponseEntity<>(Response.fail("중복된 Nickname 입니다."), HttpStatus.OK);
        }

        userService.join(req);

        return new ResponseEntity<>(Response.success("join success"), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq req) {
        UserInfo user = userService.login(req);
        if(user == null){
            return new ResponseEntity<>(Response.fail("아이디 또는 비밀번호가 일치하지 않습니다."),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(Response.success("login success"),HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id) {
        UserInfo user = userService.findMyProfile(id);
        return new ResponseEntity<>(Response.success(user),HttpStatus.OK);
    }

}
