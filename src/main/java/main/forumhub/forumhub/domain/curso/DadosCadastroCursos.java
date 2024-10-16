package main.forumhub.forumhub.domain.curso;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * Classe que representa os dados necessários para cadastrar um curso.
 * 
 * <p>Essa classe é utilizada no controlador CursoController.
 * 
 * @see CursoController
 * @see Curso
 * @see DadosAtualizacaoCurso
 * @see DadosDetalhadamentoCurso
 * @see Categoria
 * @see CursoRepository
 * @see CursoService
 * 
 * @see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/record.html">Record</a>
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
public record DadosCadastroCursos(
        @JsonAlias("nomeCurso")
        @NotBlank
        String nome,
        @NotNull
        Categoria categoria

) {
}
