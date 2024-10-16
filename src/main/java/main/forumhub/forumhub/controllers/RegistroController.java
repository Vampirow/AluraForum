package main.forumhub.forumhub.controllers;

import jakarta.validation.Valid;
import main.forumhub.forumhub.domain.ValidacaoException;
import main.forumhub.forumhub.domain.usuario.DadosAutenticacao;
import main.forumhub.forumhub.domain.usuario.DadosRegitro;
import main.forumhub.forumhub.domain.usuario.UserService;
import main.forumhub.forumhub.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Controlador para registro de usuários.
 * <p>Esse controlador é responsável por registrar novos usuários no sistema.
 * <p>Esse controlador é acessado através do endpoint "/cadastrar".
 * 
 * <p>Esse controlador possui o método:
 * <ul>
 * <li>registrarUsuario: Método para registrar um novo usuário no sistema.</li>
 * </ul>
 * 
 * <p>Esse controlador utiliza as classes:
 * <ul>
 * <li>UserService: Classe responsável por gerenciar os usuários do sistema.</li>
 * <li>DadosAutenticacao: Classe que representa os dados necessários para autenticar um usuário.</li>
 * <li>DadosRegitro: Classe que representa os dados de registro de um usuário.</li>
 * <li>Usuario: Entidade que representa um usuário no sistema.</li>
 * </ul>
 * 
 * <p>Esse controlador é utilizado pelo controlador AutenticacaoController.
 * 
 * @see AutenticacaoController
 * @see UserService
 * @see DadosAutenticacao
 * @see DadosRegitro
 * @see Usuario
 *
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
@RestController
@RequestMapping("/cadastrar")
public class RegistroController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> registrarUsuario(@RequestBody @Valid DadosAutenticacao dados) {
        try {
            Usuario newUser = userService.cadastrarNovoUsuario(dados);
            return ResponseEntity.status(HttpStatus.CREATED).body(new DadosRegitro(newUser));
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

