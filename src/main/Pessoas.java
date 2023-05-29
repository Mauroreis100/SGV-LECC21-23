package main;

import java.io.Serializable;

/**
 * @author mauro
 *
 */
public class Pessoas implements Serializable{
	int id;
	String nome;
	public int getId() {
		return id;
	}
	public Pessoas(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
