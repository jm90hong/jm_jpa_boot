package com.my.jm_jpa_boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	//BCrypt 인증 //비밀번호 암호화 처리
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 모든 요청에 대해 인증을 비활성화
        http.csrf(csrf ->csrf.disable())
            .authorizeHttpRequests((requests) -> requests
                .anyRequest().permitAll() // 모든 요청에 대해 허용
            );

        return http.build();
    }
}