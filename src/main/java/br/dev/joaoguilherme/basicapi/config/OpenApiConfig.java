package br.dev.joaoguilherme.basicapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(
        contact = @Contact(
                name = "João Guilherme",
                email = "mail@joaoguilherne.dev",
                url = "https://joaoguilherme.dev/"
        ),
        title = "Basic API",
        description = "API básica para estudos",
        version = "1.0"),
        servers = {
                @Server(
                        description = "Servidor Local",
                        url = "http://localhost:8080"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "Basic Authentication"
                )
        }
)
@SecurityScheme(
        name = "Basic Authentication",
        description = "Autorização do tipo 'Basic' use para username 'user' e para password utilize 'password'.",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
public class OpenApiConfig {
}
