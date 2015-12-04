jaxws-example: Jaxws-example used JaxB and Jax-Ws   
===============================   
Author: Wallace Pontes   
Level: Intermediate   
Technologies: EJB, JAX-WS, JaxB and Web Services  
Summary: Demonstrates how to use Remote EJB, JAX-WS and JaxB   

What is it?  
-----------

This example demonstrates the use Java API for XML-Based Web Services - JAX-WS (WSDL) and JAXB Java Architecture for XML Binding (Marshaller and Unmarshaller)  

* Endpoint.publish("http://localhost:8080/random", random);  
* wsimport -keep http://localhost:8080/random?wsdl  

This example covers the following annotations:   

* `@XmlRootElement`   
* `@WebService` and `@Stateless`  
* `@Test`   
   
This is an WAR version, with the following structure:

    -`jaxws-example - parent module
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

        mvn clean package   

4. This will generate a deploy file at `./chat/chat-war/target/chat-war-1.0-SNAPSHOT.war` to be deploying in the server.  

5. Navigate to the sub directory `chat-war`.  
6. Type this command to deploy the archive:  

        mvn glassfish:deploy  


Workarounds
---------------
Create a file named `jaxp.properties` (if it doesn't exist) under /path/to/jdk1.8.0/jre/lib and then write this line in it:   
   
`javax.xml.accessExternalSchema = all`    

That's all. Enjoy JDK 8.    

See more at: http://stackoverflow.com/questions/23011547/webservice-client-generation-error-with-jdk8   
