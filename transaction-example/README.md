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

