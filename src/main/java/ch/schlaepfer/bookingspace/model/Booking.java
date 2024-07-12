package ch.schlaepfer.bookingspace.model;

import ch.schlaepfer.bookingspace.model.Enums.BookingStatus;
import ch.schlaepfer.bookingspace.model.Enums.BookingTypes;
import jakarta.persistence.*;
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
    private Long memberId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=true)
    private Customer customer;
}
