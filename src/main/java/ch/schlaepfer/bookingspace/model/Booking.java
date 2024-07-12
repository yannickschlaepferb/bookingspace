package ch.schlaepfer.bookingspace.model;

import ch.schlaepfer.bookingspace.model.Enums.BookingStatus;
import ch.schlaepfer.bookingspace.model.Enums.BookingTypes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private BookingTypes bookingType;
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=true)
    private Customer customer;
}
