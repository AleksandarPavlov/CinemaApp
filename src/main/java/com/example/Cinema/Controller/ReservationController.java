package com.example.Cinema.Controller;

import com.example.Cinema.DTO.ReservationDTO;
import com.example.Cinema.Model.Movie;
import com.example.Cinema.Model.Reservation;
import com.example.Cinema.Model.Ticket;
import com.example.Cinema.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservations")
@CrossOrigin("*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @PostMapping("/")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        return new ResponseEntity<>(reservationService.createReservation(reservation), HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<List<ReservationDTO>> getReservationsByUsername(@PathVariable("username")String username){
        return new ResponseEntity<>(reservationService.getReservationsByUsername(username), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void cancelReservation(@PathVariable("id")Long reservationId){
        reservationService.cancelReservation(reservationId);
    }
}
