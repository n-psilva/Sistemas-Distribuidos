package controler;

import java.sql.Connection;

import dao.Conexao;
import dao.BlocoDAO;
import model.Bloco;

public class BlocoControl {

	public void Inserir(Bloco bloco) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			BlocoDAO dao = new BlocoDAO(conexao);
			
			dao.Inserir(bloco);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar incluir.");
		}
	}
	
	
	
	public void Excluir(int bloco) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			BlocoDAO dao = new BlocoDAO(conexao);
			
			dao.Excluir(bloco);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar excluir.");
		}
	}
	
	
	public void Atualizar(Bloco bloco) {
		try {
			Conexao fabrica = new Conexao();
			Connection conexao = fabrica.fazerConexao();
			
			BlocoDAO dao = new BlocoDAO(conexao);
			
			dao.Atualizar(bloco);
			
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar atualizar.");
		}
	}
}
