package com.org.data.authenticator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author Kishore Hebbar
 *
 */

public class JwtAuthenticationResponse {

    private String accessToken;
    private final  String tokenType = "Bearer";
    
    
    
	public JwtAuthenticationResponse() {
	}
	public JwtAuthenticationResponse(String accessToken) {
		super();
		this.accessToken = accessToken;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
    
    

}
