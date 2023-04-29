package com.qe.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class ResponseUtil {
    public static <T> T mapResponseToModel(Response response, Class<T> modelClass) {
        String body = response.getBody().asString();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(body, modelClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}