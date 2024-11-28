package br.com.hoteliza.reservation_api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/customer/{customerId}").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/customer/{customerId}").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.POST, "/reservation/register").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/reservation/{reservationId}").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/reservation/list/customer/{customerId}").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/reservation/list/hotel/{hotelId}").hasRole("OWNER")
                        .requestMatchers(HttpMethod.POST, "/hotel/register").hasRole("OWNER")
                        .requestMatchers(HttpMethod.PUT, "/hotel/{hotelId}").hasRole("OWNER")
                        .requestMatchers(HttpMethod.GET, "/hotel/{hotelId}").hasRole("OWNER")
                        .requestMatchers(HttpMethod.GET, "/hotel/list").permitAll()
                        .requestMatchers(HttpMethod.GET, "/hotel/list/{ownerId}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/room/register").hasRole("OWNER")
                        .requestMatchers(HttpMethod.PUT, "/room/{roomId}").hasRole("OWNER")
                        .requestMatchers(HttpMethod.GET, "/room/{roomId}").hasRole("OWNER")
                        .requestMatchers(HttpMethod.GET, "/room/list/{hotelId}").permitAll()     
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
