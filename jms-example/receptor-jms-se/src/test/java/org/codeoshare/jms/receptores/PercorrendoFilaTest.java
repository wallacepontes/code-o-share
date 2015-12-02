package org.codeoshare.jms.receptores;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import static org.junit.Assert.*;
import org.junit.Test;

public class PercorrendoFilaTest {

	@Test
	public void testPercorrendoFila() throws Exception {
		// serviço de nomes - JNDI
		InitialContext ic = new InitialContext();
		
		// fábrica de conexões JMS
		ConnectionFactory factory = (ConnectionFactory) ic
		.lookup("jms/COSFactory");
		
		 // fila
		 Queue queue = (Queue) ic.lookup("jms/pedidos");
		
		 // conexão JMS
		 Connection connection = factory.createConnection();
		
		 // sessão JMS
		 Session session = connection.createSession(false,
		 Session.AUTO_ACKNOWLEDGE);
		// queue browser
		  QueueBrowser queueBrowser = session.createBrowser(queue);
		 
		  Enumeration<TextMessage> messages = queueBrowser.getEnumeration();
		  int count = 1;
		  while (messages.hasMoreElements()) {
		  TextMessage message = messages.nextElement();
		  System.out.println(count + " : " + message.getText());
		  count++;
		  }
		 
		  // fechando
		  queueBrowser.close();
		  session.close();
		  connection.close();
		 
		  System.out.println("FIM");
		  //System.exit(0);

		  assertTrue(true);
	}
}
