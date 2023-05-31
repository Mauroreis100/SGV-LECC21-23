package cliente;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import carrinho.Carrinho;

public class Cliente implements Serializable {

	private int id;
	private String nome, bi, email;
	private String numeroTel;
	private Vector compras = new Vector();
	private Calendar data_Criacao;

	/*
	 * O cliente tem um vector de todas as compras já feitas Caso tenha de recuperar
	 * ou iniicializar pela primeira vez, este construtor leva o vector, vazio ou
	 * não
	 */
	public Cliente(Calendar data_Criacao, int id, String bi, String nome, String numeroTel, String email,
			Vector compras) {
		this.id = id;
		this.bi = bi;
		this.numeroTel = numeroTel;
		this.email = email;
		this.data_Criacao = data_Criacao;
		this.nome = nome;
		this.compras = compras;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getData_Criacao() {
		return data_Criacao;
	}

	public void setData_Criacao(Calendar data_Criacao) {
		this.data_Criacao = data_Criacao;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return "Cliente [CRIADO EM: "+dateFormat.format(data_Criacao.getTime())+"\t | ID=" + id + "\t | Nome=" + nome + "\t | BI=" + bi + "\t | E-mail=" + email + "\t | Telemóvel="
				+ numeroTel +"]";
	}
	public String curtoString() {
		return "\n\n------ID:"+id+"\tNome: "+nome;
	}

}
