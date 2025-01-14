package main.forumhub.forumhub.domain.resposta;

import java.time.LocalDateTime;

/**
 *
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
public record DadosListarRespostas(
        Long id,
        String nome,
        Long autor_Id,
        Long idTopico,
        LocalDateTime dataCriacao,
        String sugestao,
        StatusResposta status
) {

    public DadosListarRespostas(Resposta resposta) {
        this(resposta.getId(), resposta.getNome(),
                resposta.getAutor().getId(), resposta.getTopico().getId(),
                resposta.getDataCriacao(), resposta.getMensagem(), resposta.getStatus());
    }
}
