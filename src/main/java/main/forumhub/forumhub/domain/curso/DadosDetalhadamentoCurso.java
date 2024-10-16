package main.forumhub.forumhub.domain.curso;


/**
 *
 * Classe que representa os dados detalhados de um curso.
 * 
 * <p>Essa classe é utilizada no controlador CursoController.
 * 
 * @see CursoController
 * @see Curso
 * @see DadosCadastroCursos
 * @see DadosAtualizacaoCurso
 * @see Categoria
 * @see CursoRepository
 * @see CursoService
 * 
 * @see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/record.html">Record</a>
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
public record DadosDetalhadamentoCurso(
        Long id,
        String nome,
        Categoria categoria

) {
    public DadosDetalhadamentoCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
