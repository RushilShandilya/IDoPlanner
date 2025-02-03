package com.cdac.idoplanner.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="ServiceProviders")
@Getter
@Setter
@NoArgsConstructor
public class ServiceProvider{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer bookingId;

    LocalDateTime bookingDate;
    String status;

    @ManyToOne
    @JoinColumn(name="serviceId")
    Service service;
}
