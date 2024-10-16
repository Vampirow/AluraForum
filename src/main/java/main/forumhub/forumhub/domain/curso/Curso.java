package main.forumhub.forumhub.domain.curso;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * Entidade que representa um curso no sistema.
 * 
 * <p>Essa entidade é responsável por representar um curso cadastrado no sistema.
 * 
 * <p>Essa entidade possui os seguintes atributos:
 * <ul>
 * <li>id: Identificador do curso.</li>
 * <li>nome: Nome do curso.</li>
 * <li>categoria: Categoria do curso.</li>
 * </ul>
 * 
 * <p>Essa entidade possui os seguintes métodos:
 * <ul>
 * <li>Curso: Construtor da classe.</li>
 * <li>atualizarInformacoes: Método para atualizar as informações de um curso.</li>
 * </ul>
 * 
 * <p>Essa entidade é utilizada pelo controlador CursoController.
 * 
 * @see CursoController
 * @see DadosCadastroCursos
 * @see DadosAtualizacaoCurso
 * @see Categoria
 * @see CursoRepository
 * @see CursoService
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DadosCadastroCursos dados) {
        this(null, dados.nome(), dados.categoria());
    }

    public void atualizarInformacoes(DadosAtualizacaoCurso dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();

        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }

    }
}
