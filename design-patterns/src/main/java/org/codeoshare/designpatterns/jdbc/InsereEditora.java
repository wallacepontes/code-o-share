package org.codeoshare.designpatterns.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsereEditora {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();
		
			System.out.println("Digite o nome da editora: ");
			String nome = entrada.nextLine();
			
			System.out.println("Digite o email da editora: ");
			String email = entrada.nextLine();
			
			//Evitar SQL Injection com sanitize
			String sql = "INSERT INTO Editora(nome, email) VALUES (?, ?)";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, nome);
			comando.setString(2, email);
			
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
