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
        - `jaxb-se`: Contains the stand-alone application to Marshaller and Unmarshaller   
        - `random-ejb`: Contains the JAX-WS EJB   
        - `random-ejb-client`: Contains the JAX-WS EJB Client  
        - `random-se`: Contains the JAX-WS with Endpoint.publish   
        - `random-se-client`: Contains the JAX-WS Client  


System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.  

Build and Deploy 
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. _  

1. Make sure you have started the Glassfish with the command line `mvn glassfish:start-domain`  
2. Open a command line and navigate to the root directory of this project.  
3. Type this command to build the archive:  

        mvn clean package -DskipTests  

4. This will generate a deploy file at `./jaxws-example/random-ejb/target/random-ejb-1.0-SNAPSHOT.jar` to be deploying in the server at .\glassfish4\glassfish\domains\domain1\autodeploy.   
4.1. Now you can consumer the WebService running the main class .\jaxws-example\random-ejb-client\src\main\java\org\codeoshare\jaxws\Consumer.java   

5. Publish the Jax-WS running the main class .\jaxws-example\random-se\src\main\java\org\codeoshare\jaxws\RandomPublisher.java.  
5.1. Now you can consumer the WebService running the main class .\jaxws-example\random-se-client\src\main\java\org\codeoshare\jaxws\Consumer.java   
5.2. The Glassfish server don't need to be running.   

6. Marshaller and Unmarshaller running the first class test .\jaxws-example\jaxb-se\src\test\java\org\codeoshare\jaxb\SerializadorTest.java that will create the xml file ./target/conta.xml and after that running the second test class .\jaxws-example\jaxb-se\src\test\java\org\codeoshare\jaxb\DeserializadorTest.java  


Workarounds
---------------
Create a file named `jaxp.properties` (if it doesn't exist) under /path/to/jdk1.8.0/jre/lib and then write this line in it:   
   
`javax.xml.accessExternalSchema = all`    

That's all. Enjoy JDK 8.    

See more at: http://stackoverflow.com/questions/23011547/webservice-client-generation-error-with-jdk8   
