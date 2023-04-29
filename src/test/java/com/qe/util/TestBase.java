package com.qe.util;

import com.qe.data.RequestComponents;
import io.github.cozyloon.EzConfig;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class TestBase {
    public static SoftAssert softAssert;
    public static RestAssuredWrapper restAssuredWrapper;

    @BeforeSuite
    public void beforeSuite() {
        restAssuredWrapper = new RestAssuredWrapper();
        Response response = restAssuredWrapper.get(RequestComponents.PING_BASE_PATH);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @BeforeTest
    public void beforeTest() {
        EzConfig.logINFO("TestClass Running" + this.getClass().toString());
        softAssert = new SoftAssert();
    }
}
