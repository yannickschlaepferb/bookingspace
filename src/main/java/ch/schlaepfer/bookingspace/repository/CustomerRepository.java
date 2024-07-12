package ch.schlaepfer.bookingspace.repository;

import ch.schlaepfer.bookingspace.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
