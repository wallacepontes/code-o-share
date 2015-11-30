package org.codeoshare.security.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.codeoshare.security.sessionbeans.TarefasBean;

@ManagedBean
public class TarefasMB {

	@EJB
	private TarefasBean tarefasBean;

	private String tarefa;

	public void adiciona() {
		this.tarefasBean.adiciona(this.tarefa);
	}

	public void remove(String tarefa) {
		this.tarefasBean.remove(tarefa);
	}

	public List<String> getTarefas() {
		return this.tarefasBean.listaTarefas();
	}

	public TarefasBean getTarefasBean() {
		return tarefasBean;
	}

	public void setTarefasBean(TarefasBean tarefasBean) {
		this.tarefasBean = tarefasBean;
	}

	public String getTarefa() {
		return tarefa;
	}

	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}
}
