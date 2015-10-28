package org.codeoshare.designpatterns.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionFactory {
	public static Connection createConnection() {
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "";
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite a senha de acesso root: ");
		senha = entrada.nextLine();

		Connection conexao = null;
		
		try {
			conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conexao;
	}

}
