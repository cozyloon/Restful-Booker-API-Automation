package com.qe.util;

import com.qe.data.RequestComponents;
import com.qe.dataFactory.AuthTokenDataFactory;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import static com.qe.common.Constants.*;

public class TestBase {
    public SoftAssert softAssert;
    public static RestAssuredWrapper restAssuredWrapper;
    public static String authToken;
   // public static DBHelper dbHelper = new DBHelper(DB_URL, DB_USERNAME, DB_PASSWORD);

    @BeforeSuite
    public void apiHealthCheck() {
        restAssuredWrapper = new RestAssuredWrapper();
        Response response = restAssuredWrapper.get(RequestComponents.PING_BASE_PATH);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @BeforeSuite
    public void apiAuthTokenGeneration() {
        restAssuredWrapper = new RestAssuredWrapper();
        restAssuredWrapper.setBody(AuthTokenDataFactory.createAuthToken());
        Response response = restAssuredWrapper.post(RequestComponents.AUTH_BASE_PATH);
        JsonPath jsonPath = JsonPath.from(response.getBody().asString());
        authToken = jsonPath.getString("token");
    }

    @BeforeTest
    public void beforeTest() {
        LoggerUtil.logINFO("TestClass Running" + this.getClass().toString());
        this.softAssert = new SoftAssert();
    }
}
