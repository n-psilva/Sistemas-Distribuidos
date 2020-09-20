package controler;

import java.sql.Connection;

import dao.TurmaDAO;
import dao.Conexao;
import model.Turma;

public class TurmaControl {

	public void Inserir(Turma turma) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			TurmaDAO dao = new TurmaDAO(conexao);
			
			dao.Inserir(turma);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar incluir.");
		}
	}
	
	
	
	public void Excluir(int turma) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			TurmaDAO dao = new TurmaDAO(conexao);
			
			dao.Excluir(turma);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar excluir.");
		}
	}
	
	
	public void Atualizar(Turma turma) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			TurmaDAO dao = new TurmaDAO(conexao);
			
			dao.Atualizar(turma);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar atualizar.");
		}
	}
}
