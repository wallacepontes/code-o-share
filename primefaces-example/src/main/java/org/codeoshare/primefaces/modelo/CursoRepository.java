package org.codeoshare.primefaces.modelo;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
	private static List<Curso> cursos = new ArrayList<Curso>();

	static {
cursos.add( new Curso(1L, "K01",
"Lógica de Programação",
"http://www.k19.com.br/css/img/k01-logo-small.png"));

cursos.add( new Curso(2L, "K02",
"Desenvolvimento Web com HTML , CSS e JavaScript",
"http://www.k19.com.br/css/img/k02-logo-small.png"));

cursos.add( new Curso(3L, "K03",
"SQL e Modelo Relacional",
"http://www.k19.com.br/css/img/k03-logo-small.png"));

cursos.add( new Curso(4L, "K11",
"Orientação a Objetos em Java",
"http://www.k19.com.br/css/img/k11-logo-small.png"));

cursos.add( new Curso(5L, "K12",
"Desenvolvimento Web com JSF2 e JPA2",
"http://www.k19.com.br/css/img/k12-logo-small.png"));

cursos.add( new Curso(6L, "K21",
"Persistência com JAP2 e Hibernate",
"http://www.k19.com.br/css/img/k21-logo-small.png"));

cursos.add( new Curso(7L, "K22",
"Desenvolvimento Web Avançado com EJB , JSF e CDI",
"http://www.k19.com.br/css/img/k22-logo-small.png"));

cursos.add( new Curso(8L, "K23",
"Integração de Sistemas com Webservices , JMS e EJB",
"http://www.k19.com.br/css/img/k23-logo-small.png"));

cursos.add( new Curso(9L, "K31",
"C# e Orientação a Objetos",
"http://www.k19.com.br/css/img/k31-logo-small.png"));

cursos.add( new Curso(10L, "K32",
"Desenvolvimento Web com ASP .NET MVC",
"http://www.k19.com.br/css/img/k32-logo-small.png"));

cursos.add( new Curso(11L, "K41",
"Desenvolvimento Mobile com Android",
"http://www.k19.com.br/css/img/k41-logo-small.png"));

cursos.add( new Curso(12L, "K51",
"Design Patterns em Java",
"http://www.k19.com.br/css/img/k51-logo-small.png"));

cursos.add( new Curso(13L, "K52",
"Desenvolvimento Web com Struts",
"http://www.k19.com.br/css/img/k52-logo-small.png"));
}

public List <Curso > getCursos () {
return cursos ;
}

}
