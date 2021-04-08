package com.org.data.authenticator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;


/**
 * 
 * @author Kishore Hebbar
 *
 */

@Configuration
@EnableGlobalMethodSecurity(
  prePostEnabled = true, 
  securedEnabled = true, 
  jsr250Enabled = true)
public class MethodSecurityConfig  extends GlobalMethodSecurityConfiguration {

}