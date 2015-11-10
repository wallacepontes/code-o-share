package org.codeoshare.jdbc.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.codeoshare.jdbc.factory.ConnectionFactory;

public class AlteraLivro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Abrindo conexão...");
		try {
			Connection conexao = ConnectionFactory.createConnection();
		
			System.out.println("Digite o id do livro: ");
			int id = Integer.parseInt(entrada.nextLine());
			System.out.println("Digite o novo preço do livro: ");
			double preco = Double.parseDouble(entrada.nextLine());
			
			//Evitar SQL Injection com sanitize
			String sql = "UPDATE Livro SET preco = ? WHERE ID = ?";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setDouble(1, preco);
			comando.setInt(2, id);
			
			System.out.println("Executando comando...");
			comando.execute();
			System.out.println("Fechando conexão...");
			conexao.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
