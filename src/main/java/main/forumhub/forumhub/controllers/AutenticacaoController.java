package main.forumhub.forumhub.controllers;


import jakarta.validation.Valid;
import main.forumhub.forumhub.domain.usuario.DadosAutenticacao;
import main.forumhub.forumhub.domain.usuario.Usuario;
import main.forumhub.forumhub.infra.security.DadosTokenJWT;
import main.forumhub.forumhub.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Controlador para autenticação de usuários.
 * <p>Esse controlador é responsável por autenticar usuários e gerar um token JWT para o usuário autenticado.
 * <p>Esse controlador é acessado através do endpoint "/login".
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efeituarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }


}
