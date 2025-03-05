package dev.layseiras.hellorecruiter.docs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Hello Recruiter",
                version = "1.0",
                description = "Documentação da API integrada ao ChatGPT para gerar corpo de email para recrutadores"
        )
)
public class SwaggerConfig {
}