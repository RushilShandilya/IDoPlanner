package com.cdac.idoplanner.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BookingDTO {
    private Integer bookingId;
    private Integer clientId;
    private Integer spId;
    private LocalDateTime bookingDate;
    private String status;
}

