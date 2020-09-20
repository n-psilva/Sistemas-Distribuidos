package model;

public class Disciplina {

	private int ref;
	private String nome;
	
	public Disciplina (int ref, String nome) {
		super();
		this.ref = ref;
		this.nome = nome;
	}
	
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
