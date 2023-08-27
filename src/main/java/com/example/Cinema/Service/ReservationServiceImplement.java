package com.example.Cinema.Service;

import com.example.Cinema.DTO.ReservationDTO;
import com.example.Cinema.Model.Movie;
import com.example.Cinema.Model.Reservation;
import com.example.Cinema.Repository.MovieRepository;
import com.example.Cinema.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImplement implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<ReservationDTO> getReservationsByUsername(String username) {
        List<Reservation> reservations = reservationRepository.findReservationsByUsername(username);
        List<ReservationDTO> reservationDTOS = new ArrayList<>();
        for(Reservation x : reservations){
            ReservationDTO newReservation = new ReservationDTO();
            newReservation.setReservationId(x.getReservationId());
            newReservation.setUsername(x.getUsername());
            newReservation.setDate(x.getDate());
            newReservation.setPrice(x.getPrice());
            newReservation.setMovieId(x.getMovieId());
            newReservation.setTicketId(x.getTicketId());
            newReservation.setTicketsQuantity(x.getTicketsQuantity());
            Movie movie = movieRepository.findById(x.getMovieId()).orElse(null);
            newReservation.setMovieImage(movie.getImage());
            newReservation.setMovieName(movie.getName());
            reservationDTOS.add(newReservation);
        }
        return reservationDTOS;
    }
}
