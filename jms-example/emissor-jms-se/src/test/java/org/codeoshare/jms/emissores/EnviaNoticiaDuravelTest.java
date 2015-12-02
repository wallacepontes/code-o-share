package org.codeoshare.jms.emissores;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

import static org.junit.Assert.*;
import org.junit.Test;

public class EnviaNoticiaDuravelTest {

	@Test
	public void testEnviaNoticiaDuravel() throws Exception {
		 // serviço de nomes - JNDI
		 InitialContext ic = new InitialContext();
		
		// fábrica de conexões JMS
		ConnectionFactory factory = (ConnectionFactory)ic.lookup("jms/COSDurableFactory");
		
		// tópico
		 Topic topic = (Topic)ic.lookup("jms/noticias");
		
		 // conexão JMS
		 Connection connection = factory.createConnection();
		
		 // sessão JMS
		 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		 // emissor de mensagens
		 MessageProducer sender = session.createProducer(topic);
		
		 // mensagem
		 TextMessage message = session.createTextMessage();
		 message.setText("O peito do pé do pai do padre Pedro é preto. - " + System.
		currentTimeMillis());
		
		 // enviando
		 sender.send(message);
		
		 // fechando
		 sender.close();
		 session.close();
		 connection.close();
		
		 System.out.println("Mensagem Enviada");
		 //System.exit(0);

		 assertTrue(true);
	 }
}
