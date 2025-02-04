package com.cdac.idoplanner.controller.bookings;

import com.cdac.idoplanner.dto.BookingDTO;
import com.cdac.idoplanner.entities.Booking;
import com.cdac.idoplanner.entities.Client;
import com.cdac.idoplanner.entities.ServiceProvider;
import com.cdac.idoplanner.repositories.ClientRepository;  // Import ClientRepository
import com.cdac.idoplanner.service.bookings.BookingService;
import com.cdac.idoplanner.service.serviceproviders.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")  // All booking-related endpoints will be under this path
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ClientRepository clientRepository;  // Autowire ClientRepository

    @Autowired
    private ServiceProviderService serviceProviderService; // To get service provider details

    // Create a new booking
    @PostMapping("/createBooking")
    public void createBooking(@RequestBody BookingDTO bookingDTO) {
        // Retrieve Client entity directly using ClientRepository
        Client client = clientRepository.findById(bookingDTO.getClientId()).orElse(null);  // Use ClientRepository to fetch client by ID
        ServiceProvider serviceProvider = serviceProviderService.getServiceProviderById(bookingDTO.getSpId());

        if (client != null && serviceProvider != null) {
            // Create the Booking entity
            Booking booking = new Booking();
            booking.setClient(client);  // Set the Client entity
            booking.setServiceProvider(serviceProvider);  // Set the ServiceProvider entity
            booking.setBookingDate(bookingDTO.getBookingDate());  // Set the Booking Date
            booking.setStatus(bookingDTO.getStatus());  // Set the Status

            // Save the booking using the service
            bookingService.createBooking(booking);
        } else {
            // Handle client or service provider not found (you can throw an exception or return an error message)
            // This is just an example, you can handle it differently as per your requirements
            throw new RuntimeException("Client or ServiceProvider not found");
        }
    }

    // Get a booking by its ID
    @GetMapping("/getBooking")
    public Booking getBooking(@RequestParam Integer bookingId) {
        return bookingService.getBooking(bookingId);  // Retrieve booking by ID
    }

    // Get all bookings
    @GetMapping("/getAllBookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();  // Retrieve all bookings
    }

    // Delete a booking
    @DeleteMapping("/deleteBooking")
    public void deleteBooking(@RequestParam Integer bookingId) {
        bookingService.deleteBooking(bookingId);  // Delete booking by ID
    }
}
