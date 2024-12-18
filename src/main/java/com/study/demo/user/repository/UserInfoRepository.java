package com.study.demo.user.repository;

import com.study.demo.user.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<Userinfo, String> {
}
