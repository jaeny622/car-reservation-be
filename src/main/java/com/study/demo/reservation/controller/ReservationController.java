package com.study.demo.reservation.controller;

import com.study.demo.Response;
import com.study.demo.reservation.dto.ReservationReq;
import com.study.demo.reservation.entity.Reservation;
import com.study.demo.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/oh-bros")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return reservationService.findAllReservations();
    }

    @GetMapping("/reservation/{id}")
    public Reservation getReservation(@PathVariable String id) {
        return reservationService.findOneReservation(id);
    }

    @PostMapping("/reservation")
    public Response<?> createReservation(@RequestBody  ReservationReq req) {
        reservationService.saveReservation(req);
        return Response.created("/oh-bros/reservations/" + req.getId());
    }

    @PutMapping("/reservation/{id}")
    public Response<?> updateReservation(@RequestBody ReservationReq req, @PathVariable String id) {
        reservationService.updateReservation(req,id);
        return Response.success("/oh-bros/reservation/" + id);
    }

    @DeleteMapping("/reservation/{id}")
    public Response<?> deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
        return Response.success("/oh-bros/reservation/" + id);
    }

}
