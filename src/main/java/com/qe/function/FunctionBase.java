package com.qe.function;

import java.util.HashMap;
import java.util.Map;

public class FunctionBase {
    FunctionBase() {
    }

    static final String CONTENT_TYPE = "Content-Type";
    static final String APPLICATION_JSON = "application/json";

    public static Map<String, String> getRequestHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, APPLICATION_JSON);
        return headers;
    }
}
