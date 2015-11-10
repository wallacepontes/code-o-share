package org.codeoshare.jdbc.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.codeoshare.jdbc.factory.ConnectionFactory;

public class InsereLivro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Abrindo conexão...");
		try {
			Connection conexao = ConnectionFactory.createConnection();
		
			System.out.println("Digite o título do livro: ");
			String titulo = entrada.nextLine();
			
			System.out.println("Digite o preço do livro: ");
			double preco = Double.parseDouble(entrada.nextLine());
			
			System.out.println("Digite o identificador da editora: ");
			int editora_id = Integer.parseInt(entrada.nextLine());
			
			//Evitar SQL Injection com sanitize
			String sql = "INSERT INTO Livro(titulo, preco, editora_id) VALUES (?, ?, ?)";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, titulo);
			comando.setDouble(2, preco);
			comando.setInt(3, editora_id);
			
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
