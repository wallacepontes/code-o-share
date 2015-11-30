security-example: Security Example
===============================
Author: Wallace Pontes   
Level: Beginner   
Technologies: JAAS (Java Authentication and Authorization Service)
Summary: Basic example about JAAS

What is it?
-----------

This example demonstrates the use of JAAS (Java Authentication and Authorization Service)


This example covers the following annotations:  

* `@Entity`, `@Id`, `@GeneratedValue(strategy=GenerationType.IDENTITY)` and `@ManyToMany`  
* `@Stateless` and `@PersistenceContext`  
* `@ManagedBean` and `@EJB`  
* `@ManyToMany(fetch=FetchType.EAGER)`  
* `@Singleton`, `@RolesAllowed({"ADMIN","USERS"})` and `@RolesAllowed({"ADMIN"})`

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


