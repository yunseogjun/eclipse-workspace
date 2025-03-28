package com.example.spring.myapp.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        Server server = new Server();   // API 서버 설정
//        server.setUrl("http://localhost:8080");
//        
        Server prodServer = new Server();  // 운영서버에 따로 띄우기 위해 서버를 추가할 수 있다.
        server.setUrl("http://localhost:8080");

        Info info = new Info()
                .title("Swagger API")       // API 문서 제목
                .version("v1.0.0")          // API 문서 버전
                .description("스웨거 API"); // API 문서 설명

        return new OpenAPI()
                .info(info)
                .servers(List.of(server, prodServer));    
    }
}