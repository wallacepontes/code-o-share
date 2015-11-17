jsf-example: JSF Example
===============================
Author: Wallace Pontes   
Level: Beginner   
Technologies: JSF, Ajax   
Summary: Basic example to using JSF

What is it?
-----------

This example demonstrates the use of JavaServer Faces

Java Specification Requests
----------------------------
Bean Validation - http://jcp.org/en/jsr/detail?id=303
JSF (Java Server Faces): http://www.jcp.org/en/jsr/detail?id=314
Servlet - http://www.jcp.org/en/jsr/detail?id=315
Java EE - http://jcp.org/en/jsr/detail?id=316

expression language 
--------------------
expression language (#{}).

The Lifecycle of a JavaServer Faces Application
------------------------------------------------

Upon receiving a request, the Faces Servlet performs the following steps:
Restore View
Apply Request Values
Process Validations
UpdateModel Values
Invoke Application
Render Response

See more at: https://docs.oracle.com/javaee/6/tutorial/doc/bnaqq.html

Goals Overview
---------------
glassfish:create-domain Create a new Glassfish domain. (Creating an existing domain will cause it to be deleted and recreated.)
glassfish:start-domain Start an existing Glassfish domain. (Starting a non-existent domain will cause it to be created.)
glassfish:deploy Deploy JavaEE artifacts to a running domain. (Deploying to an inactive domain will cause it to be started and created if necessary.)
glassfish:redeploy Redeploy JavaEE artifacts to a running domain. (Cold redeployment by first calling undeploy and then deploy . Use deploy to effect a hot deployment.)
glassfish:undeploy Undeploy JavaEE components from a running domain.
glassfish:stop-domain Stop a running Glassfish domain.
glassfish:delete-domain Delete an existing Glassfish domain.
- See more at: https://maven-glassfish-plugin.java.net/#sthash.nADTKrAt.dpuf

Visual components
-----------------------
• Core (http://java.sun.com/jsf/core)
• HTML (http://java.sun.com/jsf/html)
• Facelets (http://java.sun.com/jsf/facelets

Examples
-------------------------
1. http://localhost:8080/jsf-example/formulario.xhtml
2. http://localhost:8080/jsf-example/usuario.xhtml
3. http://localhost:8080/jsf-example/conversor-monetario.xhtml
4. http://localhost:8080/jsf-example/cursos.xhtml
5. http://localhost:8080/jsf-example/listagem-de-instrutores.xhtml
etc.

Configure the Maven
-------------------

See more here:
http://lauraliparulo.altervista.org/glassfish-4-0-hello-world-application-with-maven-3/

1. To deploy your application using Maven, create the settings.xml file under the .m2 folder (for example, under Windows at the location: C:\Users\username\.m2), providing the glassfish profile credentials: they will automatically imported in the pom.xml file.

```xml
<?xml version="1.0" encoding="UTF-8"?> 
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
	<profiles>
        <profile>
            <id>glassfish-context</id>
            <properties>
                <local.glassfish.home>C:\\glassfish4\\glassfish</local.glassfish.home>
                <local.glassfish.user>admin</local.glassfish.user>
                <local.glassfish.domain>domain1</local.glassfish.domain>
                <local.glassfish.passfile>
            ${local.glassfish.home}\\domains\\${local.glassfish.domain}\\config\\domain-passwords
                </local.glassfish.passfile>
            </properties>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>glassfish-context</activeProfile>
    </activeProfiles>
</settings>
```

Maven commands
-------------------

mvn clean package glassfish:deploy
mvn clean package glassfish:redeploy

System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.
