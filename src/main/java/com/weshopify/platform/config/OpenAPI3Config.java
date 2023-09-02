package com.weshopify.platform.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Weshopify-Brands-service",
								description = "Brands Service",
								version = "v1",
								termsOfService = "All Copyrights@2023 reserved by techhubvault.com",
								contact = @Contact(email = "info@techhubvault.com",
								                   name = "TechhubVault Admin",
								                   url = "https://www.techhubvault.com/info")),
								tags = {@Tag(name = "Brands-Service",
								        description = "Brands-Service")},
								servers = {@Server(url = "http://localhost:9091")})

public class OpenAPI3Config {

}
