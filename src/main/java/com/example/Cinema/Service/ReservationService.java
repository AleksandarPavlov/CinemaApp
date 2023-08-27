package com.example.Cinema.Service;

import com.example.Cinema.DTO.ReservationDTO;
import com.example.Cinema.Model.Movie;
import com.example.Cinema.Model.Reservation;

import java.util.List;

public interface ReservationService {
    public Reservation createReservation(Reservation reservation);
    public List<ReservationDTO> getReservationsByUsername(String username);
}
