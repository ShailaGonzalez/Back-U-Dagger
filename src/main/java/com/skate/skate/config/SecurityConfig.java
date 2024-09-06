package com.skate.skate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Uso de la sintaxis Lambda DSL
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/**").authenticated() // Requiere autenticación
                .anyRequest().permitAll() // Permite todas las demás solicitudes
            )
            .formLogin(form -> form
                .loginPage("/login") // Página de inicio de sesión personalizada
                .permitAll() // Permitir acceso sin autenticación a /login
            )
            .cors(cors -> cors.disable()) // Deshabilitar CORS si no es necesario
            .csrf(csrf -> csrf.disable()); // Deshabilitar CSRF si no lo necesitas

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
