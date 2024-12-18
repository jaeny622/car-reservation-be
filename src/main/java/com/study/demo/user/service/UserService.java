package com.study.demo.user.service;

import com.study.demo.user.dto.JoinReq;
import com.study.demo.user.dto.LoginReq;
import com.study.demo.user.entity.Userinfo;
import com.study.demo.user.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    // 로그인 아이디 중복 체크
    public boolean checkIdDuplication(String id){
        return userInfoRepository.existsById(id);
    }

    // 회원가입
    public void join(JoinReq req){
        userInfoRepository.save(req.toEntity());
    }

    // 로그인
    public Userinfo login(LoginReq req){
        Userinfo user = userInfoRepository.findById(req.getId()).orElse(null);

        if(user == null){
            return null;
        }

        if(!req.getPassword().equals(user.getPassword())){
            return null;
        }

        return user;
    }
}
