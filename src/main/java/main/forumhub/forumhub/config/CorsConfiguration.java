package main.forumhub.forumhub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe de configuração para permitir requisições de origens diferentes.
 * 
 * <p>Essa classe permite que o front-end, que está rodando em uma origem diferente da API, faça requisições para a API.
 * 
 * <p>Essa configuração é necessária para que o front-end consiga acessar a API.
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
