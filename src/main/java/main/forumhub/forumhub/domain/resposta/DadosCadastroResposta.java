package main.forumhub.forumhub.domain.resposta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
/**
 *
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
public record DadosCadastroResposta(
        @NotBlank
        String nome,
        @NotNull
        Long idTopico,
        @NotBlank
        String mensagem
) {
}

