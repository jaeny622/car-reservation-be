package com.study.demo.user.dto;

import com.study.demo.user.entity.UserInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginReq {
    private String id;
    private String password;

    public UserInfo toEntity(){
        return UserInfo.builder().id(id).password(password).build();
    }
}
