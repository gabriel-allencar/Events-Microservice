package com.alencar.events_microservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
            title = "Events Microservice",
            version = "v1",
            description = "Documentação da API de eventos"
        )
)
public class OpenApiConfig {
}
