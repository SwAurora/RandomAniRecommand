package com.sw.randomanirecommand.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception
    {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                {
                    auth.requestMatchers("/", "/*", "/login", "/signUp", "/anime/*", "/anime/*/*", "/anime/*/*/*", "/board", "/error", "/fragment/*", "/css/*", "/js/*").permitAll();
                    auth.requestMatchers("/user").hasRole("USER");
                })
                .httpBasic(Customizer.withDefaults())
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
