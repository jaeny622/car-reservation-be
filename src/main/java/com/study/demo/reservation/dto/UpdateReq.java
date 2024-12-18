package com.study.demo.reservation.dto;

import com.study.demo.reservation.entity.Reservation;

import java.time.LocalDate;

public class UpdateReq {
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;

    public Reservation toEntity(){
        return Reservation.builder().startDate(startDate).endDate(endDate).title(title).build();
    }
}
