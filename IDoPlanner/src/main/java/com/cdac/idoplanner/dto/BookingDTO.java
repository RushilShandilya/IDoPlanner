package com.cdac.idoplanner.dto;

import java.time.LocalDate;

public class BookingDTO {
    private Integer bookingId;
    private Integer clientId; // Assuming you'll send the client ID in the DTO instead of the entire client object
    private LocalDate weddingDate;
    private String weddingVenue;
    private Double totalCost;
    private String status;

    // Getters and Setters
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDate getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(LocalDate weddingDate) {
        this.weddingDate = weddingDate;
    }

    public String getWeddingVenue() {
        return weddingVenue;
    }

    public void setWeddingVenue(String weddingVenue) {
        this.weddingVenue = weddingVenue;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingDTO [bookingId=" + bookingId + ", clientId=" + clientId + ", weddingDate=" + weddingDate 
               + ", weddingVenue=" + weddingVenue + ", totalCost=" + totalCost + ", status=" + status + "]";
    }
}

