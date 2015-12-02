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

public class AssinanteDeNoticiasTest {

	@Test
	public void testAssinanteDeNoticias() throws Exception {
		// serviço de nomes - JNDI
		InitialContext ic = new InitialContext();
		
		// fábrica de conexões JMS
		ConnectionFactory factory = (ConnectionFactory) ic
		.lookup("jms/COSFactory");
		
		// tópico
		Topic topic = (Topic) ic.lookup("jms/noticias");
		
		// conexão JMS
		Connection connection = factory.createConnection();
		
		// sessão JMS
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		
		// receptor de mensagens
		//, "(categoria = 'esporte')"
		MessageConsumer receiver = session.createConsumer(topic);
		
		 // inicializa conexão
		 connection.start();
		
		 // recebendo
		 TextMessage message = (TextMessage) receiver.receive();
		
		 System.out.println(message.getText());
		
		 // fechando
		 receiver.close();
		 session.close();
		 connection.close();
		
		 System.out.println("FIM");
		 //System.exit(0);

		 assertTrue(true);
	}
}