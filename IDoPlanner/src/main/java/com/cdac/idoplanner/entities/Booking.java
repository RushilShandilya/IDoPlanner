package com.cdac.idoplanner.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
}
