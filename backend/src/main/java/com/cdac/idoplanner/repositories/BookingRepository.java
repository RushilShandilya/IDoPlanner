package com.cdac.idoplanner.repositories;

import com.cdac.idoplanner.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    
    
}
