package org.codeoshare.calculator.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codeoshare.calculator.sessionbeans.Calculadora;

@WebServlet("/soma")
public class SomaServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private Calculadora calculadora;

	protected void service(HttpServletRequest req, HttpServletResponse res) {
		double a = Double.parseDouble(req.getParameter("a"));
		double b = Double.parseDouble(req.getParameter("b"));

		double resultado = this.calculadora.soma(a, b);

		PrintWriter out;
		try {
			out = res.getWriter();
			out.println("<html><body><p>");
			out.println("Soma: " + resultado);
			out.println("</p></body></html>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}
