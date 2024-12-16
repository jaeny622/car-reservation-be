package com.study.demo.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "USERINFO")
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return getThumbUrl().isEmpty() ?  getUserId() + "," + getPassword() + "," + getName() : getUserId() + "," + getPassword() + "," + getName() + "," + getThumbUrl();
    }
}