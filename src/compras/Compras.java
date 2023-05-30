package compras;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Vector;

public class Compras implements Serializable{
private int id,pertence;
private String nome;
private Calendar data;
private Vector itens=new Vector();
private double total;

public Compras(int id, int pertence, Vector itens, double total) {
	this.id = id;
	this.pertence = pertence;
	this.itens = itens;
	this.total = total;
}
public Compras(int id, int pertence,String nome, Vector itens, double total) {
	this.id = id;
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
public Calendar getData() {
	return data;
}
public void setData(Calendar data) {
	this.data = data;
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
	return "Compras [id=" + id + ", pertence=" + pertence + ", nome=" + nome + ", itens=" + itens + ", total=" + total
			+ "]";
}


}
