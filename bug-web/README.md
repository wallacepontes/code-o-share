bug-web: Bug Web Application
===============================
Author: Wallace Pontes   
Level: Beginner   
Technologies: EJB, CDI, JAAS, Stateless-Stateful-Singleton Session Beans, ConnectionPool, Realms, Transactions, Interceptions, Scheduling    
Summary: Basic example about Bugs of a project      

What is it?
-----------

This example demonstrates the use of EJB, CDI, JAAS (Java Authentication and Authorization Service), Stateless-Stateful-Singleton Session Beans, ConnectionPool, Realms, Transactions, Interceptions, Scheduling, Data Sources - JDBC - Connection Pool - Java Transaction API JTA  


This example covers the following projects:  

../code-o-share/calculator-ear  
../code-o-share/dado  
../code-o-share/carrinho  
../code-o-share/chat  
../code-o-share/persistence-example   
../code-o-share/transaction-example   
../code-o-share/security-example  
../code-o-share/interceptors-example   
../code-o-share/scheduling-example  
../code-o-share/cdi-example  


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

Configure the Realms
-------------------
In localhost:4848:common/index.jsf
    --> Configurations -> server-config
        --> Security -> Reamls
Click New Realm	
New Realm
 - Name: COS-Realm
 - Class Name: com.sun.enterprise.security.auth.realm.file.FileRealm
 - JAAS Context: fileRealm
 - Key File: * ${com.sun.aas.instanceRoot}/config/COS-RealmFile

Add New User in COS-Realm created above
 - Edit COS-Realm
 - Click Manage Users 
 - Click New (File Realm User)
 --> User Id: COS
 --> Group List: admin
 --> New Password: ****
 --> Confirm New Password: ****

INSERT INTO Usuario (nome , senha ) VALUES ('COS', md5 ('COS'));
INSERT INTO Usuario (nome , senha ) VALUES ('codeoshare', md5 ('codeoshare'));

INSERT INTO Grupo ( nome ) VALUES ('admin');
INSERT INTO Grupo ( nome ) VALUES ('users');

INSERT INTO Usuario_Grupo ( usuario_nome , grupos_nome ) VALUES ('COS', 'admin');
INSERT INTO Usuario_Grupo ( usuario_nome , grupos_nome ) VALUES ('codeoshare', 'users');

In localhost:4848:common/index.jsf
    --> Configurations -> server-config
        --> Security -> Reamls
Click New Realm	
New Realm
 - Name: COS-Realm-JDBC
 - Class Name: com.sun.enterprise.security.auth.realm.jdbc.JDBCRealm
 - JAAS Context: jdbcRealm
 - JNDI: jdbc/__cos_securitydbPool
 - User Table: Usuario
 - User Name Column: nome
 - Password Column: senha
 - Group Table: Usuario_Grupo
 - Group Table User Name Column: Usuario_nome
 - Group Name Column: grupos_nome
 - Password Encryption Algorithman: MD5
 - Digest Algorihm: MD5

Workarrounds  
--------------  
1) just paste this peace of xml into domain.xml (between the others connection pool)  
```xml   
  <resources>
    ...
    <jdbc-connection-pool datasource-classname="com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource" name="cos_bugdbPool" res-type="javax.sql.ConnectionPoolDataSource">
      <property name="url" value="jdbc:mysql://localhost:3306/cos_bugdb"></property>
      <property name="URL" value="jdbc:mysql://localhost:3306/cos_bugdb"></property>
      <property name="databaseName" value="cos_bugdb"></property>
      <property name="serverName" value="localhost"></property>
      <property name="user" value="root"></property>
      <property name="password" value="root"></property>
    </jdbc-connection-pool>
    <jdbc-resource pool-name="cos_bugdbPool" jndi-name="jdbc/__cos_bugdbPool"></jdbc-resource>
...
</resources>
  <servers>
    <server config-ref="server-config" name="server">
        ...
        <resource-ref ref="jdbc/__cos_bugdbPool"></resource-ref>
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

