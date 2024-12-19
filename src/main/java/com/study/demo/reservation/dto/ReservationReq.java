package com.study.demo.reservation.dto;


import com.study.demo.reservation.entity.Reservation;
import com.study.demo.user.entity.UserInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReservationReq {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String userId;
    private String title;


    public Reservation toEntity(){
        return Reservation.builder().startDate(startDate).endDate(endDate).userId(userId).title(title).build();
    }

    public Reservation toUpdateEntity(String reservationId){
        return Reservation.builder().id(reservationId).startDate(startDate).endDate(endDate).userId(userId).title(title).build();
    }
}
