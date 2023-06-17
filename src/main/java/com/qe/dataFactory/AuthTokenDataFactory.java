package com.qe.dataFactory;

import com.qe.model.AuthToken;

import static com.qe.common.Constants.AUTH_PASSWORD;
import static com.qe.common.Constants.AUTH_USERNAME;

public class AuthTokenDataFactory {

    public static AuthToken createAuthToken() {

        return AuthToken.builder()
                .username(AUTH_USERNAME)
                .password(AUTH_PASSWORD)
                .build();
    }
}
