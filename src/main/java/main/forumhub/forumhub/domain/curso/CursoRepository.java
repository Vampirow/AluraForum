package main.forumhub.forumhub.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * Interface para acesso ao banco de dados de cursos.
 * 
 * <p>Essa interface é responsável por disponibilizar métodos para acesso ao banco de dados de cursos.
 * 
 * <p>Essa interface é utilizada pela classe CursoService.
 * 
 * @see CursoService
 * @see Curso
 * @see DadosCadastroCursos
 * @see DadosAtualizacaoCurso
 * @see DadosDetalhadamentoCurso
 * @see Categoria
 * @see CursoController
 * 
 * @see <a href="
 *     https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html">JpaRepository</a>
 * @see <a href="https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/Query.html">Query</a>
 * 
 * @see <a href="https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html">JpaRepository</a>
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT c FROM Curso c WHERE LOWER(c.nome) = LOWER(:nomeCurso)")
    Curso localizarCurso(String nomeCurso);
}
