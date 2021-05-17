package com.org.data.authenticator.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.org.data.authenticator.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Kishore Hebbar
 *
 */
 
public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String email;
    private String password;

    public UserPrincipal(String email,String password,Collection<? extends GrantedAuthority> authorities){
        this.email=email;
        this.password=password;
        this.authorities=authorities;
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new UserPrincipal(user.getEmail(),user.getPassword(),authorities);
    }
}
