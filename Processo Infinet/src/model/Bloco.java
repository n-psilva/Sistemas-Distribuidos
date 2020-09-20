package model;

import java.util.List;

public class Bloco {

	private String cod;
	private String nome;
	private List<Disciplina> disc;
	
	public Bloco (String cod, String nome, List<Disciplina> discip) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.disc = discip;
	}
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Disciplina> getDisc() {
		return disc;
	}
	public void setDisc(List<Disciplina> disc) {
		this.disc = disc;
	}
	
	
}
