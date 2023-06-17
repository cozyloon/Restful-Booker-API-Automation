package com.qe.model;

import lombok.Data;

@Data
public class BookingResponseDetails {
    private String firstname;
    private String lastname;
    private int totalprice;
    private Boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;

    @Data
    public static class Bookingdates {
        private String checkin;
        private String checkout;
    }
}
