package org.codeoshare.interceptors.interceptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.codeoshare.interceptors.entities.Mensagem;

public class CensuraInterceptor {
	
	private List<String> palavrasProibidas = new ArrayList<String>();
	
	public CensuraInterceptor() {
		//see more at: https://www.youtube.com/playlist?list=PLpLRk365gbPaslG6vcDsKjwyoPMDctzw7
		this.palavrasProibidas.add("hooker");
		this.palavrasProibidas.add("lot lizard");
		this.palavrasProibidas.add("gigolo");
	}
	
	@AroundInvoke
	public Object interceptador(InvocationContext ic) throws Exception {
		
		Object[] parameters = ic.getParameters();
		Mensagem mensagem = (Mensagem) parameters[0];
		
		for (String palavraProibida : this.palavrasProibidas) {
			String textoOriginal = mensagem.getTexto();
			String textoCensurado = textoOriginal.replaceAll(palavraProibida, "!CENSURADO!");
			mensagem.setTexto(textoCensurado);
		}
		
		return ic.proceed();
	}

}
