package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bloco;
import model.Turma;


public class TurmaDAO {

	private Connection conexao;
	
	public TurmaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	public void Inserir(Turma _objeto) throws SQLException {
		
		String SQL = "INSERT INTO turma (codigo, qtdalunos) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCodigo());
		ps.setInt(2, _objeto.getQtdalunos());
		
		ps.execute();
	}
	
	
	public List<Turma> listarTodos() throws SQLException {
		
		List<Turma> turmas = new ArrayList<Turma>();
		ResultSet rs = null;
		
		String SQL = "SELECT codigo, qdtalunos FROM turma";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int codigo = rs.getInt(1);
			int qtdalunos = rs.getInt(2);
			
			BlocoDAO daoBloco = new BlocoDAO(this.conexao);
			
			List<Bloco> blocos = daoBloco.listarTodos();
			
			Turma t = new Turma (codigo, qtdalunos, blocos);
			
			turmas.add(t);
		}
		
		return turmas;
	}
	
	
	public Boolean Excluir(int _codigo) throws SQLException {
		
		String SQL = "DELETE FROM turma WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _codigo);
				
		return ps.execute();
	}
	
	
	public Boolean Atualizar(Turma _objeto) throws SQLException {
		
		String SQL = "UPDATE turma SET qtdalunos = ? WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getQtdalunos());
		ps.setInt(2, _objeto.getCodigo());
				
		return ps.execute();
	}
}
