package org.codeoshare.dado.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.codeoshare.dado.sessionbeans.LancadorDeDado;

@ManagedBean
public class DadoMB {

    @EJB
	private LancadorDeDado lancadorDeDado;

    private int resultado;

    public void lancaDado() {
    	this.resultado = this.lancadorDeDado.lanca();
    }

    public int getResultado() {
    	return resultado;
    }
    public void setResultado(int resultado) {
    	this.resultado = resultado;
    }
}
