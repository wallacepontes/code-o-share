package org.codeoshare.jms.receptores;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssinanteDuravelTest {

	@Test
	public void testAssinanteDuravel() throws Exception {
		 // serviço de nomes - JNDI
		 InitialContext ic = new InitialContext();
		
		// fábrica de conexões JMS
		 ConnectionFactory factory = (ConnectionFactory) ic
		 .lookup("jms/COSDurableFactory");
		
		 // tópico
		 Topic topic = (Topic) ic.lookup("jms/noticias");
		
		 // conexão JMS
		 Connection connection = factory.createConnection();
		
		 // sessão JMS
		 Session session = connection.createSession(false,
		 Session.AUTO_ACKNOWLEDGE);
		
		 // receptor de mensagens
		 MessageConsumer receiver = session.createDurableSubscriber(topic,
		 "Assinante1");
		
		 // inicializa conexão
		 connection.start();
		
		 // recebendo
		 TextMessage message = (TextMessage) receiver.receive(2000);
		
		 while(message != null){
		 System.out.println(message.getText());
		 message = (TextMessage) receiver.receive(2000);
		 }
		
		 // fechando
		 receiver.close();
		 session.close();
		 connection.close();
		
		System.out.println("FIM");
		//System.exit(0);

		assertTrue(true);
	}
}
