package main.forumhub.forumhub.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import main.forumhub.forumhub.domain.curso.CursoRepository;
//import main.forumhub.forumhub.domain.resposta.RespostaRespository;
import main.forumhub.forumhub.domain.topico.*;
import main.forumhub.forumhub.domain.usuario.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class TopicoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroTopico> dadosCadastroTopicoJson;

    //@Autowired
    //private JacksonTester<DadosDetalhadamentoTopico> dadosDetalhadamentoTopicoJson;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    //@Autowired
    //private RespostaRespository respostaRespository;

    @MockBean
    private TopicoRepository topicoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }


    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao incorretas")
    @WithMockUser
    void cadastrar_cenario1() throws Exception {
        var response = mvc
                .perform(post("/topicos"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());

    }

    @Test
    @DisplayName("Deveria devolver codigo http 201 quando informacoes estao corretas")
    @WithMockUser
    void cadastrar_cenario2() throws Exception{
        var autor = usuarioRepository.getReferenceByEmail("joao.pedro@example.com");
        var curso = cursoRepository.localizarCurso("Design de Interfaces Usuário");

        var dadosCadastro = new DadosCadastroTopico(
            "Título do Tópico", "Mensagem do Tópico", "Nome do Curso"
        );

        var topico = new Topico(null, dadosCadastro.titulo(), dadosCadastro.mensagem(), LocalDateTime.now(), EstadoDoTopico.AGUARDANDO, autor, curso, null);

        when(topicoRepository.save(any())).thenReturn(topico);


        String token = "$2a$10$BnUgLvgNPLJ5JhKmDPFLae2.Sx0RJTatbPVEp8u2jHlR5tNRDBMTK"; // "senha": "senha010203"

        var response = mvc
                .perform(post("/topicos")
                        .header(HttpHeaders.AUTHORIZATION, token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroTopicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        var dadosDetalhadamento = new DadosDetalhadamentoTopico(topico);

        DadosDetalhadamentoTopico actualResponse = objectMapper.readValue(response.getContentAsString(), DadosDetalhadamentoTopico.class);


 //       var jsonEsperado = dadosDetalhadamentoTopicoJson.write(dadosDetalhadamento).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(actualResponse.id()).isEqualTo(dadosDetalhadamento.id());
        assertThat(actualResponse.titulo()).isEqualTo(dadosDetalhadamento.titulo());




    }
}
