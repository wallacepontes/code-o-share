scheduling-example: Scheduling Example
===============================
Author: Wallace Pontes   
Level: Beginner   
Technologies: EJB, Stateless, Scheduling
Summary: Basic example to Scheduling

What is it?
-----------

This example demonstrates the use of Scheduling

This example covers the following annotations:  

* `@Entity`, `@Id` and `@GeneratedValue(strategy=GenerationType.IDENTITY)`
* `@Stateless` and `@PersistenceContext`  
* `@ManagedBean` and `@EJB` 

Timers  
* `@Stateless`  
* `@Resource`  
private TimerService timerService;   
* `@Timeout`  
* `@Schedule(dayOfMonth="1")`  


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
  <resources>
    ...
    <jdbc-connection-pool datasource-classname="com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource" name="cos_schedulingdbPool" res-type="javax.sql.ConnectionPoolDataSource">
      <property name="url" value="jdbc:mysql://localhost:3306/cos_schedulingdb"></property>
      <property name="URL" value="jdbc:mysql://localhost:3306/cos_schedulingdb"></property>
      <property name="databaseName" value="cos_schedulingdb"></property>
      <property name="serverName" value="localhost"></property>
      <property name="user" value="root"></property>
      <property name="password" value="root"></property>
    </jdbc-connection-pool>
    <jdbc-resource pool-name="cos_schedulingdbPool" jndi-name="jdbc/__cos_schedulingdbPool"></jdbc-resource>
...
</resources>
  <servers>
    <server config-ref="server-config" name="server">
        ...
        <resource-ref ref="jdbc/__cos_schedulingdbPool"></resource-ref>
        ...
    </server>
</servers>
```  

Dont forget to copy the jdbc driver in lib, and change the URL to your needs. Next start glassfish, go to JDBC Connection Pools and test your connection.  

See more at: http://stackoverflow.com/questions/33048435/glassfish-admin-console-throws-java-lang-illegalstateexception-when-creating-jdb  

2) Bug 238935 - SEVERE: Exception while preparing the app : Invalid resource : jdbc/<databasename>__pm  
renamed the datasource and the jdbc connection in glassfish   
__datasourcename  
the same datasource but with two underscore.  

See more at: https://netbeans.org/bugzilla/show_bug.cgi?id=238935  

3) Don't forget to change the old version from jboss-logging.jar (version 3.0.1 GA) to the new jboss-logging-3.3.0.Final.jar at c:\glassfish4\glassfish\modules  

4) keepstate is true and will not create new auto timers during deployment. So I changed the 'keep-state' to false at glassfish-web.xml  
See more at: http://stackoverflow.com/questions/13092567/automatic-ejb-timer-on-glassfish-server-not-triggering  

