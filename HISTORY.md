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
>  - No caso desse projeto, se trata de apenas um endpoint que deve atualizar o status da assinatura de um cliente. 
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
          -  SUBSCRIPTION_PURCHASED - A Compra foi realizada e a assinatura deve estar com status ativa.  
          -  SUBSCRIPTION_CANCELED - A Compra foi cancelada e a assinatura deve estar com status cancelada.  
          -  SUBSCRIPTION_RESTARTED - A Compra foi recuperada e a assinatura deve estar com status ativa.  
>	
>	
>	- Dividir implementação do Endpoint em 3 camadas.    
		-  Model - Camada que abriga as classes que definem os dados (Entidades JPA).  
		-  Service - Camada que abriga as regras de negócio da aplicação.   
		-  Controller - Camada que processa as interações via requests HTTP.  


### Histórico: 

    13/03 - Inicialização do projeto e do repositório, primeiros passos.

	14/03 - Criadas as classes model, definindo os dados da aplicação de acordo com o diagrama.
            Status, EventHistory, Subscription and User.
	
    17/03 - Refactor do repositório do projeto p/ se adequar ao git flow

    20/03 - Criação do README.md e do HISTORY.md