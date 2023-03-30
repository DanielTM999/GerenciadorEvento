package Model;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexao {
	private String DRIVER = "com.mysql.jdbc.Driver";
	private String host;
	private String user;
	private String senha;
	private int port = 3306;
	private String database;

	private Conexao(ConexaoBuilder Builder) {
		this.host = Builder.host;
		this.user = Builder.user;
		this.senha = Builder.senha;
		this.database = Builder.database;
	}

	public Connection conexao() {
		java.sql.Connection conn = null;

		String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(url, user, senha);
			return conn;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}

	}

	public static class ConexaoBuilder {
		private String host;
		private String user;
		private String senha;
		private String database;

		public ConexaoBuilder host(String host) {
			this.host = host;
			return this;
		}

		public ConexaoBuilder user(String user) {
			this.user = user;
			return this;
		}

		public ConexaoBuilder senha(String senha) {
			this.senha = senha;
			return this;
		}

		public ConexaoBuilder database(String database) {
			this.database = database;
			return this;
		}

		public Conexao builder() {
			return new Conexao(this);
		}

	}
}
