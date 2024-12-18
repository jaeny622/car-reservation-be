package com.study.demo.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERINFO")
public class UserInfo {
    @Id
    @Size(max = 50)
    @Column(name = "ID", nullable = false, length = 50)
    private String id;

    @Size(max = 100)
    @Column(name = "PASSWORD", length = 100)
    private String password;

    @Size(max = 50)
    @Column(name = "NICKNAME", length = 50)
    private String nickname;

    @Size(max = 8)
    @Column(name = "COLOR_CODE", length = 8)
    private String colorCode;

}