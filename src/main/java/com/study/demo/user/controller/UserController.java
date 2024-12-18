package com.study.demo.user.controller;

import com.study.demo.Response;
import com.study.demo.user.dto.JoinReq;
import com.study.demo.user.dto.LoginReq;
import com.study.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oh-bros")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/join")
    public Response<?> join(@RequestBody JoinReq req) {
        userService.join(req);
        return Response.success("join success");
    }

    @PostMapping("/login")
    public Response<?> login(@RequestBody LoginReq req) {
        userService.login(req);
        return Response.success("login success");
    }

}
