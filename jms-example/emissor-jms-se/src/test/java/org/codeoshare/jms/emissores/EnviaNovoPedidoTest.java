package org.codeoshare.jms.emissores;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import static org.junit.Assert.*;
import org.junit.Test;

public class EnviaNovoPedidoTest {	

	    @Test
		public void testEnviaNovoPedido() throws Exception {
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
		
		 // emissor de mensagens
		 MessageProducer sender = session.createProducer(queue);
		
		 // mensagem
		 TextMessage message = session.createTextMessage();
		 message.setText("Oba Farofa feita com muita farinha fofa faz uma fofoca feia - " + System.
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
