package com.coderoad.deliciousfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Configuration class for securing endpoints using Spring Security.
 * It defines access control based on user roles and provides options for login.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /**
     * Configures HTTP security and sets up authorization rules for various endpoints.
     *
     * @param http the HttpSecurity object to configure
     * @return the SecurityFilterChain for applying the security configuration
     * @throws Exception if an error occurs while configuring security
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // TODO: configure the access to the endpoints based on the roles.
        http
                .authorizeHttpRequests(auths -> auths
                        .requestMatchers("/api/users/register").hasRole("USER")
                        .requestMatchers("/api/users/login").hasRole("USER")

                        .requestMatchers("/api/restaurants/**").hasRole("RESTAURANT")

                        .requestMatchers("/api/restaurant/**").hasRole("RESTAURANT")
                        .requestMatchers("/api/delivery/**").hasRole("DELIVERY")
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults());

        return http.build();
    }
}
