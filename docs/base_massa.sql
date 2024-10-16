SELECT * FROM usuarios
SELECT * FROM cursos
SELECT * FROM topicos
SELECT * FROM respostas


	<!-- @author <a href="https://github.com/vampirow">Daniel Ciesla</a> -->
INSERT INTO usuarios (nome, email, senha) VALUES 
('Alice Silva', 'alice.silva@example.com', 'senha123'),
('Bruno Santos', 'bruno.santos@example.com', 'senha456'),
('Carla Pereira', 'carla.pereira@example.com', 'senha789'),
('Daniel Costa', 'daniel.costa@example.com', 'senha101'),
('Elena Martins', 'elena.martins@example.com', 'senha202'),
('Fernando Almeida', 'fernando.almeida@example.com', 'senha303'),
('Gabriela Nunes', 'gabriela.nunes@example.com', 'senha404'),
('Henrique Oliveira', 'henrique.oliveira@example.com', 'senha505'),
('Isabela Souza', 'isabela.souza@example.com', 'senha606'),
('João Pedro', 'joao.pedro@example.com', 'senha707'),
('Larissa Lima', 'larissa.lima@example.com', 'senha808'),
('Marcos Ribeiro', 'marcos.ribeiro@example.com', 'senha909'),
('Natália Araújo', 'natalia.araujo@example.com', 'senha010'),
('Otávio Rocha', 'otavio.rocha@example.com', 'senha111'),
('Paula Mendes', 'paula.mendes@example.com', 'senha121'),
('Ricardo Teixeira', 'ricardo.teixeira@example.com', 'senha131'),
('Sofia Ferreira', 'sofia.ferreira@example.com', 'senha141'),
('Thiago Barbosa', 'thiago.barbosa@example.com', 'senha151'),
('Vanessa Costa', 'vanessa.costa@example.com', 'senha161'),
('William Cardoso', 'william.cardoso@example.com', 'senha171');

INSERT INTO cursos (nome, categoria) VALUES
('Java Fundamentals', 'PROGRAMACAO'),
('SQL Avançado', 'BANCO_DE_DADOS'),
('Desenvolvimento Front-end com React', 'DESENVOLVIMENTO'),
('Machine Learning na Prática', 'DATA_SCIENCE'),
('Engenharia de Software Moderna', 'ENGENHARIA'),
('Redes Avançadas: Segurança e Desempenho', 'REDES'),
('Segurança da Informação Corporativa', 'SEGURANCA'),
('Desenvolvimento Mobile com Flutter', 'DESENVOLVIMENTO_MOBILE'),
('DevOps: Integração Contínua e Entrega', 'DEVOPS'),
('Metodologias Ágeis: Scrum e Kanban', 'GERENCIAMENTO'),
('Análise de Sistemas Complexos', 'ANALISE'),
('Administração de Sistemas Linux', 'ADMINISTRACAO'),
('Design de Interfaces Usuário', 'DESIGN'),
('Front-end Avançado com Vue.js', 'TECNOLOGIA'),
('Back-end com Node.js e MongoDB', 'PROGRAMACAO'),
('Big Data Analytics: Ferramentas e Aplicações', 'DATA_SCIENCE'),
('Internet das Coisas: Conceitos e Aplicações', 'TECNOLOGIA'),
('Realidade Virtual e Aumentada: Tecnologias Emergentes', 'INTELIGENCIA_ARTIFICIAL'),
('Blockchain: Fundamentos e Aplicações', 'TECNOLOGIA'),
('Python para Data Science', 'DATA_SCIENCE');




-- Tópicos
INSERT INTO topicos (titulo, mensagem, data_criacao, estado_do_topico, usuarios_id, curso_id) VALUES
('Dúvida sobre loops em Python', 'Alguém pode explicar como funcionam os loops for em Python?', current_timestamp, 'AGUARDANDO', 1, 1),
('Problemas com JOIN em SQL', 'Estou com dificuldades para entender como fazer um JOIN em SQL. Alguém pode ajudar?', current_timestamp, 'ABERTO', 2, 2),
('Qual a melhor prática para estrutura de CSS?', 'Gostaria de saber qual a melhor prática para organizar o CSS em um projeto web.', current_timestamp, 'FECHADO', 3, 3),
('Como importar bibliotecas no R?', 'Quais são os comandos para importar bibliotecas no R?', current_timestamp, 'AGUARDANDO', 4, 4),
('Implementação de algoritmo de regressão', 'Alguém tem um exemplo de código para regressão linear em Python?', current_timestamp, 'ABERTO', 5, 5),
('Arquitetura de software para sistemas grandes', 'Quais são as melhores práticas para arquitetura de software em grandes sistemas?', current_timestamp, 'AGUARDANDO', 6, 6),
('Configuração de VPN', 'Como configurar uma VPN segura?', current_timestamp, 'AGUARDANDO', 7, 7),
('Boas práticas de segurança para desenvolvimento web', 'Quais são as principais práticas de segurança ao desenvolver aplicações web?', current_timestamp, 'FECHADO', 8, 8),
('Diferença entre frameworks de front-end', 'Qual é a diferença entre React, Angular e Vue?', current_timestamp, 'AGUARDANDO', 9, 9),
('Ciclo de vida do DevOps', 'Como funciona o ciclo de vida do DevOps?', current_timestamp, 'ABERTO', 10, 10),
('Scrum vs Kanban', 'Quais são as principais diferenças entre Scrum e Kanban?', current_timestamp, 'FECHADO', 11, 11),
('Análise de requisitos de sistemas', 'Como fazer uma análise de requisitos de sistemas eficiente?', current_timestamp, 'AGUARDANDO', 12, 12),
('Gerenciamento de usuários no Linux', 'Qual é o comando para adicionar um usuário no Linux?', current_timestamp, 'AGUARDANDO', 13, 13),
('Melhor abordagem para design de interfaces', 'Qual a melhor abordagem para design de interfaces em projetos grandes?', current_timestamp, 'ABERTO', 14, 14),
('Uso avançado de Flexbox no CSS', 'Como usar o Flexbox para criar layouts complexos?', current_timestamp, 'AGUARDANDO', 15, 15),
('Integração do Node.js com bancos de dados', 'Como integrar o Node.js com um banco de dados MySQL?', current_timestamp, 'FECHADO', 16, 16),
('Ferramentas para análise de Big Data', 'Quais são as principais ferramentas para análise de Big Data?', current_timestamp, 'AGUARDANDO', 17, 17),
('Desafios na implementação de IoT', 'Quais são os principais desafios na implementação de soluções de IoT?', current_timestamp, 'AGUARDANDO', 18, 18),
('Desenvolvimento de aplicações de realidade virtual', 'Quais são as melhores práticas para o desenvolvimento de aplicações de realidade virtual?', current_timestamp, 'AGUARDANDO', 19, 19),
('Introdução ao Blockchain', 'Como funciona a tecnologia Blockchain?', current_timestamp, 'ABERTO', 20, 20);

INSERT INTO respostas (nome, mensagem, topico_id, data_criacao, usuarios_id, status) VALUES
('Alice Silva', 'Nos loops for em Python, você utiliza a estrutura `for item in lista:` para iterar sobre os elementos da lista. Cada `item` representa um elemento da lista a cada iteração.', 1, current_timestamp, 1, 'ABERTO'),
('Bruno Santos', 'Para realizar um JOIN em SQL, você utiliza a cláusula `JOIN` para combinar registros de duas ou mais tabelas baseados em uma condição específica.', 2, current_timestamp, 3, 'ABERTO'),
('Carla Pereira', 'Uma boa prática para estrutura de CSS é utilizar metodologias como BEM (Block, Element, Modifier) para organizar seu código CSS de forma mais modular e reutilizável.', 3, current_timestamp, 4, 'ABERTO'),
('Daniel Costa', 'Para importar bibliotecas no R, você pode usar o comando `library(nome_da_biblioteca)` para carregar as funções e recursos da biblioteca desejada.', 4, current_timestamp, 5, 'ABERTO'),
('Elena Martins', 'Para implementar um algoritmo de regressão linear em Python, você pode utilizar bibliotecas como NumPy e scikit-learn, que oferecem funções prontas para isso.', 5, current_timestamp, 6, 'ABERTO'),
('Fernando Almeida', 'Em grandes sistemas, é recomendado seguir padrões arquiteturais como microserviços e utilizar tecnologias escaláveis para garantir a robustez e manutenibilidade do sistema.', 6, current_timestamp, 7, 'ABERTO'),
('Gabriela Nunes', 'Para configurar uma VPN segura, é importante definir protocolos de segurança como IPSec e utilizar chaves criptográficas robustas para proteger a comunicação.', 7, current_timestamp, 8, 'ABERTO'),
('Henrique Oliveira', 'Ao desenvolver aplicações web, boas práticas de segurança incluem validação de entrada de dados, uso de HTTPS, e atualização regular de frameworks e bibliotecas.', 8, current_timestamp, 9, 'ABERTO'),
('Isabela Souza', 'As principais diferenças entre React, Angular e Vue estão na estrutura, curva de aprendizado e abordagem para desenvolvimento de interfaces de usuário.', 9, current_timestamp, 10, 'ABERTO'),
('João Pedro', 'O ciclo de vida do DevOps envolve etapas como planejamento, desenvolvimento, integração, entrega, operação e monitoramento contínuo de software.', 10, current_timestamp, 11, 'ABERTO'),
('Larissa Lima', 'As principais diferenças entre Scrum e Kanban estão na metodologia de gestão de tarefas e no foco em fluxo contínuo (Kanban) versus iterações (Scrum).', 11, current_timestamp, 12, 'ABERTO'),
('Marcos Ribeiro', 'Para fazer uma análise de requisitos eficiente, é importante envolver stakeholders, definir requisitos funcionais e não funcionais, e utilizar ferramentas adequadas.', 12, current_timestamp, 13, 'ABERTO'),
('Natália Araújo', 'Para adicionar um usuário no Linux, você pode usar o comando `sudo adduser nome_do_usuario` para criar um novo usuário no sistema operacional Linux.', 13, current_timestamp, 14, 'ABERTO'),
('Otávio Rocha', 'Ao projetar interfaces em projetos grandes, é recomendado utilizar princípios de design como consistência visual, hierarquia de informação e modularização de componentes.', 14, current_timestamp, 15, 'ABERTO'),
('Paula Mendes', 'Para criar layouts complexos com Flexbox, você pode usar propriedades como `display: flex`, `flex-direction`, `justify-content` e `align-items` para controlar a disposição dos elementos.', 15, current_timestamp, 16, 'ABERTO'),
('Ricardo Teixeira', 'Para integrar o Node.js com um banco de dados MySQL, você pode usar bibliotecas como `mysql` ou `sequelize` para estabelecer a conexão e realizar operações de banco de dados.', 16, current_timestamp, 17, 'ABERTO'),
('Sofia Ferreira', 'Para análise de Big Data, ferramentas populares incluem Hadoop, Spark e Apache Kafka, que oferecem capacidades para processamento e análise de grandes volumes de dados.', 17, current_timestamp, 18, 'ABERTO'),
('Thiago Barbosa', 'Os principais desafios na implementação de IoT incluem segurança, interoperabilidade, gerenciamento de energia e integração com sistemas existentes.', 18, current_timestamp, 19, 'ABERTO'),
('Vanessa Costa', 'Para o desenvolvimento de aplicações de realidade virtual, é importante considerar hardware compatível, otimização de desempenho e experiência do usuário imersiva.', 19, current_timestamp, 20, 'ABERTO'),
('William Cardoso', 'Blockchain é uma tecnologia de registro distribuído que utiliza criptografia para garantir a segurança e integridade das transações em uma rede descentralizada.', 20, current_timestamp, 20, 'ABERTO');


