package main.forumhub.forumhub.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("API do projeto ForumHub")
                .version("1.0.0")
                .description("O FórumHub é uma API REST desenvolvida em Java utilizando Spring Boot, que simula um fórum de discussão. Nesta API, os usuários podem criar, visualizar, atualizar e deletar tópicos de discussão, perfis, respostas, cursos e usuários. A partir de agora, apenas usuários autenticados podem interagir com a API.")
                .termsOfService("https://github.com/vampirow/alura-forum-hub")
                .contact(new Contact()
                        .name("Daniel Ciesla")
                        .url("https://github.com/vampirow")))
                
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }

}
