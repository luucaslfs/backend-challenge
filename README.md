# Desafio Backend e Microsserviços
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/19132676-93b9d2c8-0c2c-4c1e-a0e6-313a9b21cd4b?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D19132676-93b9d2c8-0c2c-4c1e-a0e6-313a9b21cd4b%26entityType%3Dcollection%26workspaceId%3Dc253871f-f102-4203-b742-299cebd203fa)
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

## How to Run the Project

Follow these steps to run the project locally:

### Prerequisites

Make sure you have the following software installed on your machine:

- Java Development Kit (JDK) 8 or higher
- Docker
- Docker Compose

### Step 1: Clone the Repository

Clone the project repository to your local machine using the following command:

```bash
git clone https://github.com/luucaslfs/backend-challenge.git
```

### Step 2: Build the JAR File

Navigate to the project directory:

```bash
cd backend-challenge
```


Build the JAR file using Maven:

```bash
mvn clean package
```


The JAR file will be generated in the `target` directory.

### Step 3: Start the Services using Docker Compose

Make sure Docker is running on your machine.

In the project directory, run the following command to start the services:

```bash
docker-compose up
```


This command will start the API, MySQL, and RabbitMQ services defined in the `docker-compose.yaml` file. The API will be accessible on port 8080.

### Step 4: Access the API

Open a web browser and navigate to the following URL:

```bash
http://localhost:8080/swagger-ui/index.html#
```

This will open the Swagger UI, where you can explore and interact with the API endpoints.

### Step 5: Shutting Down

To stop the services, press `Ctrl + C` in the terminal where Docker Compose is running. This will stop and remove the containers.

### Conclusion

You have successfully run the project locally using Docker Compose. You can now explore the API and perform various operations.

Feel free to adjust the instructions based on the specifics of your project, such as the repository URL and any additional prerequisites or configuration steps required.

Make sure to provide any specific instructions or details that may be relevant to your project, such as environment variables or additional setup steps.


