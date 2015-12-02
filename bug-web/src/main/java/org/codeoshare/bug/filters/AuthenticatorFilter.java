package org.codeoshare.bug.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(servletNames = {"Faces Servlet"})
public class AuthenticatorFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("Entrou aqui");
		if (req.getRemoteUser() == null && !req.getRequestURI().endsWith(req.getContextPath() + "/login.xhtml")) {
			System.out.println("Entrou aqui - 1");
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(req.getContextPath() + "/login.xhtml");
		} else {
			System.out.println("Entrou aqui . 2");
			chain.doFilter(request,response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
