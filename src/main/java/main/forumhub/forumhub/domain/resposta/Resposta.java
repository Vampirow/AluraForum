package main.forumhub.forumhub.domain.resposta;

import jakarta.persistence.*;
import lombok.*;
import main.forumhub.forumhub.domain.topico.Topico;
import main.forumhub.forumhub.domain.usuario.Usuario;

import java.time.LocalDateTime;

/**
 *
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
@Entity(name = "Resposta")
@Table(name = "respostas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String mensagem;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topico_id") // Foreign key to 'topicos' table
    private Topico topico;
    private LocalDateTime dataCriacao;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarios_id") // Foreign key to 'usuarios' table
    private Usuario autor;
    @Enumerated(EnumType.STRING)
    private StatusResposta status;

    public void autualizarInformacoes(DadosAtualizacaoResposta dados) {
        if(dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if(dados.status() != null){
            this.status = dados.status();
        }

    }
}


