package com.ing.cruddocker.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(getApiInfo());
    }

    private Info getApiInfo(){
        return new Info().title("CRUD Docker API")
                .description("Demo de API CRUD levantada con Docker")
                .version("1.0");
    }
}
