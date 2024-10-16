# Alura - ONE Oracle Next Education T6
##  Challenge Fórum HUB
| ![Alura - ONE Oracle Next Education T6](/docs/src/img/logo_alura_one.png) |
|:---:|
| Curso ONE Oracle Next Education T6 é uma parceria entre a Oracle e a Alura, onde estou me dedicando à resolução do desafio FórumHub. O FórumHub é uma API REST desenvolvida em Java utilizando Spring Boot, que simula um fórum de discussão. Nesta API, os usuários podem criar, visualizar, atualizar e deletar tópicos de discussão, perfis, respostas, cursos e usuários. A partir de agora, apenas usuários autenticados podem interagir com a API. Este desafio é imprescindível, pois faz parte essencial do programa ONE, proporcionando a oportunidade de aplicar conceitos importantes aprendidos durante o curso. |
| <a href="https://cursos.alura.com.br/user/vampirowo" target="_blank"><img style="margin: 10px" height="531" width="472" src="/docs/src/img/apresentacao.gif" alt="Imagem Apresentação"/></a> |

<a href="https://spring.io/"><img height="35" src="https://img.shields.io/badge/Spring-008000?style=for-the-badge&logo=spring&logoColor=white"></a>
<a href="https://docs.oracle.com/en/java/javase/20/"><img height= "35" src= "https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"></a>
<a href="https://www.postgresql.org/"><img height="35" src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"></a>


## Índice
<a id="topo"></a>

- [Apresentação](#apresentacao)
- [Funcionalidades](#funcionalidades)
- [Executar](#executar)
- [Testes](#testes)
- [Conclusão](#conclusao)
- [Badge](#badge)
- [Licença](#licenca)


## <a name="apresentacao"> Apresentação </a>

Este é um projeto desenvolvido durante o curso de Java ofertado pela Alura para as turmas da Oracle ONE.
Este projeto, chamado Fórum HUB, é uma API REST desenvolvida em Java utilizando Spring Boot. Ele simula um fórum de discussão, onde os usuários podem criar, visualizar, atualizar e deletar tópicos de discussão, perfis, respostas, cursos e usuários. A partir de agora, apenas usuários autenticados podem interagir com a API. Este desafio é uma parte essencial do programa ONE Oracle Next Education T6, uma parceria entre a Oracle e a Alura, onde você terá a oportunidade de aplicar conceitos aprendidos durante o curso.


## <a name="funcionalidades"> Funcionalidades </a>

A aplicação oferece as seguintes funcionalidades:
- **Cadastrar Usuário:** Permite cadastrar um novo usuário no sistema.
- **Visualizar Tópicos:** Permite visualizar todos os tópicos de discussão disponíveis.
- **Atualizar Tópico:** Permite atualizar as informações de um tópico existente.
- **Deletar Tópico:** Permite excluir um tópico do sistema.
- **Criar Resposta:** Permite criar uma nova resposta em um tópico específico.
- **Visualizar Perfil:** Permite visualizar o perfil de um usuário.
- **Atualizar Perfil:** Permite atualizar as informações do perfil de um usuário.
- **Deletar Perfil:** Permite excluir o perfil de um usuário do sistema.
- **Criar Curso:** Permite criar um novo curso no sistema.
- **Visualizar Cursos:** Permite visualizar todos os cursos disponíveis.
- **Atualizar Curso:** Permite atualizar as informações de um curso existente.
- **Deletar Curso:** Permite excluir um curso do sistema.
- **Visualizar Usuários:** Permite visualizar todos os usuários cadastrados no sistema.
- **Atualizar Usuário:** Permite atualizar as informações de um usuário existente.
- **Deletar Usuário:** Permite excluir um usuário do sistema.

<p align="right">
  <a href="#topo" style="text-decoration: none; background-color: #007bff; color: white; padding: 10px 20px; border-radius: 5px;">Voltar ao Topo</a>
</p>

## <a name="executar"> Executar </a>

Para executar o projeto localmente, siga estas etapas:

1. Clone este repositório para o seu ambiente local.
2. Certifique-se de ter o JDK (Java Development Kit) e Maven instalados em sua máquina.
3. Abra o prompt no diretório principal e execute o comando:
   ```sh
   mvn clean install
   ```
4. Configure o ambiente de banco de dados de acordo com as configurações do projeto. (Este projeto utiliza PostgreSQL).
5. Configure as variáveis de ambiente corretamente:
   - `JAVA_HOME`: Caminho para o diretório do seu JDK
   - `M2_HOME`: Caminho para o diretório do seu Maven
   - Adicione ambos ao `PATH` incluindo `\bin` no final.

### Configuração POSTGRES

Defina as seguintes variáveis de ambiente:

- `DB_HOST`: Host do PostgreSQL (se estiver rodando localmente, será `localhost`)
- `DB_NAME`: Nome do banco de dados criado
- `DB_USER`: Seu usuário PostgreSQL
- `DB_PASSWORD`: Sua senha PostgreSQL

No arquivo de configuração, utilize as variáveis da seguinte maneira:

```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

<p align="right">
  <a href="#topo" style="text-decoration: none; background-color: #007bff; color: white; padding: 10px 20px; border-radius: 5px;">Voltar ao Topo</a>
</p>

## <a name="testes"> Testes </a>

## Documentação de Testes em Java para Controllers

Esta documentação descreve os testes de integração para os controllers de uma aplicação Spring Boot. Os testes são configurados para simular chamadas HTTP e testar a serialização e deserialização de dados. Eles utilizam mocks para simular o comportamento do banco de dados e testar a funcionalidade dos controllers sem a necessidade de uma conexão real.

### TopicoControllerTest.java

#### Anotações de Classe
- `@SpringBootTest`: Indica que a classe é um teste que deve carregar o contexto do Spring.
- `@AutoConfigureMockMvc`: Configura automaticamente o MockMvc.
- `@AutoConfigureJsonTesters`: Configura automaticamente os testadores JSON.

#### Campos
- `MockMvc mvc`: Para simular chamadas HTTP.
- `JacksonTester<DadosCadastroTopico> dadosCadastroTopicoJson`: Para testar a serialização e deserialização de `DadosCadastroTopico`.

#### Observações
- A classe `TopicoControllerTest` é configurada para realizar testes de integração com o Spring Boot, focando no comportamento do `TopicoController`.
- Utiliza-se `@MockBean` para criar mocks dos repositórios necessários, permitindo simular o comportamento do banco de dados sem a necessidade de uma conexão real.
- `@WithMockUser` pode ser usado em métodos de teste para simular a autenticação de um usuário.
- A documentação acima é baseada nas primeiras 49 linhas do arquivo e pode não representar a totalidade do teste ou das funcionalidades testadas.

### RespostaControllerTest.java

#### Anotações de Classe
- `@SpringBootTest`: Indica que a classe é um teste que deve carregar o contexto do Spring.
- `@AutoConfigureMockMvc`: Configura automaticamente o MockMvc.
- `@AutoConfigureJsonTesters`: Configura automaticamente os testadores JSON.

#### Campos
- `MockMvc mvc`: Para simular chamadas HTTP.
- `JacksonTester<DadosCadastroResposta> dadosCadastroRespostaJson`: Para testar a serialização e deserialização de `DadosCadastroResposta`.
- `TopicoRepository topicoRepository`: Mock do repositório de tópicos.

#### Observações
- A classe `RespostaControllerTest` é configurada para realizar testes de integração com o Spring Boot, focando no comportamento do `RespostaController`.
- Utiliza-se `@MockBean` para criar mocks dos repositórios necessários, permitindo simular o comportamento do banco de dados sem a necessidade de uma conexão real.
- `@WithMockUser` pode ser usado em métodos de teste para simular a autenticação de um usuário.
- A classe parece incompleta, pois há comentários indicando partes do código que podem ter sido removidas ou estão pendentes de implementação (como o `dadosDetalhadamentoRespostaJson`).
- A documentação acima é baseada nas primeiras 49 linhas do arquivo e pode não representar a totalidade do teste ou das funcionalidades testadas.

### CursoControllerTest.java

#### Anotações de Classe
- `@SpringBootTest`: Indica que a classe é uma classe de teste que deve ser executada com o suporte do Spring Boot para testes, incluindo a configuração do contexto da aplicação.
- `@AutoConfigureMockMvc`: Configura automaticamente o MockMvc.
- `@AutoConfigureJsonTesters`: Configura automaticamente os testadores JSON.

#### Campos
- `MockMvc mvc`: Injetado para simular requisições HTTP.
- `JacksonTester<DadosCadastroCursos> dadosCadastroCursosJason`: Utilizado para testar a serialização e deserialização de objetos relacionados ao cadastro de cursos.
- `JacksonTester<DadosDetalhadamentoCurso> dadosDetalhadamentoCursoJason`: Utilizado para testar a serialização e deserialização de objetos relacionados ao detalhamento de cursos.
- `CursoRepository repository`: Mockado para simular operações do repositório de cursos.

#### Métodos

##### `void curso_cenario1()`
- **Anotações**:
  - `@Test`: Indica que o método é um teste.
  - `@DisplayName("Deveria devolver código 400 quando informações estão inválidas")`: Descreve o propósito do teste.
  - `@WithMockUser`: Executa o teste com um usuário mockado.
- **Descrição**: Testa o cenário onde informações inválidas são enviadas para o endpoint de cursos, esperando-se que o código de resposta seja 400 (Bad Request).
- **Exceções**: `Exception`: Lançada se ocorrer algum erro durante a execução do teste.

### ForumhubApplicationTests.java

#### Anotações de Classe
- `@SpringBootTest`: Indica que a classe é uma classe de teste que deve ser executada com o suporte do Spring Boot para testes, incluindo a configuração do contexto da aplicação.

#### Métodos

##### `void contextLoads()`
- **Anotações**: `@Test`
- **Descrição**: Método de teste para verificar se o contexto da aplicação é carregado com sucesso.
- **Parâmetros**: Nenhum.
- **Retorno**: Void (não retorna nada).



## <a name="conclusao"> Conclusão </a>

Este projeto foi desenvolvido com o intuito de aplicar os conceitos aprendidos durante o curso de Java da Alura. Através dele, pude aprimorar meus conhecimentos em Spring Boot, Spring Security, JPA, Hibernate, entre outros. Além disso, pude aprender a utilizar o Postman para testar as requisições da API. Este projeto foi uma excelente oportunidade para consolidar o aprendizado e me preparar para os próximos desafios que virão pela frente.

<p align="right">
  <a href="#topo" style="text-decoration: none; background-color: #007bff; color: white; padding: 10px 20px; border-radius: 5px;">Voltar ao Topo</a>
</p>


## <a name="badge"></a>Badge

- Badge

[![Badge](docs/src/img/badge.png)](https://cursos.alura.com.br/user/vampirow)



<p align="right">
  <a href="#topo" style="text-decoration: none; background-color: #007bff; color: white; padding: 10px 20px; border-radius: 5px;">Voltar ao Topo</a>
</p>

## <a name="licenca"> Licença </a>
