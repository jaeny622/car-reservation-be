package com.study.demo.reservation.dto;


import com.study.demo.reservation.entity.Reservation;
import com.study.demo.user.entity.UserInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ReservationReq {
    private String id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String userId;
    private String title;

    private UserInfo toUserEntity(){
        return UserInfo.builder().id(userId).build();
    }

    public Reservation toEntity(){
        return Reservation.builder().id(id).startDate(startDate).endDate(endDate).user(toUserEntity()).title(title).build();
    }
}
