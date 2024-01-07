// src/main/java/com/yourcompany/busbookingsystem/repository/BookingRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Custom queries if needed

    // Example: Retrieve bookings by user
    List<Booking> findByUser(User user);

    // Example: Retrieve bookings by bus
    List<Booking> findByBus(Bus bus);

    // Example: Retrieve bookings by seat number
    Booking findBySeatNumberAndBus(int seatNumber, Bus bus);
}
