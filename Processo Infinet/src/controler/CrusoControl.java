package controler;

import java.sql.Connection;

import dao.Conexao;
import dao.CursoDAO;
import model.Curso;


public class CrusoControl {


	public void Inserir(Curso curso) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			CursoDAO dao = new CursoDAO(conexao);
			
			dao.Inserir(curso);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar incluir.");
		}
	}
	
	
	
	public void Excluir(int curso) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			CursoDAO dao = new CursoDAO(conexao);
			
			dao.Excluir(curso);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar excluir.");
		}
	}
	
	
	public void Atualizar(Curso curso) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			CursoDAO dao = new CursoDAO(conexao);
			
			dao.Atualizar(curso);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar atualizar.");
		}
	}
}
