package controler;

import java.sql.Connection;

import dao.Conexao;
import dao.DisciplinaDAO;
import model.Disciplina;

public class DisciplinaControl {


	public void Inserir(Disciplina disciplina) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			DisciplinaDAO dao = new DisciplinaDAO(conexao);
			
			dao.Inserir(disciplina);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar incluir.");
		}
	}
	
	
	
	public void Excluir(int disciplina) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			DisciplinaDAO dao = new DisciplinaDAO(conexao);
			
			dao.Excluir(disciplina);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar excluir.");
		}
	}
	
	
	public void Atualizar(Disciplina disciplina) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			DisciplinaDAO dao = new DisciplinaDAO(conexao);
			
			dao.Atualizar(disciplina);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar atualizar.");
		}
	}
	
}
