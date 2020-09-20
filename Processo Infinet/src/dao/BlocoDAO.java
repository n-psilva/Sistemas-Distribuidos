package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bloco;
import model.Disciplina;

public class BlocoDAO {

	private Connection conexao;
	
	public BlocoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	public void Inserir(Bloco _objeto) throws SQLException {
		
		String SQL = "INSERT INTO bloco (cod, nome) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getCod());
		ps.setString(2, _objeto.getNome());
		
		ps.execute();
	}
	
	
	public List<Bloco> listarTodos() throws SQLException {
		
		List<Bloco> blocos = new ArrayList<Bloco>();
		ResultSet rs = null;
		
		String SQL = "SELECT ref, nome FROM bloco";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			String cod = rs.getString(1);
			String nome = rs.getString(2);
			
			DisciplinaDAO daoDisc = new DisciplinaDAO(this.conexao);
			
			List<Disciplina> discip = daoDisc.listarTodos();
			
			Bloco b = new Bloco (cod, nome, discip);
			
			blocos.add(b);
		}
		
		return blocos;
	}
	
	
	public Boolean Excluir(int _cod) throws SQLException {
		
		String SQL = "DELETE FROM bloco WHERE cod = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _cod);
				
		return ps.execute();
	}
	
	
	public Boolean Atualizar(Bloco _objeto) throws SQLException {
		
		String SQL = "UPDATE bloco SET nome = ? WHERE cod = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getCod());
				
		return ps.execute();
	}
}
