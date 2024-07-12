package ch.schlaepfer.bookingspace.dto;

import ch.schlaepfer.bookingspace.model.Enums.BookingTypes;
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
public class BookingRequest {
    @NotBlank
    private Date date;

    @NotBlank
    private BookingTypes bookingType;

    private Long memberId;
}
