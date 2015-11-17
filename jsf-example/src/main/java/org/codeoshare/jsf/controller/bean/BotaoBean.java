package org.codeoshare.jsf.controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

@ManagedBean
public class BotaoBean {

	public void sorteiaBotao(ActionEvent event) {
		UIComponent formulario = event.getComponent().getParent();

		UIComponent botaoFulano = formulario.findComponent("botao-fulano");
		UIComponent botaoSicrano = formulario.findComponent("botao-sicrano");
		UIComponent botaoBeltrano = formulario.findComponent("botao-beltrano");

		botaoFulano.getAttributes().put("disabled", true);
		botaoSicrano.getAttributes().put("disabled", true);
		botaoBeltrano.getAttributes().put("disabled", true);

		double numero = Math.random();

		if (numero < 1.0/3.0) {
		    botaoFulano.getAttributes().put("disabled", false);
		} else if(numero < 2.0/3.0) {
			botaoSicrano.getAttributes().put("disabled", false);
		} else {
			botaoBeltrano.getAttributes().put("disabled", false);
		}
	}
}