package vendas;

public class Vendas {
private int id;
private int qtd;
public Vendas(int id, int qtd) {
	this.id=id;
	this.qtd=0;
	
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+"    "+qtd;
	}
}
