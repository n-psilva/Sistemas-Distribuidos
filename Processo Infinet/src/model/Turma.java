package model;

import java.util.List;

public class Turma {

	private int codigo;
	private int qtdalunos;
	private List<Bloco> blocos;
	
	public Turma (int codigo, int qtdalunos, List<Bloco>blocos) {
		super();
		this.codigo = codigo;
		this.qtdalunos = qtdalunos;
		this.blocos = blocos;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getQtdalunos() {
		return qtdalunos;
	}
	public void setQtdalunos(int qtdalunos) {
		this.qtdalunos = qtdalunos;
	}
	public List<Bloco> getBloco() {
		return blocos;
	}
	public void setBloco(List<Bloco> blocos) {
		this.blocos = blocos;
	}
	
	
}
