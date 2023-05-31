package compras;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import carrinho.Carrinho;

public class Compras implements Serializable{
private int id,pertence;
private String nome;
private Calendar data_Criacao;
private Vector itens=new Vector();
public Calendar getData_Criacao() {
	return data_Criacao;
}
public void setData_Criacao(Calendar data_Criacao) {
	this.data_Criacao = data_Criacao;
}
private double total;

public Compras(int id, int pertence, Vector itens, double total) {
	this.id = id;
	this.pertence = pertence;
	this.itens = itens;
	this.total = total;
}
public Compras(Calendar data_Criacao,int id, int pertence,String nome, Vector itens, double total) {
	this.id = id;
	this.data_Criacao=data_Criacao;
	this.pertence = pertence;
	this.nome=nome;
	this.itens = itens;
	this.total = total;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPertence() {
	return pertence;
}
public void setPertence(int pertence) {
	this.pertence = pertence;
}

public Vector getItens() {
	return itens;
}
public void setItens(Vector itens) {
	this.itens = itens;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
@Override
public String toString() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	return "\t\t\tVENDA À DINHEIRO\t\t\t\n------------------------------------------------------------------------------------ |"
			+ "				\nVENDA NR:"+id+"\tCliente: " + pertence + "\nNome:" + nome+"\t\t DATA:+"+dateFormat.format(data_Criacao.getTime())+"+\n-------------------------------------\n"+listarProdutos()+"\n---GRATOS PELA PREFERÊNCIA";
}
public String listarProdutos() {
	String listagem="";
	for (int j = 0; j < itens.size(); j++) {
		listagem+=((Carrinho)itens.get(j)).toCarrinho()+"\n";
	}
	
	return listagem;
}


}
