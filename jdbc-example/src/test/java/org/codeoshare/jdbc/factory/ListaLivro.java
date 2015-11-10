package org.codeoshare.jdbc.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.codeoshare.jdbc.factory.ConnectionFactory;

public class ListaLivro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();
		
			//Evitar SQL Injection com sanitize
			String sql = "SELECT * FROM Livro;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
						
			System.out.println("Executando comando...");
			ResultSet resultado = comando.executeQuery();
			
			System.out.println("Resultados encontrados: \n");
			while (resultado.next()) {
				System.out.printf("%d : %s -R$ %s\n", resultado.getInt("id"), resultado.getString("titulo"), resultado.getString("preco"));
				
			}
			System.out.println("\nFechando conexão...");
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}