package com.study.demo.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class UserDto {
    private String id;
    private String pwd;
    private String name;
    private String thumbUrl;

    @Builder
    public UserDto(String id, String pwd, String name, String thumbUrl) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.thumbUrl = thumbUrl;
    }

    @Override
    public String toString() {
        return getThumbUrl().isEmpty() ? getId() + "," + getPwd() + "," + getName() : getId() + "," + getPwd() + "," + getName() + "," + getThumbUrl();

    }
}
