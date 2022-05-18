package com.challenge4.apichallenge4.config;

import com.challenge4.apichallenge4.Entity.Role;
import com.challenge4.apichallenge4.Entity.UserLogin;
import com.challenge4.apichallenge4.Repository.UserLoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter{

    public final UserDetailsService userDetailsService;

//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Bean
    public  BCryptPasswordEncoder bCryptPasswordEncoder(){
     return new BCryptPasswordEncoder( );
    }

//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
//        return authProvider;
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable();
       //custom loginpage.
//        RefreshToken refreshToken = new RefreshToken(authenticationManagerBean());
//        refreshToken.setFilterProcessesUrl("/api/login");
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/registration",
                "/swagger-ui.html/**","/refresh-token").permitAll();
//        http.authorizeRequests().antMatchers("/api/login/**").permitAll();
        http.authorizeRequests().antMatchers("/login/**").permitAll();
       http.authorizeRequests().antMatchers("/api/**").hasAnyAuthority("ADMIN");
       http.authorizeRequests().anyRequest().authenticated();
//       http.addFilter(refreshToken);

        //get get token from login endpoint to another endpoint
        http.addFilterBefore(new CustomAuthorFilter(), UsernamePasswordAuthenticationFilter.class);

        http.addFilter(new RefreshToken(authenticationManagerBean()));
    }



    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
