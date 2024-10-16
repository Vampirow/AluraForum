package main.forumhub.forumhub.controllers;


import jakarta.validation.Valid;
import main.forumhub.forumhub.domain.resposta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

/**
 *
 * Controlador para respostas.
 * 
 * <p>Esse controlador é responsável por gerenciar as respostas cadastradas no sistema.
 * <p>Esse controlador é acessado através do endpoint "/respostas".
 * 
 * <p>Esse controlador possui os seguintes métodos:
 * <ul>
 * <li>cadastrarResposta: Método para cadastrar uma nova resposta no sistema.</li>
 * <li>atualizarResposta: Método para atualizar as informações de uma resposta já cadastrada no sistema.</li>
 * <li>listarRespostas: Método para listar todas as respostas cadastradas no sistema.</li>
 * <li>deletarResposta: Método para deletar uma resposta cadastrada no sistema.</li>
 * </ul>
 * 
 * <p>Esse controlador utiliza as classes:
 * <ul>
 * <li>RespostaService: Classe responsável por gerenciar as respostas do sistema.</li>
 * <li>RespostaRespository: Interface para acesso ao banco de dados de respostas.</li>
 * <li>Resposta: Entidade que representa uma resposta no sistema.</li>
 * <li>DadosCadastroResposta: Classe que representa os dados necessários para cadastrar uma resposta.</li>
 * <li>DadosAtualizacaoResposta: Classe que representa os dados necessários para atualizar uma resposta.</li>
 * <li>DadosDetalhadamentoResposta: Classe que representa os dados detalhados de uma resposta.</li>
 * <li>DadosListarRespostas: Classe que representa os dados de uma resposta para listagem.</li>
 * </ul>
 * 
 * @see RespostaService
 * @see RespostaRespository
 * @see Resposta
 * @see DadosCadastroResposta
 * @see DadosAtualizacaoResposta
 * @see DadosDetalhadamentoResposta
 * @see DadosListarRespostas
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @Autowired
    private RespostaRespository respostaRespository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadamentoResposta> cadastrarResposta(@RequestHeader("Authorization") String token, @RequestBody @Valid DadosCadastroResposta dados, UriComponentsBuilder uriBuilder) {
        var autor = respostaService.encontrar_nomearAutor(token, dados.nome());
        var topico = respostaService.localizarTopico(dados.idTopico());

        var resposta = new Resposta(null, dados.nome(), dados.mensagem(), topico, LocalDateTime.now(), autor, StatusResposta.ABERTO);
        respostaRespository.save(resposta);
        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadamentoResposta(resposta));

    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DadosDetalhadamentoResposta> atualizarResposta(@RequestHeader("Authorization") String token, @PathVariable Long id, @RequestBody @Valid DadosAtualizacaoResposta dados) {
        var resposta = respostaService.autenticarAutor(token, id);
        resposta.autualizarInformacoes(dados);

        return ResponseEntity.ok().body(new DadosDetalhadamentoResposta(resposta));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListarRespostas>> listarRespostas(@PageableDefault(size = 10, sort = {"status"}) Pageable paginacao) {
        var page = respostaRespository.findAll(paginacao).map(DadosListarRespostas::new);

        return ResponseEntity.ok(page);


    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletarResposta(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        respostaService.deletarResposta(token, id);
        return ResponseEntity.noContent().build();
    }



}
