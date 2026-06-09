package com.manoj.inventory.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI inventoryOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Inventory Management System API")
                        .description("REST APIs for Inventory Management System")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Manoj")
                                .email("manoj@example.com")))

                // JWT SECURITY CONFIGURATION
                .addSecurityItem(
                        new SecurityRequirement()
                                .addList("Bearer Authentication"))

                .schemaRequirement(
                        "Bearer Authentication",
                        new SecurityScheme()
                                .name("Bearer Authentication")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"));
    }
}