package cliente;

import java.io.Serializable;
import java.util.Vector;

import carrinho.Carrinho;

public class Cliente implements Serializable{

	private int id;
	private String nome, bi;
	private Carrinho compra;
	private String numeroTel;
	private Vector compras;
	//SEXO !!!!!!!

	/*
	 * O cliente tem um vector de todas as compras já feitas Caso tenha de recuperar
	 * ou iniicializar pela primeira vez, este construtor leva o vector, vazio ou
	 * não
	 */
	public Cliente(int id, String bi, String nome, String numeroTel,Carrinho compra) {
		this.id = id;
		this.bi = bi;
		this.numeroTel=numeroTel;
		this.nome = nome;
		this.compra = compra;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public Carrinho getCompra() {
		return compra;
	}

	public void setCompra(Carrinho compra) {
		this.compra = compra;
	}

	public String getBi() {
		return bi;
	}

	public void setBi(String bi) {
		this.bi = bi;
	}

	public int getId() {
		return id;
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

	public Vector getCompras() {
		return compras;
	}

	public void setCompras(Vector compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", bi="+bi+", nome=" + nome +", numeroTel="+numeroTel+"]";
	}

}
