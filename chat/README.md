chat: Chat used in a WAR and Singleton EJB inside a WAR
===============================
Author: Wallace Pontes
Level: Intermediate   
Technologies: Client that Lookup Remote EJB
Summary: Demonstrates how to use EJB packaged as a WAR   

What is it?
-----------

This example demonstrates the use SINGLETON SESSION BEANS

This example covers the following annotations:

* `@Singleton` : `@Startup`, `@Local` and `@Remote`    
* `@WebServlet` and `@EJB`  
* `@ManagedBean`, `@EJB` and `@SessionScoped`    
* `@PostConstruct` and `@PreDestroy`  
* `@PrePassivate` and `@PosPassivate`    
* `@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)` : ContainerManaged Concurrency (CMC)  
* `@ConcurrencyManagement(ConcurrencyManagementType.BEAN)` : BeanManaged Concurrency (BMC)  
* `@Lock(LockType.WRITE)` and `@Lock(LockType.READ)`  
* `@Test`   

This is an WAR version, with the following structure:

    -`chat - parent module
        - `counter-se`: Contains the stand-alone application to lookup the Remote EJB
        - `chat-war`: Contains the web application, which uses the EJB beans. Creates a `.war` file



System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.

Build and Deploy 
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. _

1. Make sure you have started the Glassfish with the command line `mvn glassfish:start-domain`
2. Open a command line and navigate to the root directory of this project.
3. Type this command to build the archive:

        mvn clean package glassfish:deploy

4. This will generate a deploy file at `./dado/chat-war/target/chat-war-1.0-SNAPSHOT.war` to be deploying in the server.

5. Navigate to the sub directory `chat-war`.
6. Type this command to deploy the archive:

        mvn glassfish:deploy
