glassfish-helloworld: Glassfish HelloWorld Example
===============================
Author: Wallace Pontes   
Level: Beginner   
Technologies: Glassfish, Servlet 3.0   
Summary: Basic example “Hello world” application with Glassfish 4.0 and Maven 3

What is it?
-----------

This example demonstrates the use of Glassfish 4.0 and Maven 3

You can see it up and running at: http://localhost:8080/glassfish-helloworld/HelloWorld

Configure the Maven
-------------------

See more here:
http://lauraliparulo.altervista.org/glassfish-4-0-hello-world-application-with-maven-3/

1. To deploy your application using Maven, create the settings.xml file under the .m2 folder (for example, under Windows at the location: C:\Users\username\.m2), providing the glassfish profile credentials: they will automatically imported in the pom.xml file.

`<?xml version="1.0" encoding="UTF-8"?>`   
`<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"`    
`        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"`    
`          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">`   
          
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

Maven commands
-------------------

mvn clean package glassfish:deploy
mvn clean package glassfish:redeploy


System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.
