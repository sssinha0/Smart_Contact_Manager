package com.infy.smartcontact.config.JwtConfig;

import com.infy.smartcontact.service.serviceImpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {
        @Autowired
        private UserDetailsServiceImpl userDetailsService;
        @Autowired
        private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
        @Autowired
        private JwtAuthenticationFilter jwtAuthenticationFilter;

        @Bean
        public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception{
            return configuration.getAuthenticationManager();
        }
        @Bean
        public BCryptPasswordEncoder passwordEncoder(){

            return new BCryptPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider daoAuthenticationProvider(){
            DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
            provider.setPasswordEncoder(passwordEncoder());
            provider.setUserDetailsService(userDetailsService);
            return provider;
        }
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http
                    .csrf()
                    .disable()
                    .cors()
                    .disable()
                    .authorizeRequests()
                    .requestMatchers("/generate-token","/user/signup").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS).permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.authenticationProvider(daoAuthenticationProvider());
            http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
            return http.build();
        }
}
