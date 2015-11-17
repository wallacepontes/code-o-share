package org.codeoshare.jsf.controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
public class ProdutoBean {
	public void mudaPreco(ValueChangeEvent e) {
		System.out.println("Preço 2 antigo:" + e.getOldValue());
		System.out.println("Preço 2 novo:" + e.getNewValue());
	}
}
