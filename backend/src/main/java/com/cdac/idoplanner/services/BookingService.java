package com.cdac.idoplanner.services;

import com.cdac.idoplanner.entities.Booking;
import com.cdac.idoplanner.repositories.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Create a new booking
    public void createBooking(Booking booking) {bookingRepository.save(booking);}

    // Get a booking by its ID
    public Booking getBooking(Integer bookingId) {
        return bookingRepository.findById(bookingId).orElse(null); // Returns null if not found
    }

   

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    

    // Delete a booking
    public void deleteBooking(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
