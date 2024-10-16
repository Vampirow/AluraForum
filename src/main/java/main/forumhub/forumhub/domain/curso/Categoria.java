package main.forumhub.forumhub.domain.curso;

/**
 *
 * Enumeração para categorias de cursos.
 * 
 * <p>Essa enumeração é utilizada para categorizar os cursos cadastrados no sistema.
 * 
 * <p>Essa enumeração possui os seguintes valores:
 * <ul>
 * <li>PROGRAMACAO: Categoria para cursos de programação.</li>
 * <li>BANCO_DE_DADOS: Categoria para cursos de banco de dados.</li>
 * <li>DESENVOLVIMENTO: Categoria para cursos de desenvolvimento.</li>
 * <li>DATA_SCIENCE: Categoria para cursos de data science.</li>
 * <li>INTELIGENCIA_ARTIFICIAL: Categoria para cursos de inteligência artificial.</li>
 * <li>ENGENHARIA: Categoria para cursos de engenharia.</li>
 * <li>REDES: Categoria para cursos de redes.</li>
 * <li>SEGURANCA: Categoria para cursos de segurança.</li>
 * <li>DESENVOLVIMENTO_MOBILE: Categoria para cursos de desenvolvimento mobile.</li>
 * <li>DEVOPS: Categoria para cursos de DevOps.</li>
 * <li>GERENCIAMENTO: Categoria para cursos de gerenciamento.</li>
 * <li>ANALISE: Categoria para cursos de análise.</li>
 * <li>ADMINISTRACAO: Categoria para cursos de administração.</li>
 * <li>DESIGN: Categoria para cursos de design.</li>
 * <li>TECNOLOGIA: Categoria para cursos de tecnologia.</li>
 * </ul>
 * 
 * @author <a href="https://github.com/vampirow">Daniel Ciesla</a>
 */
public enum Categoria {
    PROGRAMACAO("Programação"),
    BANCO_DE_DADOS("Banco de Dados"),
    DESENVOLVIMENTO("Desenvolvimento"),
    DATA_SCIENCE("Data Science"),
    INTELIGENCIA_ARTIFICIAL("Inteligência Artificial"),
    ENGENHARIA("Engenharia"),
    REDES("Redes"),
    SEGURANCA("Segurança"),
    DESENVOLVIMENTO_MOBILE("Desenvolvimento Mobile"),
    DEVOPS("DevOps"),
    GERENCIAMENTO("Gerenciamento"),
    ANALISE("Análise"),
    ADMINISTRACAO("Administração"),
    DESIGN("Design"),
    TECNOLOGIA("Tecnologia");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
