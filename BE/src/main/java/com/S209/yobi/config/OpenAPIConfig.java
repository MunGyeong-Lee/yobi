package com.S209.yobi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("Yobi API")
                        .description("Yobi 서비스의 API 명세서입니다.")
                        .version("v1.0.0"))
                .servers(List.of(
                        new Server().url("https://k12s209.p.ssafy.io/api").description("EC2 Server"),
                        new Server().url("http://192.168.100.162:8080/api").description("서현 Server"),
                        new Server().url("http://192.168.35.21:8080/api").description("서현 집"),
                        new Server().url("http://192.168.100.201:8080/api").description("문경 Server"),
                        new Server().url("http://192.168.0.115:8080/api").description("문경 집 Server"),
                        new Server().url("http://172.19.10.20:8080/api").description("Server"),
                        new Server().url("http://192.168.0.31:8080/api").description("에바 Server")
                ))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }

}
