package com.org.data.authenticator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.org.data.authenticator.filter.JwtAuthenticationFilter;
import com.org.data.authenticator.service.InvalidLoginAttemptHandler;
import com.org.data.authenticator.service.UserAuthDetailsService;

/**
 * 
 * @author Kishore Hebbar
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserAuthDetailsService userAuthDetailsService;

    @Autowired
    private InvalidLoginAttemptHandler invalidLoginAttemptHandler;

    @Autowired
    private JwtAuthenticationFilter jwtRequestFilter;

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder

                .userDetailsService(userAuthDetailsService)
                .passwordEncoder(passwordEncoder());

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {    	
    	http.authorizeRequests()
    	
    	// all other requests need to be authenticated
    	.anyRequest().authenticated()

    	// make sure we use stateless session
    	.and().exceptionHandling().authenticationEntryPoint(invalidLoginAttemptHandler).and().sessionManagement()
    	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	
    	// Add a filter to validate the tokens with every request
    	http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        	.antMatchers("/authenticate")
        	.antMatchers("/")
        	.antMatchers("/css/**")
        	.antMatchers("/js/**")
            .antMatchers("/h2-console/**");
    }

}
