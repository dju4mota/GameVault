# Documentação do Projeto: Sistema de Reviews de Jogos

## Descrição Geral

O projeto consiste em uma API desenvolvida em Spring Boot que permite aos usuários criar e publicar reviews de jogos. Além disso, os usuários podem criar e compartilhar listas de jogos. O sistema também oferece funcionalidades de login e registro de usuários, utilizando Spring Boot Security para autenticação.

## Funcionalidades Principais

- **Login e Registro de Usuários:** Autenticação segura utilizando Spring Boot Security.
- **Publicação de Reviews:** Usuários podem publicar reviews para jogos específicos.
- **Visualização de Reviews:** Usuários podem visualizar reviews publicadas por outros usuários.
- **Criação e Compartilhamento de Listas de Jogos:** Usuários podem criar listas de jogos e compartilhá-las com outros usuários.
- **Buscar Jogos:** Buscar jogos pelo nome.

## Tecnologias Utilizadas

- **Spring Boot:** Framework principal para desenvolvimento do backend.
- **Spring Boot Security:** Para autenticação e autorização.
- **MySQL:** Banco de dados relacional para armazenamento de dados.
- **Docker:** Para conteinerização e deploy da aplicação.
- **GitHub Actions:** Para CI/CD, automatizando testes e builds.

## Arquitetura do Projeto

O projeto segue uma arquitetura em camadas, divida principalmente entre Controllers, Service, Models.
Repositories e DTO's também ajudam a compor o sistema.

## Endpoints da API

Rodando o projeto e acessando
'http://localhost:8080/swagger-ui/index.html'
é possível visulizar as rotas e suas informações 

## Modelo de Dados

### Entidades Principais

- **User:**
  - `id`: Identificador único do usuário.
  - `username`: Nome de usuário.
  - `password`: Senha do usuário (criptografada).
  - `email`: Email do usuário.

- **Game:**
  - `id`: Identificador único do jogo.
  - `title`: Nome do jogo.
  - `description`: Descrição do jogo.
  - `genre`: Gênero do jogo.
      
- **Review:**
  - `id`: Identificador único da review.
  - `userId`: ID do usuário que publicou a review.
  - `gameId`: ID do jogo que está sendo revisado.
  - `rating`: Nota dada ao jogo.
  - `comment`: Comentário sobre o jogo.
  - `hoursPlayed`: Horas jogadas.
  - `data`: Data de postagem.
  - `platform`: Plataforma utilizada.

## Autenticação e Autorização

A autenticação é realizada utilizando Spring Boot Security, com suporte a JWT (JSON Web Tokens) para garantir a segurança das transações. A autorização é baseada em roles, onde diferentes níveis de acesso podem ser definidos.

## Testes

O projeto inclui testes automatizados, tanto unitários quanto de integração, utilizando `SpringBootTest`. Os testes cobrem as principais funcionalidades do sistema, garantindo a qualidade e a confiabilidade do código.

## Deploy e CI/CD

O projeto utiliza Docker para conteinerização, facilitando o deploy em diferentes ambientes. O CI/CD é gerenciado através do GitHub Actions, que automatiza os processos de teste e build, garantindo que o código esteja sempre em um estado deployável.

## Configurações e Variáveis de Ambiente

As configurações do projeto são gerenciadas através de arquivos `application.properties` e variáveis de ambiente. Configurações sensíveis, como credenciais de banco de dados e chaves de API, são armazenadas de forma segura.

## Contribuição

O projeto está sendo desenvolvido por Fernando B. (Engenheiro de Software) e Lidia C. (Estudante de Engenharia). 

## Licença

O projeto está sob a licença MIT. Para mais detalhes, consulte o arquivo `LICENSE` no repositório do projeto.

