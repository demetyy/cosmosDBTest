# Azure CosmosDB Integration Test with Docker on Local

I have CosmosDB running on Azure and Microservice running on Spring Boot 
but I am trying to test the CosmosDB database in local environment.

## Procedure

1. Install Docker for Windows at your PC.
2. Start gremlin-server locally like below :
  > docker run -d -p 8182:8182 tinkerpop/gremlin-server:3.2.10
3. Please make sure that you are using the versions mentioned above. 
   gremlin-core dependency and gremlin-server should be consistent.
4. Once you have started gremlin-server you can run integration tests successfully.

## Build 
``mvn clean install``

## Run

``mvn run``
