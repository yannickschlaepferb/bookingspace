package ch.schlaepfer.bookingspace.service;

import ch.schlaepfer.bookingspace.model.Customer;
import ch.schlaepfer.bookingspace.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer registerCustomer(Customer customer) {
        if (customerRepository.findByEmail(customer.getEmail()) != null) {
            throw new IllegalStateException("Benutzer mit dieser E-Mail existiert bereits.");
        }

        return customerRepository.save(customer);
    }
}
