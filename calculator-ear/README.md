calculator-ear: Calculator used in a WAR and EJB inside an EAR
===============================
Author: Wallace Pontes 
Level: Intermediate   
Technologies: EJB, Session Beans, JSF
Summary: Demonstrates how to use EJB packaged as an EAR

What is it?
-----------

This example demonstrates the use of EAR packing, EJB, Session Beans, 
SLSB (Stateless) and generateClient EJB with Maven

This example covers the following annotations:

* `@Stateless` : `@Local` and `@Remote`
* `@WebServlet` and `@EJB`
* `@ManagedBean` and `@EJB`

This is an EAR version, with the following structure:

    -`calculator-ear - parent module
        - `calculator-ejb`: Contains EJB beans and JPA entities. Creates a `.jar` file
        - `calculator-war`: Contains the Wicket web application, which uses the EJB beans. Creates a `.war` file
        - `calculator-ear`: Packages the EJB JAR and WAR into an EAR. Creates an `.ear` file


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

4. This will generate a deploy file at `./calculator-ear/calculator-ear/target/calculator-ear-1.0-SNAPSHOT.ear` to be deploying in the server.

5. Navigate to the sub directory `calcular-ear`.
6. Type this command to deploy the archive:

        mvn glassfish:deploy

