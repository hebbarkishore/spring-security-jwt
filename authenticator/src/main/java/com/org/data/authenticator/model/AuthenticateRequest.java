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

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateRequest {
    private  String userName;
    private String password;
}
