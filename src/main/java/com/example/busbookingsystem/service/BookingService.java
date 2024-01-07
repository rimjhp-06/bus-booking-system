// src/main/java/com/yourcompany/busbookingsystem/service/BookingService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        return optionalBooking.orElse(null);
    }

    public Booking addBooking(Booking booking) {
        // Add your validation logic here if needed
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long bookingId, Booking updatedBooking) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);

        if (optionalBooking.isPresent()) {
            Booking existingBooking = optionalBooking.get();
            // Update the fields based on your requirements
            existingBooking.setUser(updatedBooking.getUser());
            existingBooking.setBus(updatedBooking.getBus());
            existingBooking.setSeatNumber(updatedBooking.getSeatNumber());

            return bookingRepository.save(existingBooking);
        } else {
            return null; // Booking not found
        }
    }

    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    // Other service methods as needed
}
