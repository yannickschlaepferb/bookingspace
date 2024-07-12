package ch.schlaepfer.bookingspace;
import ch.schlaepfer.bookingspace.model.Booking;
import ch.schlaepfer.bookingspace.model.Customer;
import ch.schlaepfer.bookingspace.model.Enums.BookingStatus;
import ch.schlaepfer.bookingspace.model.Enums.BookingTypes;
import ch.schlaepfer.bookingspace.model.Enums.Roles;
import ch.schlaepfer.bookingspace.repository.BookingRepository;
import ch.schlaepfer.bookingspace.repository.CustomerRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.Date;

@SpringBootApplication
public class BookingspaceApplication {
	private final Logger log = LoggerFactory.getLogger(BookingspaceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookingspaceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoUsers(CustomerRepository customerRepository, BookingRepository bookingRepository) {
		return (args) -> {

			String salt = BCrypt.gensalt();

			log.info("salt : " + salt);
			Customer c1 = new Customer(1L, "Sujan", "Sa-Van", "sujan.savan@customer.ch","" , BCrypt.hashpw("123", salt), Roles.ADMIN);
			Customer c2 = new Customer(2L, "Äl", "Bane", "ÄlBane@customer.ch","" , BCrypt.hashpw("123", salt), Roles.MEMBER);
			Customer c3 = new Customer(3L, "Ethan", "Luber", "liketurtles@customer.ch","" , BCrypt.hashpw("123", salt), Roles.MEMBER);
			Customer c4 = new Customer(4L, "fiction", "al-persen", "fictionalPerson@customer.ch","" , BCrypt.hashpw("123", salt), Roles.MEMBER);


			customerRepository.save(c1);
			customerRepository.save(c2);
			customerRepository.save(c3);
			customerRepository.save(c4);

			Booking b1 = new Booking(1L, Date.valueOf("2024-01-01"), BookingTypes.FULL_DAY, BookingStatus.PENDING,  c1);
			Booking b2 = new Booking(2L, Date.valueOf("2024-01-01"), BookingTypes.HALF_DAY, BookingStatus.PENDING, c2);
			Booking b3 = new Booking(3L, Date.valueOf("2024-01-01"), BookingTypes.FULL_DAY, BookingStatus.PENDING, c3);
			Booking b4 = new Booking(4L, Date.valueOf("2024-01-01"), BookingTypes.HALF_DAY, BookingStatus.PENDING,  c4);

			bookingRepository.save(b1);
			bookingRepository.save(b2);
			bookingRepository.save(b3);
			bookingRepository.save(b4);
		};
	}


}