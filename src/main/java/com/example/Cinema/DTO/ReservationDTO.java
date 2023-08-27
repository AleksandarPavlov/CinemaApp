package com.example.Cinema.DTO;

import jakarta.persistence.*;

import java.time.LocalDate;

public class ReservationDTO {


    private Long reservationId;
    private String username;
    private Long ticketId;
    private Long movieId;
    private int ticketsQuantity;
    private int price;
    private LocalDate date;
    private String movieImage;
    private String movieName;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public int getTicketsQuantity() {
        return ticketsQuantity;
    }

    public void setTicketsQuantity(int ticketsQuantity) {
        this.ticketsQuantity = ticketsQuantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public ReservationDTO(){

    }

    public ReservationDTO(Long reservationId, String username, Long ticketId, Long movieId, int ticketsQuantity, int price, LocalDate date, String movieImage, String movieName) {
        this.reservationId = reservationId;
        this.username = username;
        this.ticketId = ticketId;
        this.movieId = movieId;
        this.ticketsQuantity = ticketsQuantity;
        this.price = price;
        this.date = date;
        this.movieImage = movieImage;
        this.movieName = movieName;
    }
}
