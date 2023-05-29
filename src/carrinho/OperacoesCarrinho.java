package carrinho;

import java.util.Iterator;
import java.util.Vector;

import produto.Produto;
import produto.Stock;

public class OperacoesCarrinho {
	public Vector adicionarProduto(int index, Carrinho cart, Vector lista, int quantidade) {
		Stock stock = new Stock();
		Vector carrinho = cart.getProdutos();
		Produto encontrado = ((Produto) lista.get(index));
		if (cart.getProdutos().contains((Produto) lista.get(index))) {
			for (int i = 0; i < carrinho.size(); i++) {
				// ID dos produtos que estão no carrinho== Id dos produto na lista
				if (((Produto) carrinho.get(i)).getId() == (encontrado.getId())) {
					if (encontrado.getQtd() < 0) {
						System.out.println("Acabou o stock com! Tente outra quantidade");
					} else if (quantidade > encontrado.getQtd()) {
						System.out.println("Em stock só tem " + encontrado.getQtd() + " de " + encontrado.getNome());
					} else {
						((Produto) carrinho.get(i)).setQtd(((Produto) carrinho.get(i)).getQtd() + quantidade);
						encontrado.setQtd(encontrado.getQtd() - quantidade);
						System.out.println("Adicionado");
					}
					return carrinho;
				}
			}

		}
		carrinho.add(encontrado);
		return carrinho;

//	int id=stock.procurarCodigo(lista, prod.getId());
//	int qtd=prod.getQtd();//Recebe a quantidade do produto que estou prestes a inserir
//	//Se o produto que estou prestes a inserir já existe então muda a quantidade para +quantidade
//		cart.getProdutos().set(cart.getProdutos().indexOf(prod), prod.getQtd()+quantidade);
//	}
//	cart.getProdutos().add(prod);
//	//Diminuir a quantidade, ao adicionar no carrinho deve diminuir taambém
//	return cart.getProdutos();
	}

//	public boolean verificaStock() {
//		
//	}

	public Vector removerProduto(int id, Carrinho cart) {
		for (int i = 0; i < cart.getProdutos().size(); i++) {
			// && ((Produto)cart.getProdutos().get(i)).getQtd()
			if (((Produto) cart.getProdutos().get(i)).getId() == id) {
				cart.getProdutos().remove(i);
				System.out.println("ECONTRAMOS");
				return cart.getProdutos();
			}
		}
		System.out.println("NÃO ECONTRAMOS");

		return cart.getProdutos();
	}

	public void listarItensCarrinho(Carrinho cart) {
		for (int i = 0; i < cart.getProdutos().size(); i++) {
			System.out.println(((Produto) cart.getProdutos().get(i)).getId() + " | "
					+ ((Produto) cart.getProdutos().get(i)).getNome() + "|"
					+ ((Produto) cart.getProdutos().get(i)).getQtd());
		}
	}

}
