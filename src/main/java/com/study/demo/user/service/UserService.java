package com.study.demo.user.service;

import com.study.demo.user.ColorCode;
import com.study.demo.user.dto.JoinReq;
import com.study.demo.user.dto.LoginReq;
import com.study.demo.user.entity.UserInfo;
import com.study.demo.user.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    ColorCode[] colors = ColorCode.values();
    @Autowired
    private UserInfoRepository userInfoRepository;

    // 로그인 아이디 중복 체크
    public boolean checkIdDuplication(String id){
        return userInfoRepository.existsById(id);
    }

    // 로그인 닉네임 중복 체크
    public boolean checkNicknameDuplication(String nickName){
        return userInfoRepository.existsByNickname(nickName);
    }

    // 회원가입
    public void join(JoinReq req){
        Long count = userInfoRepository.count();
        System.out.println("count"+count+ colors[count.intValue()].getValue());
        userInfoRepository.save(req.toEntity(colors[count.intValue()].getValue()));
    }

    // 로그인
    public UserInfo login(LoginReq req){
        UserInfo user = userInfoRepository.findById(req.getId()).orElse(null);

        if(user == null){
            return null;
        }

        if(!req.getPassword().equals(user.getPassword())){
            return null;
        }

        return user;
    }

    // 나의 정보 조회
    public UserInfo findMyProfile(String id){
        UserInfo user = userInfoRepository.findById(id).orElse(null);
        if(user == null){
            return null;
        }

        return user;
    }
}
