package com.org.data.authenticator.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.org.data.authenticator.entity.User;
import com.org.data.authenticator.model.UserPrincipal;
import com.org.data.authenticator.repository.UserRepository;

/**
 * 
 * @author Kishore Hebbar
 *
 */

@Component
public class UserAuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserAuthDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserPrincipal loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository
                .findById(s)
                .orElseThrow(() -> new UsernameNotFoundException("User name " + s + "Not Found in DB"));
        return UserPrincipal.create(user);

    }
}
