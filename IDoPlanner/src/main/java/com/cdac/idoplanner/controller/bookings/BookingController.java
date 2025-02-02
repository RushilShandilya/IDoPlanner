package com.cdac.idoplanner.controller.bookings;

import com.cdac.idoplanner.dto.BookingDTO;
import com.cdac.idoplanner.entities.Booking;
import com.cdac.idoplanner.service.admins.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")  // All booking-related endpoints will be under this path
public class BookingController{
    @Autowired
    private BookingService bookingService;

    // Create a new booking
    @PostMapping("/createBooking")
    public void createBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = new Booking();
    }

    // Get a booking by its ID
    @GetMapping("/getBooking")
    public Booking getBooking(@RequestParam Integer bookingId) {
        return bookingService.getBooking(bookingId);
    }

    // Get all bookings
    @GetMapping("/getAllBookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Delete a booking
    @DeleteMapping("/deleteBooking")
    public void deleteBooking(@RequestParam Integer bookingId) {
        bookingService.deleteBooking(bookingId);
    }
}
