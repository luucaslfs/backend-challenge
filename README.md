# Desafio Backend e Microsserviços
### Programa de estágio AsCAN - Instituto Atlântico

This repository contains the project files for the **Backend e Microsserviços** challenge of the AsCAN internship program at the **Instituto Atlântico**.
- [Development History](HISTORY.md)

### Application Diagram
![Diagrama da aplicacao](https://i.imgur.com/AYUK9QJ.png)

## Application Overview
- The application is a subscription service for a streaming platform.
    - When a user registers via POST/user, a record is created in the User table and a record is created in the Subscription table with the status 'NEVER_ACTIVATED'.
    - The application has an endpoint to update the 'Status' of a user's subscription.
    - Upon receiving a notification from the RabbitMQ queue, the listener should process the subscription status update in the database based on the received notification.

  
- Flow:
  - Notification received via HTTP  
  - Enqueuing  
  - Processing and Persistence
  - Notification Types:
       - SUBSCRIPTION_PURCHASED - The subscription was purchased, and the subscription status should be active.
       - SUBSCRIPTION_CANCELED - The subscription was canceled, and the subscription status should be canceled.
       - SUBSCRIPTION_RESTARTED - The subscription was restarted, and the subscription status should be active.

  
- Implementation divided into 3 layers:
    - Model: Contains the classes defining the data (JPA Entities).
    - Service: Contains the business logic of the application.
    - Controller: Processes interactions via HTTP requests.

For more information about the steps taken to make this project, refer to the [development history](HISTORY.md).
