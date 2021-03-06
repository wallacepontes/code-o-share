package org.codeoshare.designpatterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

public class AtualizadorSalarialTest {

	@Test
	public void testVisitor() throws Exception {
		List<Departamento> departamentos = new ArrayList<>();
		Departamento departamento = new Departamento("Dep.Tecnologia");
		Gerente gerente = new Gerente("Fulano", 19230, "1234");
		Telefonista telefonista = new Telefonista("Emiliano", 1000, 2);
		departamento.getFuncionarios().add(gerente);
		departamento.getFuncionarios().add(telefonista);
		
		departamentos.add(departamento);
		
		Departamento departamento2 = new Departamento("Dep.Pessoal");
		Gerente gerente2 = new Gerente("Sicrano", 5420, "1234");
		Gerente gerente3 = new Gerente("Beltrano", 4830, "1234");
		Telefonista telefonista2 = new Telefonista("Orlando", 1000, 2);
		departamento2.getFuncionarios().add(gerente2);
		departamento2.getFuncionarios().add(gerente3);
		departamento2.getFuncionarios().add(telefonista2);
		
		departamentos.add(departamento2);
		
		AtualizadorDeFuncionario atualizador = new AtualizadorSalarial();
		
		for (Departamento d : departamentos) {
			d.aceita(atualizador);
		}
		
		for (Departamento d : departamentos) {
			for (Funcionario f : d.getFuncionarios()) {
				System.out.println("Nome: " + f.getNome() + " - Salário: " + f.getSalario());
			}
		}
		
		assertTrue(true);
	}
}
