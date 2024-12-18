package com.study.demo.user.repository;

import com.study.demo.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    public boolean existsByNickname(String nickName);
}
