package com.qe.dataFactory;

import com.qe.model.CreateBookingRequestDetails;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class BookingDataFactory {

    public static CreateBookingRequestDetails createABooking() {

        return CreateBookingRequestDetails.builder()
                .firstname(RandomStringUtils.randomAlphabetic(5))
                .lastname(RandomStringUtils.randomNumeric(5))
                .totalprice(RandomUtils.nextInt(0, 999))
                .depositpaid(true)
                .bookingdates(CreateBookingRequestDetails.Bookingdates.builder()
                        .checkin(String.valueOf(Instant.now().truncatedTo(ChronoUnit.SECONDS)))
                        .checkout(String.valueOf(Instant.now().truncatedTo(ChronoUnit.SECONDS)))
                        .build())
                .additionalneeds("Breakfast")
                .build();
    }
}
