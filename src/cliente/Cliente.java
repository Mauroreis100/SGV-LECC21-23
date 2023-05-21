package cliente;

import java.util.Calendar;

public class Cliente {
	private int id;
	private String nome;
	private Calendar data_criacao;
	private int telefone;
	private Vendas compras = null;

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

	public Calendar getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Calendar data_criacao) {
		this.data_criacao = data_criacao;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Vendas getCompras() {
		return compras;
	}

	public void setCompras(Vendas compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
