package br.com.eicon.infrastructure.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "EICON API - Gestor de Pedidos",
                description = "API REST para recepcionar pedidos dos clientes no formato xml e json"
        )
)
@Configuration
public class SwaggerConfig {
}
