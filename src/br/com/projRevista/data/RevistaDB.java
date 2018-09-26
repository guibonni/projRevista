package br.com.projRevista.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
					.prepareStatement("insert into revista (nome, ano, mes, qtdPagina) values (?, ?, ?, ?)");

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
	
	public List<Revista> getAll(String filtro, String ano) throws SQLException {
		List<Revista> lstRevista = new ArrayList<>();
		
		try {
			ps = this.connection.prepareStatement("select id, nome, ano, mes, qtdPagina from revista where 1 = 1 " + (filtro.equals("") ? "" : "and nome like '" + filtro + "%'") + (ano.equals("") ? "" : "and ano = '" + ano + "'") + " order by ano desc, nome");
			rs = ps.executeQuery();

			while (rs.next()) {
				lstRevista.add(new Revista(rs.getInt("id"), rs.getString("nome"), rs.getInt("ano"), rs.getString("mes"), rs.getInt("qtdPagina")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lstRevista;
	}
}
