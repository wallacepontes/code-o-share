jsf-integration: JSF Integrantion Example
===============================
Author: Wallace Pontes   
Level: Beginner   
Technologies: JSF, Hibernate, JPA
Summary: Basic example to using JSF with Hibernate and JPA

What is it?
-----------

This example demonstrates the use of JavaServer Faces, JPA and Hibernate 

Autentication
---------------
1. HashMap
2. Access control with filter

Persistence Contexts
--------------------
###### Entity
@Entity
@Table(name="cos_person")
###### Setting restrictions
@Column(length=30, nullable=false,unique=true)
@Column(precision=3, scale=2)
###### Generating primary keys automatically
```java
@Entity
@Table(name="cos_person")
class Person {
  @Id
  @GeneratedValue
  private Long id;
}
```
See more at: http://docs.jboss.org/hibernate/orm/5.0/userGuide/en-US/html_single/

Workaround
--------------------
Don't forget to change the old version from jboss-logging.jar (version 3.0.1 GA) to the new jboss-logging-3.3.0.Final.jar at c:\glassfish4\glassfish\modules
