package com.vkotecha.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author Vishal Kotecha
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.
        authorizeRequests()
        .antMatchers("/products").hasAuthority("user")
        .antMatchers("/admin/**").hasAuthority("admin")
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .successHandler(successHandler());
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService());
    // enable this to perform in memory authentication
    /*auth
        .inMemoryAuthentication()
        .withUser("vishal")
        .password(passwordEncoder().encode("password"))
        .authorities(Collections.emptyList())
        .and()
        .passwordEncoder(passwordEncoder());*/
  }


  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService(){
    return new DomainUserDetailService();
  }

  @Bean
  public AuthenticationSuccessHandler successHandler(){
    return new CustomSuccessHandler();
  }
}
