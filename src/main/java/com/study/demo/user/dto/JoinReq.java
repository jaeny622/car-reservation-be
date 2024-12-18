package com.study.demo.user.dto;

import com.study.demo.user.entity.Userinfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinReq {
    private String id;
    private String password;
    private String nickName;

    public Userinfo toEntity(){
        return Userinfo.builder().id(id).password(password).nickname(nickName).build();
    }
}
