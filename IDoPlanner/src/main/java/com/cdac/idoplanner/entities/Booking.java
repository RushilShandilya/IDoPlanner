package com.cdac.idoplanner.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private Integer bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId", referencedColumnName = "clientId")
    private Client client;

    @Column(name = "weddingDate")
    private LocalDate weddingDate;

    @Column(name = "weddingVenue", length = 255)
    private String weddingVenue;

    @Column(name = "totalCost")
    private Double totalCost;

    @Column(name = "status", length = 50)
    private String status;  // e.g., "Pending", "Confirmed", "Completed"

    // You can add more attributes as needed like guests, wedding package, etc.

    public Booking(){

    }

    public Booking(Client client, LocalDate weddingDate, String weddingVenue, Double totalCost, String status) {
        this.client = client;
        this.weddingDate = weddingDate;
        this.weddingVenue = weddingVenue;
        this.totalCost = totalCost;
        this.status = status;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
}
