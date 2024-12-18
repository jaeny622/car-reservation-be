package com.study.demo.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginInfoDto {
    private String id;
    private String pwd;


    public LoginInfoDto(String id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return getId() + "," + getPwd();

    }
}
