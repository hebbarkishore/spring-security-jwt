package com.org.data.authenticator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Kishore Hebbar
 *
 */

public class AuthenticateRequest {
    private  String userName;
    private String password;
    
       
	public AuthenticateRequest() {
	}
	
	public AuthenticateRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
