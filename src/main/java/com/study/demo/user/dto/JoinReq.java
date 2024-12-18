package com.study.demo.user.dto;

import com.study.demo.user.ColorCode;
import com.study.demo.user.entity.UserInfo;
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

    public UserInfo toEntity(String colorCode) {
        return UserInfo.builder().id(id).password(password).nickname(nickName).colorCode(colorCode).build();
    }
}
