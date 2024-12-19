package com.study.demo.reservation.controller;

import com.study.demo.Response;
import com.study.demo.reservation.dto.ReservationReq;
import com.study.demo.reservation.entity.Reservation;
import com.study.demo.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/oh-bros")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<?> getReservations() {
        return new ResponseEntity<>(Response.success(reservationService.findAllReservations()), HttpStatus.OK);
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<?> getReservation(@PathVariable String id) {
        return new ResponseEntity<>(Response.success(reservationService.findOneReservation(id)),HttpStatus.OK);
    }

    @PostMapping("/reservation")
    public ResponseEntity<?> createReservation(@RequestBody  ReservationReq req) {
        reservationService.saveReservation(req);
        return new ResponseEntity<>(Response.created("reservation 생성 완료"),HttpStatus.CREATED);
    }

    @PutMapping("/reservation/{id}")
    public ResponseEntity<?> updateReservation(@RequestBody ReservationReq req, @PathVariable String id) {
        Reservation reservation = reservationService.updateReservation(req,id);
        return new ResponseEntity<>(reservation == null ? Response.fail("저장에 실패했습니다.") : Response.success("/oh-bros/reservation/" + id), HttpStatus.OK);
    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(Response.success("/oh-bros/reservation/" + id), HttpStatus.OK);
    }

}
