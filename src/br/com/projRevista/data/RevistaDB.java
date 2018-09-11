package br.com.projRevista.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projRevista.model.Revista;
import br.com.projRevista.util.Conexao;

public class RevistaDB {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public RevistaDB() {
		connection = Conexao.getConnection();
	}
	
	public boolean inserir(Revista r) throws SQLException {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("insert into revista (nome, ano, mes, qtdPaginas) values (?, ?, ?, ?)");

			stmt.setString(1, r.getNome());
			stmt.setString(2, Integer.toString(r.getAno()));
			stmt.setString(3, r.getMes());
			stmt.setString(4, Integer.toString(r.getQtdPaginas()));

			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {
			connection.close();
		}
		
		return false;
	}
}
