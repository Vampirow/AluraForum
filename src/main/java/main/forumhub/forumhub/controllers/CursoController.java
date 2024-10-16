package main.forumhub.forumhub.controllers;

import jakarta.validation.Valid;
import main.forumhub.forumhub.domain.curso.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 
 * Controlador para cursos.
 * 
 * <p>Esse controlador é responsável por gerenciar os cursos cadastrados no sistema.
 * <p>Esse controlador é acessado através do endpoint "/cursos".
 * 
 * <p>Esse controlador possui os seguintes métodos:
 * <ul>
 * <li>cadastrarCurso: Método para cadastrar um novo curso no sistema.</li>
 * <li>atualizarCurso: Método para atualizar as informações de um curso já cadastrado no sistema.</li>
 * <li>listarCursos: Método para listar todos os cursos cadastrados no sistema.</li>
 * <li>deletarCurso: Método para deletar um curso cadastrado no sistema.</li>
 * </ul>
 * 
 * <p>Esse controlador utiliza as classes:
 * <ul>
 * <li>CursoRepository: Interface para acesso ao banco de dados de cursos.</li>
 * <li>Curso: Entidade que representa um curso no sistema.</li>
 * <li>DadosCadastroCursos: Classe que representa os dados necessários para cadastrar um curso.</li>
 * <li>DadosAtualizacaoCurso: Classe que representa os dados necessários para atualizar um curso.</li>
 * <li>DadosDetalhadamentoCurso: Classe que representa os dados detalhados de um curso.</li>
 * </ul>
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadamentoCurso> cadastrarCurso(@RequestBody @Valid DadosCadastroCursos dados, UriComponentsBuilder uriBuilder) {
        var curso = new Curso(dados);
        repository.save(curso);
        var uri = uriBuilder.path("cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadamentoCurso(curso));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhadamentoCurso> atualizarCurso(@RequestBody @Valid DadosAtualizacaoCurso dados) {
         var curso = repository.getReferenceById(dados.id());
        curso.atualizarInformacoes(dados);
        return ResponseEntity.ok().body(new DadosDetalhadamentoCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhadamentoCurso>> listarCursos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosDetalhadamentoCurso::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
