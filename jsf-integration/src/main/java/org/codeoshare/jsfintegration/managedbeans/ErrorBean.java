package org.codeoshare.jsfintegration.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ErrorBean {
	public void generateError() {
		System.out.println(10/0);
	}
}