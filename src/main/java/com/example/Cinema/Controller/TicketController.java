package com.example.Cinema.Controller;

import com.example.Cinema.Model.Movie;
import com.example.Cinema.Model.Ticket;
import com.example.Cinema.Service.MovieService;
import com.example.Cinema.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
        return new ResponseEntity<>(ticketService.createTicket(ticket), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Ticket>> getTicketsByMovie(@PathVariable("id")Long movieId){
        return new ResponseEntity<>(ticketService.getTicketsByMovie(movieId), HttpStatus.OK);
    }
}
