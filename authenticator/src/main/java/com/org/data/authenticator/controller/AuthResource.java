package com.org.data.authenticator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.org.data.authenticator.model.AuthenticateRequest;
import com.org.data.authenticator.model.JwtAuthenticationResponse;
import com.org.data.authenticator.model.UserPrincipal;
import com.org.data.authenticator.service.JWTTokenProvider;

/**
 * 
 * @author Kishore Hebbar
 *
 */

@RestController
@RequestMapping("/authenticate")
public class AuthResource {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProvider jwtTokenProvider;


    @PostMapping
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@RequestBody AuthenticateRequest authenticateRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(), authenticateRequest.getPassword()));
        String token =jwtTokenProvider.generateToken((UserPrincipal)authentication.getPrincipal());
        //log.info("Token Created {}",token);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }


}
