package com.qe.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthToken {
    private String username;
    private String password;
}
