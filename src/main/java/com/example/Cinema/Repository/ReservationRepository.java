package com.example.Cinema.Repository;

import com.example.Cinema.Model.Reservation;
import com.example.Cinema.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findReservationsByUsername(String username);
}
