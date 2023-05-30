package carrinho;
import java.io.Serializable;
import produto.Produto;
import java.util.Vector;

import produto.Produto;
public class Carrinho extends Produto implements Serializable{
	
	private double total;
public Carrinho(int id, String nome, int qtd, double preco,double total) {
		super(id, nome, qtd, preco);
		this.total=total;
		// TODO Auto-generated constructor stub
	}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
@Override
public String toCarrinho() {
	// TODO Auto-generated method stub
	return super.toCarrinho()+"\t | TOTAL: "+total+"]";
}
}
