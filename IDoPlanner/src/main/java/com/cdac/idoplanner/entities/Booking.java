package com.cdac.idoplanner.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Bookings")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private Integer bookingId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", referencedColumnName = "clientId", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "spId", referencedColumnName = "spId", nullable = false)
    private ServiceProvider serviceProvider;

    @Column(name = "bookingDate", nullable = false)
    private LocalDateTime bookingDate;

    @Column(name = "status", length = 20, nullable = false)
    private String status; // e.g., "Pending", "Confirmed", "Completed"

    // Default Constructor
    public Booking() {
    }

    // Parameterized Constructor
    public Booking(Client client, ServiceProvider serviceProvider, LocalDateTime bookingDate, String status) {
        this.client = client;
        this.serviceProvider = serviceProvider;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    // Getters and Setters
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

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
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
