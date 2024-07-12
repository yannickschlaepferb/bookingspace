package ch.schlaepfer.bookingspace.repository;

import ch.schlaepfer.bookingspace.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
