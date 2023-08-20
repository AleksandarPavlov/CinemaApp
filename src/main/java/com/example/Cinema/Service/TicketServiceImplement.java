package com.example.Cinema.Service;

import com.example.Cinema.Model.Ticket;
import com.example.Cinema.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImplement implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getTicketsByMovie(Long movieId) {
        return ticketRepository.findTicketsByMovieId(movieId);
    }
}
