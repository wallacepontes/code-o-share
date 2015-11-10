package org.codeoshare.jdbc.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.codeoshare.jdbc.factory.ConnectionFactory;

public class DeleteLivro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Abrindo conexão...");
		try {
			Connection conexao = ConnectionFactory.createConnection();
		
			System.out.println("Digite o id do livro para exclusão: ");
			int id = Integer.parseInt(entrada.nextLine());
			
			//Evitar SQL Injection com sanitize
			String sql = "DELETE FROM Livro WHERE ID = ?";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setInt(1, id);
			
			System.out.println("Executando comando...");
			comando.execute();
			System.out.println("Fechando conexão...");
			conexao.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
