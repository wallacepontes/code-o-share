package org.codeoshare.chat.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.codeoshare.chat.sessionbeans.ChatBean;

@ManagedBean
public class ChatMB {
	@EJB
	private ChatBean chatBean;

	private String sala;

	public void adicionaSala(){
		this.chatBean.criaSala(this.sala);
	}

	public List<String> getSalas() {
		return this.chatBean.listaSalas();
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
}
