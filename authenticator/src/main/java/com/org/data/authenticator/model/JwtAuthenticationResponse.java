package com.org.data.authenticator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author Kishore Hebbar
 *
 */

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse {

    private String accessToken;
    private final  String tokenType = "Bearer";

}
