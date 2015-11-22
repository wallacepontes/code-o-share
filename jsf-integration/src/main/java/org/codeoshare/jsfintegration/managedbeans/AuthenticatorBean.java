package org.codeoshare.jsfintegration.managedbeans;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class AuthenticatorBean {
	
	private static Map<String, String> map = new HashMap<String, String>();
	private String user;
	private String password;
	
	static{
		AuthenticatorBean.map.put("codeoshare", "codeoshare");
	}
	
	public String authenticate() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		if (AuthenticatorBean.map.containsKey(this.user) 
				&& AuthenticatorBean.map.get(this.user).equals(this.password)) {
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession) ec.getSession(false);
			session.setAttribute("user", this.user);
			return "/home";
		} else {
			FacesMessage message = new FacesMessage("usuário e/ou senha inválidos");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(null, message);
		    return "/login";	
		}
		
	}
	
	public String registerEndOfDay() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.removeAttribute("user");
		return "/login";
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static void setMap(Map<String, String> map) {
		AuthenticatorBean.map = map;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
