package com.example.spring.myapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // 허용할 도메인 설정
                .allowedMethods("POST","GET",  "PUT", "DELETE") // 허용할 HTTP 메소드 설정
                .allowedHeaders("Origin", "Content-Type", "Accept") // 허용할 헤더 설정
                .allowCredentials(true) // 인증정보 허용 여부
                .maxAge(3600); // preflight 요청의 유효시간 설정
    }
}