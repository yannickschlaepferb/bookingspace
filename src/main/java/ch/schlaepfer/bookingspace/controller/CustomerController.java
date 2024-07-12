package ch.schlaepfer.bookingspace.controller;

import ch.schlaepfer.bookingspace.dto.BookingRequest;
import ch.schlaepfer.bookingspace.dto.PasswordChangeRequest;
import ch.schlaepfer.bookingspace.model.Customer;
import ch.schlaepfer.bookingspace.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        try {
            Customer newCustomer = customerService.registerCustomer(customer);
            return ResponseEntity.status(201).body("Benutzer erstellt und JWT Token zurückgegeben.");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody Customer customer) {
        Customer existingCustomer = customerService.findByEmail(customer.getEmail());
        if (existingCustomer == null || !customer.getPassword().equals(existingCustomer.getPassword())) {
            return ResponseEntity.status(401).body("Ungültige Anmeldeinformationen.");
        }
        return ResponseEntity.ok("JWT Token zurückgegeben.");
    }

    @PutMapping("/customers/{customerId}/password")
    public ResponseEntity<?> changePassword(@PathVariable Long customerId, @RequestBody PasswordChangeRequest request) {
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            return ResponseEntity.status(404).body("Benutzer nicht gefunden.");
        }
        customerService.saveCustomer(customer);
        return ResponseEntity.ok("Passwort erfolgreich geändert.");
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long customerId) {
        if (customerService.findById(customerId) == null) {
            return ResponseEntity.status(404).body("Benutzer nicht gefunden.");
        }

        customerService.deleteCustomer(customerId);
        return ResponseEntity.status(204).body("Benutzerkonto erfolgreich gelöscht.");
    }

    @PostMapping("/bookings")
    public ResponseEntity<?> requestBooking(@RequestBody BookingRequest bookingRequest) {
        return ResponseEntity.status(201).body("Buchung erfolgreich angefragt.");
    }

    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<?> getBookingStatus(@PathVariable Long bookingId) {
        return ResponseEntity.ok("Buchungsdetails inkl. Status.");
    }

    @DeleteMapping("/bookings/{bookingId}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long bookingId) {
        return ResponseEntity.status(204).body("Buchung erfolgreich storniert.");
    }
}
