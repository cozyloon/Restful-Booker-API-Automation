package com.qe.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBookingRequestDetails {
    private String firstname;
    private String lastname;
    private int totalprice;
    private Boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;

    @Data
    @Builder
    public static class Bookingdates {
        private String checkin;
        private String checkout;
    }
}
