package com.cdac.idoplanner.dto;

import java.time.LocalDateTime;

public class BookingDTO {
    private Integer clientId;
    private Integer spId;
    private LocalDateTime bookingDate;
    private String status;

    public BookingDTO(){}

    public BookingDTO(Integer clientId,Integer spId,LocalDateTime bookingDate,String status){
        this.clientId=clientId;
        this.spId=spId;
        this.bookingDate=bookingDate;
        this.status = status;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

