# Documentação do FrontEnd: Sistema de Reviews de Jogos

## Descrição Geral

O frontend do projeto é desenvolvido em React Native, proporcionando uma experiência de usuário fluida e responsiva tanto para dispositivos iOS quanto Android. O aplicativo permite que os usuários façam login, publiquem reviews, visualizem reviews de outros usuários e criem listas de jogos.

## Funcionalidades Principais

- **Login e Registro de Usuários:** Interface intuitiva para autenticação de usuários.
- **Publicação de Reviews:** Os usuários podem publicar reviews para jogos específicos.
- **Visualização de Reviews:** Os usuários podem visualizar reviews publicadas por outros usuários.
- **Criação e Compartilhamento de Listas de Jogos:** Os usuários podem criar listas de jogos e compartilhá-las com outros usuários.

## Tecnologias Utilizadas

- **React Native:** Framework principal para desenvolvimento do frontend.
- **React Navigation:** Para gerenciamento de navegação entre telas.
- **Axios:** Para comunicação com o backend.
- **Expo:** Para desenvolvimento e deploy do aplicativo.

## Estrutura do Projeto

O projeto segue uma estrutura de diretórios organizada em componentes, containers e serviços:

- **components:** Contém componentes reutilizáveis como Header, Footer, Card de Review, etc.
- **screens:** Contém as principais telas do aplicativo, como Login, Registro, Reviews, etc.
- **services:** Contém serviços para comunicação com o backend, como API calls.
- **styles:** Contém estilos globais e temas.
- **models:** Possui as classes de dados e suas interfaces para transferir dados entre componentes e telas.

## Principais Telas e Componentes

### Telas


### Componentes

## Navegação

A navegação entre telas é gerenciada utilizando React Navigation, com suporte a navegação por stack e por abas.

## Integração com o Backend

A comunicação com o backend é realizada utilizando Axios, com tratamento de erros de rede e respostas do backend.

## Autenticação e Autorização

A autenticação é tratada armazenando tokens JWT no dispositivo do usuário e utilizando Context API para gerenciar o estado de autenticação.

## Estilização

A estilização é feita utilizando StyleSheet do React Native, com uma paleta de cores e temas consistentes.

## Testes

Os testes são realizados utilizando Jest e React Testing Library, cobrindo tanto testes unitários quanto de interface.

## Deploy e CI/CD

O aplicativo é implantado utilizando Expo, com um pipeline de CI/CD configurado no GitHub Actions para automatizar testes e builds.

## Configurações e Variáveis de Ambiente

As configurações do projeto são gerenciadas através de arquivos `.env`, com variáveis de ambiente para configurações sensíveis.

## Contribuição

O projeto está sendo desenvolvido por Fernando B. (Engenheiro de Software) e Lidia C. (Estudante de Engenharia).

## Licença

O projeto está sob a licença MIT. Para mais detalhes, consulte o arquivo `LICENSE` no repositório do projeto.
