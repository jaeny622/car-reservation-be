package com.study.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"User\"")
public class User {
    @Id
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @Column(name = "password", nullable = false, length = 1000)
    private String password;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "thumb_url", length = 1000)
    private String thumbUrl;

}