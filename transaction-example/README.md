transaction-example: Transaction Example
===============================
Author: Wallace Pontes   
Level: Beginner   
Technologies: EJB, CMT, BMT, JTA, JTS
Summary: Basic example about transaction

What is it?
-----------

This example demonstrates the use of Container Managed Transactions (CMT) and Bean Managed Transactions (BMT), 
ACID - atomicity consistency isolation durability, Java Transaction API (JTA), Java Transaction Service (JTS)
and Enterprise Java Beans (EJB)


This example covers the following annotations:  

* `@Entity`, `@Id`, `@GeneratedValue(strategy=GenerationType.IDENTITY)` and `@ManyToMany`  
* `@Stateless` and `@PersistenceContext`  
* `@ManagedBean` and `@EJB` 

Container Managed Transactions - CMT - EJB Container responsabilities and default
REQUIRED, REQUIRES_NEW, SUPPORTS, MANDATORY, NOT_SUPPORTED and NEVER.
* `@Stateful`
* `@TransactionManagement(TransactionManagementType.CONTAINER)`
* `@TransactionAttribute(TransactionAttributeType.REQUIRED)`
* `@Resource` - context.setRollbackOnly();
* `@ApplicationException(rollback=true)`

Bean Managed Transactions - BMT
* `@Stateful`
* `@TransactionManagement(TransactionManagementType.BEAN)`
* `@Resource` - private UserTransaction ut;

This is an WAR version.  


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


Configure the Maven  
-------------------  

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
See more at: http://lauraliparulo.altervista.org/glassfish-4-0-hello-world-application-with-maven-3/  


Workarrounds  
--------------  
1) just paste this peace of xml into domain.xml (between the others connection pool)  
```xml
	<jdbc-connection-pool datasource-classname="com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource" name="cos_persistencedbPool" res-type="javax.sql.ConnectionPoolDataSource">
	  <property name="password" value="root"></property>
	  <property name="databaseName" value="cos_persistencedb"></property>
	  <property name="url" value="jdbc:mysql://localhost:3306/cos_persistencedb"></property>
	  <property name="serverName" value="localhost"></property>
	  <property name="user" value="root"></property>
	</jdbc-connection-pool>
```
Dont forget to copy the jdbc driver in lib, and change the URL to your needs. Next start glassfish, go to JDBC Connection Pools and test your connection.  

See more at: http://stackoverflow.com/questions/33048435/glassfish-admin-console-throws-java-lang-illegalstateexception-when-creating-jdb  

2) Bug 238935 - SEVERE: Exception while preparing the app : Invalid resource : jdbc/<databasename>__pm  
renamed the datasource and the jdbc connection in glassfish   
__datasourcename  
the same datasource but with two underscore.  


See more at: https://netbeans.org/bugzilla/show_bug.cgi?id=238935  
