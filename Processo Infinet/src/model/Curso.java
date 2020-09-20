package model;

import java.util.List;

public class Curso {

	private int codcurso;
	private String nome;
	private String descricao;
	private String ementa;
	private List<Turma> turmas;
	
	public Curso(int codcurso, String nome, String descricao, String ementa, List<Turma>turmas) {
		
	}
	
	public int getCodcurso() {
		return codcurso;
	}
	public void setCodcurso(int codcurso) {
		this.codcurso = codcurso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public List<Turma> getCodturma() {
		return turmas;
	}
	public void setCodturma(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	
	
}
