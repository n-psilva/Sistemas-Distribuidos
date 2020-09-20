package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;


public class DisciplinaDAO {

	public DisciplinaDAO() {
		
	}
	private Connection conexao;
	
	public DisciplinaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	public void Inserir(Disciplina _objeto) throws SQLException {
		
		String SQL = "INSERT INTO disciplina (ref, nome) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getRef());
		ps.setString(2, _objeto.getNome());
		
		ps.execute();
	}
	
	
	public List<Disciplina> listarTodos() throws SQLException {
		
		List<Disciplina> disc = new ArrayList<Disciplina>();
		ResultSet rs = null;
		
		String SQL = "SELECT ref, nome FROM sisciplina";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int ref = rs.getInt(1);
			String nome = rs.getString(2);
			
			Disciplina d = new Disciplina(ref, nome);
			
			disc.add(d);
		}
		
		return disc;
	}
	
	
	public Boolean Excluir(int _ref) throws SQLException {
		
		String SQL = "DELETE FROM disciplina WHERE ref = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _ref);
				
		return ps.execute();
	}
	
	
	public Boolean Atualizar(Disciplina _objeto) throws SQLException {
		
		String SQL = "UPDATE disciplina SET nome = ? WHERE ref = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setInt(2, _objeto.getRef());
				
		return ps.execute();
	}
	
}
