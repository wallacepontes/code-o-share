jms-example: JMS Example - Java Message Service - JMS
===============================
Author: Wallace Pontes
Level: Intermediate   
Technologies: Java Message Service - JMS
Summary: Demonstrates how to use Java Message Service - JMS   

What is it?
-----------

This example demonstrates the use of Message oriented middleware (MOM) - Java Message Service - JMS:
* Enterprise Java Beans (EJB)
* Java Transaction API (JTA)
* Java Transaction Service (JTS)
* destinations: queues and topics
* point-to-point or publish-and-subscribe

This example covers the following annotations:

* `@Resource(mappedName="jms/ConnectionFactory")`  
private ConnectionFactory connectionFactory;

* `@Resource(mappedName="jms/Queue")`  
private Queue queue;

```java  
Connection connection = factory.createConnection();
Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

MessageProducer sender = session.createProducer(queue);
MessageConsumer receiver = session.createConsumer(queue);

TextMessage message = session.createTextMessage();
message.setText("Olá");
sender.send(message);

connection.start();
TextMessage message = (TextMessage)receiver.receive();
```  

MessageConsumer
```java  
//Bloqueante
receiver.receive();
// Semi-Bloqueante: espera no máximo 5 segundos
receiver.receive(5000);
//Não-Bloqueante: 
receiver.receiveNoWait();
```

QueueBrowser
```java
QueueBrowser queueBrowser = session.createBrowser(queue);
Enumeration<TextMessage> messages = queueBrowser.getEnumeration();
while (messages.hasMoreElements()) {
   TextMessage message = messages.nextElement();
}
```

JMS and EJB
Message Driven Beans (MDBs)
* `@MessageDriven` - interface MessageListener  


This is an WAR version, with the following structure:

    -`jms-example - parent module
        - `emissor-jms-se`: Contains the stand-alone application to send a message.   
        - `receptor-jms-se`: Contains the stand-alone application to receive a message.
        - `receptor-jms-ejb`: Contains the EJB beans.



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

4. This will generate a deploy file at `./dado/carrinho-war/target/carrinho-war-1.0-SNAPSHOT.war` to be deploying in the server.

5. Navigate to the sub directory `carrinho-war`.
6. Type this command to deploy the archive:

        mvn glassfish:deploy   



Configure the Glassfish
-------------------------
In localhost:4848
--> Resources -> JMS Resources 
    -> Destination Resources
Click New
JNDI Name: jms/pedidos
Physical Destination Name: pedidos
Resource Type: javax.jms.Queue
asadmin create-jms-resource --restype javax.jms.Queue --property Name=pedidos jms/pedidos

Click New
JNDI Name: jms/noticias
Physical Destination Name: noticias
Resource Type: javax.jms.Topic
asadmin create-jms-resource --restype javax.jms.Topic --property Name=noticias jms/noticias

    -> Connection Factories
Click New
Pool Name: jms/COSFactory
Resource Type: javax.jms.ConnectionFactory
asadmin create-jms-resource --restype javax.jms.ConnectionFactory jms/COSFactory

Click New
Pool Name: jms/COSDurableFactory
Resource Type: javax.jms.ConnectionFactory
asadmin create-jms-resource --restype javax.jms.ConnectionFactory jms/COSDurableFactory

Click Add Property
Name: ClientId
Value: Id
