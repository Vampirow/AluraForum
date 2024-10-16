package main.forumhub.forumhub.domain.curso;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

/**
 *
 * Classe que representa os dados necessários para atualizar um curso.
 *      
 * <p>Essa classe é utilizada no controlador CursoController.
 * 
 * @see CursoController
 * @see Curso
 * @see DadosCadastroCursos
 * @see DadosDetalhadamentoCurso
 * @see Categoria
 * @see CursoRepository
 * @see CursoService
 * 
 * @see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/record.html">Record</a>
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
public record DadosAtualizacaoCurso(
        @NotNull
        Long id,
        @JsonAlias("nomeCurso")
        String nome,
        Categoria categoria
) {
}
