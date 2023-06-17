package com.qe.tests;

import com.qe.dataFactory.BookingDataFactory;
import com.qe.model.BookingResponseDetails;
import com.qe.model.CreateBookingRequestDetails;
import com.qe.model.CreatedBookingResponseDetails;
import com.qe.util.ResponseUtil;
import com.qe.util.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qe.data.RequestComponents.BOOKING_BASE_PATH;

public class Example extends TestBase {
    CreatedBookingResponseDetails expectedBookingDetails = new CreatedBookingResponseDetails();

    @BeforeClass
    public void createABooking() {
        CreateBookingRequestDetails createdBooking = BookingDataFactory.createABooking();

        restAssuredWrapper.setBody(createdBooking);
        Response response = restAssuredWrapper.post(BOOKING_BASE_PATH);
        expectedBookingDetails = ResponseUtil.mapResponseToModel(response, CreatedBookingResponseDetails.class);

    }

    @Test
    public void getABookDetailsById() {
        Response response = restAssuredWrapper.get(BOOKING_BASE_PATH + "/" + expectedBookingDetails.getBookingid());
        BookingResponseDetails actualBookingDetails = ResponseUtil.mapResponseToModel(response, BookingResponseDetails.class);

        softAssert.assertEquals(expectedBookingDetails.getBooking().getFirstname(),
                actualBookingDetails.getFirstname());
        softAssert.assertEquals(expectedBookingDetails.getBooking().getLastname(),
                actualBookingDetails.getLastname());
        softAssert.assertEquals(expectedBookingDetails.getBooking().getDepositpaid(),
                actualBookingDetails.getDepositpaid());
        softAssert.assertEquals(expectedBookingDetails.getBooking().getTotalprice(),
                actualBookingDetails.getTotalprice());
        softAssert.assertEquals(expectedBookingDetails.getBooking().getAdditionalneeds(),
                actualBookingDetails.getAdditionalneeds());
        softAssert.assertEquals(expectedBookingDetails.getBooking().getBookingdates().getCheckin(),
                actualBookingDetails.getBookingdates().getCheckin());
        softAssert.assertEquals(expectedBookingDetails.getBooking().getBookingdates().getCheckout(),
                actualBookingDetails.getBookingdates().getCheckout());
        softAssert.assertAll();

        restAssuredWrapper.validateJsonSchema(BOOKING_BASE_PATH + "/" + expectedBookingDetails.getBookingid());
    }

    @AfterClass
    public void deleteBooking() {
        //dbHelper.deleteDataFromDB();
    }
}
