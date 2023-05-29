# Histórico de Desenvolvimento do Projeto

### Fontes de informação utilizadas:

- [Markdown Basic Syntax](https://www.markdownguide.org/basic-syntax)
- [Git Flow (Atlassian)](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow)
- [Git Flow (Alura)](https://www.alura.com.br/artigos/git-flow-o-que-e-como-quando-utilizar)
- [(UDEMY) Design Patterns com Java](https://www.udemy.com/course/curso-design-patterns-java)  
- [(UDEMY) Microservices w/ Spring Boot](https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud)
- [Building a REST service (documentação oficial)](https://spring.io/guides/tutorials/rest/)  
- [Create a REST API with Spring Boot](https://www.makeuseof.com/rest-api-spring-boot-create/)
- [Spring e Spring Boot (AmigosCode)](https://amigoscode.com/p/spring-boot)  
- [Spring Boot documentation](https://spring.io/guides/tutorials/)  
- [Baelung (recomendado pela comunidade Java)](https://www.baeldung.com/spring-boot-start)
- [PostgreSQL Docs](https://www.postgresql.org/docs/current/)
 
### Diagrama da aplicação 
![Diagrama da aplicacao](https://i.imgur.com/AYUK9QJ.png)

### Diagrama do Banco de Dados
![Diagrama do banco de dados da aplicacao](https://i.imgur.com/KQSMxAJ.png)
  
  
  -
  
### Roteiro:


- #### Criar README.md e HISTORY.md 
  - Necessários para documentar o desenvolvimento do projeto
  - [Markdown Basic Syntax](https://www.markdownguide.org/basic-syntax)

- #### Entender sobre Git Flow  
  - Necessário para fazer o versionamento e ter o histórico de desenvolvimento como requisitado 
  - [Artigo da Alura com passo a passo de como utilizar](https://www.alura.com.br/artigos/git-flow-o-que-e-como-quando-utilizar)


- #### Definir os endpoints da API  
>  - No caso desse projeto, se trata de apenas um endpoint que deve atualizar o status da subscription de um cliente. 
>  - Ao receber uma notificação da fila do RabbitMQ, o programa deve processar a atualização do status do usuário, na base de dados, de acordo com a notificação recebida.
>    
>
>    - Fluxo a ser seguido:  
          - Recebimento Notificação HTTP  
          - Enfileiramento  
          - Processamento e Persistência
> 
> 
>    -  Tipos de notificação:  
          -  SUBSCRIPTION_PURCHASED - A Compra foi realizada e a subscription deve estar com status ativa.  
          -  SUBSCRIPTION_CANCELED - A Compra foi cancelada e a subscription deve estar com status cancelada.  
          -  SUBSCRIPTION_RESTARTED - A Compra foi recuperada e a subscription deve estar com status ativa.  
>	
>	
>	- Dividir implementação do Endpoint em 3 camadas.    
		-  Model - Camada que abriga as classes que definem os dados (Entidades JPA).  
		-  Service - Camada que abriga as regras de negócio da aplicação.   
		-  Controller - Camada que processa as interações via requests HTTP.  


### Histórico: 

    2023

    13/03 - Inicialização do projeto e do repositório, primeiros passos.

	14/03 - Criadas as classes model, definindo os dados da aplicação de acordo com o diagrama.
            Status, EventHistory, Subscription and User.
	
    17/03 - Refactor do repositório do projeto p/ se adequar ao git flow

    20/03 - Criação do README.md e do HISTORY.md
            Refeitos arquivos perdidos por um erro de operação do Git.

    21/03 - Criadas camadas Repository, Service e Controller
            Entidades configuradas.
    
    22/03 - Feita conexão com MYSQL através do JPA e Hibernate.

    30/03 - Adicionados arquivos do rabbitmq

    03/04 - Configuração inicial do RabbitMQ

    10/04 - Banco Mysql e RabbitMQ configurados no docker

    06/05 - Ajustes nos models para melhor estabelecer as relações entre as tabelas

    10/05 - Configuração da Documentação via SpringDOC

    14/05 - Configuração do Swagger

    16/05 - Configuração do RabbitMQ concluída

    17/05 - Testes com rabbitMQ bem sucedidos

    18/05 - Desenvolvimento do endpoint para receber as notificações de alteração de status

    19/05 - Refactor dos models e criação de DTOs

    20/05 - Refactor da camada Service

    22/05 - Refactor da camada Controller

    23/05 - Endpoint funcionando, mensagem recebida e processada

    25/05 - Testes de integração criados

    28/05 - Criada documentação com SpringDOC e Swagger

    29/05 - Testes unitarios criados