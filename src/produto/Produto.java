package produto;
import java.io.Serializable; //Importação para gravar no ficheiro de objectos
public class Produto implements Serializable{
private int id;
private String nome;
private int qtd;
private int vendas;// Váriavel que conta, quantas vezes o produto foi vendido
private double preco;

	/*	
No momento que lês para inserir um produto no vector
Decidi não lidar com a quantidade,
Para colocar no carrinho, a quantidade muda "Virtualmente"
Ou seja não fez a mudança necessariamente porque pode remover do carrinho
que seria devolver o produto a prateleira
	*/ 

	public Produto(int id, String nome, int qtd,double preco) {
		this.id = id;
		this.nome = nome;
		this.qtd = qtd;
		this.preco=preco;
	}

public int getVendas() {
	return vendas;
}
public void setVendas(int vendas) {
	this.vendas = vendas;
}
public double getPreco() {
	return preco;
}
public void setPreco(double preco) {
	this.preco = preco;
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
public int getQtd() {
	return qtd;
}
public void setQtd(int qtd) {
	this.qtd = qtd;
}
//String para para imprimir vendas sim é igual ao toString
public String imprimiVendas() {
	StringBuffer builder = new StringBuffer();
	builder.append("Produto [id=");
	builder.append(id);
	builder.append(", Nome=");
	builder.append(nome);
	builder.append(", VENDAS=");
	builder.append(vendas);
	builder.append("]");
	return builder.toString();
}

@Override //String para imprimir as vendas
public String toString() {
	StringBuffer builder = new StringBuffer();
	builder.append("Produto [ID=");
	builder.append(id);
	builder.append("\t | Nome=");
	builder.append(nome);
	builder.append("\t | Qtd=");
	builder.append(qtd);
	builder.append("\t | Preço=");
	builder.append(preco);
	builder.append("\t | Vendas=");
	builder.append(vendas);
	builder.append("]");
	return builder.toString();
}

//String para o carrinho, vem sem mostrar as vendas
public String toCarrinho() {
	StringBuffer builder = new StringBuffer();
	builder.append("Produto [ID=");
	builder.append(id);
	builder.append("\t | Nome=");
	builder.append(nome);
	builder.append("\t | Qtd=");
	builder.append(qtd);
	builder.append("\t | Preço=");
	builder.append(preco);
	builder.append("");
	return builder.toString();
}

public String gravacao() {
	StringBuffer builder = new StringBuffer();
	builder.append(" ");
	builder.append(id);
	builder.append(" ");
	builder.append(nome);
	builder.append(" ");
	builder.append(qtd);
	builder.append(" ");
	builder.append(preco);
	builder.append(" ");
	builder.append(vendas);
	return builder.toString();
}

}
