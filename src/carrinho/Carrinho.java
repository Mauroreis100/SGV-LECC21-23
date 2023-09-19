package carrinho;

import java.io.Serializable; //Importação para gravar no ficheiro de objectos
import produto.Produto; //Importação de Produto para fazer o extends

//Para gravar no ficheiro objecto é preciso -> implements Serializable	

public class Carrinho extends Produto implements Serializable {

	private double total;// Váriavel total que faz a multiplicação de quantidade*preço

	public Carrinho(int id, String nome, int qtd, double preco, double total) {
		super(id, nome, qtd, preco);
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

//	Imprime os dados do produto e a multiplicação
	@Override
	public String toCarrinho() {
		return super.toCarrinho() + "\t | TOTAL: " + total + "]";
	}
}
