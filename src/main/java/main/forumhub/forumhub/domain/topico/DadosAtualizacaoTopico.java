package main.forumhub.forumhub.domain.topico;

/**
 *
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
public record DadosAtualizacaoTopico(
        String mensagem,
        String titulo) {
    public DadosAtualizacaoTopico(Topico topico){
        this(topico.getMensagem(), topico.getTitulo());
    }
}
