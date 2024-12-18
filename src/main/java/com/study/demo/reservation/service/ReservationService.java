package com.study.demo.reservation.service;

import com.study.demo.reservation.dto.ReservationReq;
import com.study.demo.reservation.entity.Reservation;
import com.study.demo.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation findOneReservation(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation saveReservation(ReservationReq req) {
        reservationRepository.save(req.toEntity());
        return reservationRepository.findById(req.getId()).orElse(null);
    }

    public Reservation updateReservation(ReservationReq req,String id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if(reservation == null) {
            return null;
        }
        reservationRepository.save(req.toEntity());
        return reservationRepository.findById(req.getId()).orElse(null);
    }

    public String deleteReservation(String id) {
        reservationRepository.deleteById(id);
        return id;
    }
}
