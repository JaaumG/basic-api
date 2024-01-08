package br.dev.joaoguilherme.basicapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(
        contact = @Contact(
                name = "João Guilherme ",
                email = "mail@joaoguilherne.dev",
                url = "https://joaoguilherme.dev/"
        ),
        title = "Basic API",
        description = "API básica para estudos",
        version = "1.0"),
        servers = {
                @Server(
                        description = "localhost",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
