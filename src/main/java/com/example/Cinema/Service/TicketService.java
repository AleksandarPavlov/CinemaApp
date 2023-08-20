package com.example.Cinema.Service;

import com.example.Cinema.Model.Movie;
import com.example.Cinema.Model.Ticket;

import java.util.List;

public interface TicketService {
    public Ticket createTicket(Ticket ticket);
    public List<Ticket> getTicketsByMovie(Long movieId);
}
