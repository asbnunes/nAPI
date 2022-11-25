# nAPI

### Sobre a API
O nAPI é uma API de personagens do anime Naruto, que possibilita algumas operações básicas como:
• Cadastramento de usuários
• Autorização de usuário via token
• Troca de senha via e-mail
• Listar todos os usuários
• Excluir usuário por id
• Cadastramento de personagens
• Listar todos os personagens
• Listar personagens por id
• Excluir personagem por id

### Requisitos
Você precisa ter instalado em sua máquina os seguintes programas para rodar localmente a API:
• MySQL (https://dev.mysql.com/downloads/)
• Intellij IDEA (https://www.jetbrains.com/pt-br/idea/download) - Ou qualquer outra IDE que suporte a linguagem Java.
• SpringBoot (https://spring.io/projects/spring-boot)
• Maven (https://www.jetbrains.com/help/idea/maven-support.html) 
• Postman (https://www.postman.com/)

### Como executar
1) Baixe ou clone o código do repositório do GitHub.
2) Inicie o servidor do MySQL.
3) No Intellij, abra o projeto e aguarde a implementação das dependências necessárias.
4) Depois de carregar todo o projeto, altere o arquivo "application.properties", localizado em oop-napi/src/main/resources, mudando o campo spring.datasource.password para a senha do seu usuário root do MySQL.
5) Vincule o banco de dados através da aba Database clicando em new > Data Soure > MySQL.
6) Crie dos endpoints necessários no Postman. 
7) No Intellij, inicialize a API clicando em Run, na barra superior, ou utilizando o atalho Shift + F10.
8) A API está rodando e pronta para ser utilizada.
9) Para acessar a documentação em JSON, acesse no navegador o endereço: http://localhost:8080/v2/api-docs/

### Referências e Links
Créditos e materiais utilizados para desenvolvimento:

* [Entendendo um pouco mais de JPA e relacionamentos entre entidades](https://github.com/raquelvl/psoft/blob/master/material/back_relacionamentosJPA.md)
* [Como criptografar senhas com Java, Spring Boot, Spring Security e JPA](https://www.youtube.com/watch?v=YgfO8EHLAEc&list=PLTN1gMq8EHuIvkz0ZdFSufK-eI0FrnkvI&ab_channel=ExpertosTech)
* [Como criar um token JWT com Java, Spring Boot, Spring Security e JPA](https://www.youtube.com/playlist?list=PLTN1gMq8EHuIpxyecEp04TvLr3TQbzMRL)
* [Tutorial Spring Boot Forgot Password](http://davifelipe.com.br/spring-boot-forgot-password)
* [Spring boot backend template](https://github.com/davifelipems/spring-backend-template/tree/2ede3be043e576e557c42cf3dc5390e74f6962be)
* [Mergulho Spring REST da AlgaWorks](https://cafe.algaworks.com/mergulho-spring-rest/)
* [Updating your password - Baeldung](https://www.baeldung.com/updating-your-password/)

Desenvolvido por André Santoro, Gabriel Reis, Gustavo Pedro Lima e Maísa Moreira para a disciplina de
Programação Orientada a Objetos (2022.2) do curso de Ciência da Computação - IESB.