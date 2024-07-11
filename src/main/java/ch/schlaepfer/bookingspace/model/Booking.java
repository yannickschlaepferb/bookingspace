package ch.schlaepfer.bookingspace.model;

import ch.schlaepfer.bookingspace.model.Enums.BookingStatus;
import ch.schlaepfer.bookingspace.model.Enums.BookingTypes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private Date date;
    @NotBlank
    private BookingTypes bookingType;
    @NotBlank
    private BookingStatus bookingStatus;
    @NotBlank
    private Long customerId;
}
