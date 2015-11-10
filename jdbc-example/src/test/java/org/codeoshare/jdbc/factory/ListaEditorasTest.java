package org.codeoshare.jdbc.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.codeoshare.jdbc.factory.ConnectionFactory;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListaEditorasTest {

	@Test
	public void testListaEditoras() throws Exception {
		
		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();
		
			//Evitar SQL Injection com sanitize
			String sql = "SELECT * FROM Editora;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
						
			System.out.println("Executando comando...");
			ResultSet resultado = comando.executeQuery();
			
			System.out.println("Resultados encontrados: \n");
			while (resultado.next()) {
				System.out.printf("%d : %s - %s\n", resultado.getInt("id"), resultado.getString("nome"), resultado.getString("email"));
				
			}
			System.out.println("\nFechando conexão...");
			assertNotNull(conexao);
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
