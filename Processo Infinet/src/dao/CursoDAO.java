package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Curso;
import model.Turma;

public class CursoDAO {

	private Connection conexao;
	
	public CursoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	public void Inserir(Curso _objeto) throws SQLException {
		
		String SQL = "INSERT INTO curso (codcurso, nome, descricao, ementa) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCodcurso());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getDescricao());
		ps.setString(4, _objeto.getEmenta());
		
		ps.execute();
	}
	
	
	public List<Curso> listarTodos() throws SQLException {
		
		List<Curso> cursos = new ArrayList<Curso>();
		ResultSet rs = null;
		
		String SQL = "SELECT codcurso, nome, descricao, ementa FROM curso";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int codcurso = rs.getInt(1);
			String nome = rs.getString(2);
			String descricao = rs.getString(3);
			String ementa = rs.getString(4);
			
			TurmaDAO daoTurma = new TurmaDAO(this.conexao);
			
			List<Turma> turmas = daoTurma.listarTodos();
			
			Curso c = new Curso(codcurso, nome, descricao, ementa, turmas);
			
			cursos.add(c);
		}
		
		return cursos;
	}
	
	
	public Boolean Excluir(int _codcurso) throws SQLException {
		
		String SQL = "DELETE FROM curso WHERE codcurso = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _codcurso);
				
		return ps.execute();
	}
	
	
	public Boolean Atualizar(Curso _objeto) throws SQLException {
		
		String SQL = "UPDATE curso SET nome = ?, descricao = ?, ementa = ? WHERE codcurso = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getDescricao());
		ps.setString(3, _objeto.getEmenta());
		ps.setInt(4, _objeto.getCodcurso());
				
		return ps.execute();
	}
	
}
