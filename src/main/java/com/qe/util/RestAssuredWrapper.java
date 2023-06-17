package com.qe.util;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;

import static com.qe.common.Constants.BASE_URL;
import static com.qe.common.Constants.FILE_PATH;

public class RestAssuredWrapper {
    private RequestSpecification requestSpec;

    public RestAssuredWrapper() {

        RestAssured.baseURI = BASE_URL;

        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    public void setHeader(Map<String, ?> header) {
        requestSpec = requestSpec.headers(header);
    }

    public void setQueryParam(Map<String, ?> queryParam) {
        requestSpec = requestSpec.queryParams(queryParam);
    }

    public void setBody(Object body) {
        requestSpec = requestSpec.body(body);
    }

    public Response get(String path) {
        return RestAssured.given(requestSpec)
                .when()
                .get(path)
                .then()
                //  .statusCode(200)
                .extract()
                .response();
    }

    public Response post(String path) {
        return RestAssured.given(requestSpec)
                .when()
                .post(path)
                .then()
                //   .statusCode(200)
                .extract()
                .response();
    }

    public Response put(String path) {
        return RestAssured.given(requestSpec)
                .when()
                .put(path)
                .then()
                .extract()
                .response();
    }

    public Response delete(String path) {
        return RestAssured.given(requestSpec)
                .when()
                .delete(path)
                .then()
                //.statusCode(200)
                .extract()
                .response();
    }

    public void validateJsonSchema(String path) {
        File file = new File(FILE_PATH + "getBookingSchema.json");

        RestAssured.given(requestSpec)
                .when()
                .get(path)
                .then()
                .statusCode(200)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(file));
    }
}

