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
		Produto adicionar=new Produto(index,encontrado.getNome(),quantidade,encontrado.getPreco());
		int indexExiste = verificaExistenciaCarinho(index, cart, lista);
		boolean situacaoStock=verificacaoQuantidade(index,lista,quantidade);
		
		if (situacaoStock) {
			if (indexExiste != -1) {
				encontrado.setQtd(encontrado.getQtd()-quantidade);
				((Produto)carrinho.get(indexExiste)).setQtd((((Produto)carrinho.get(indexExiste))).getQtd()+quantidade);
			}else{
				encontrado.setQtd(encontrado.getQtd()-quantidade);
				carrinho.add(adicionar);
				
			}
		} 
		return carrinho;
//
//		if (cart.getProdutos().contains((Produto) lista.get(index))) {
//			for (int i = 0; i < carrinho.size(); i++) {
//				// ID dos produtos que estão no carrinho==Id dos produto na lista
//				if (((Produto) carrinho.get(i)).getId() == (encontrado.getId())) {
//					if (encontrado.getQtd() < 0) {
//						System.out.println("Acabou o stock com! Tente outra quantidade");
//					} else if (quantidade > encontrado.getQtd()) {
//						System.out.println("Em stock só tem " + encontrado.getQtd() + " de " + encontrado.getNome());
//					} else {
//						((Produto) carrinho.get(i)).setQtd(((Produto) carrinho.get(i)).getQtd() + quantidade);
//						encontrado.setQtd(encontrado.getQtd() - quantidade);
//						System.out.println("Adicionado");
//					}
//					return carrinho;
//				}
//			}
//
//		}

	

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
	public boolean verificacaoQuantidade(int index, Vector lista, int quantidade) {
		Stock stock = new Stock();
		Produto encontrado = ((Produto) lista.get(index));
		if (quantidade > encontrado.getQtd()) {
			System.out.println("Em stock só tem " + encontrado.getQtd() + " de " + encontrado.getNome());
			return false;
		} else if (encontrado.getQtd() < 0) {
			System.out.println("Acabou o stock com! Tente outra quantidade");
			return false;

		} else if(quantidade<0) {
			System.out.println("Insira uma quantidade válida");
			return false;
		}else {
						return true;
		}
	}

	public int verificaExistenciaCarinho(int index, Carrinho cart, Vector lista) {
		Stock stock = new Stock();
		Vector carrinho = cart.getProdutos();
		Produto encontrado = ((Produto) lista.get(index));
		for (int i = 0; i < carrinho.size(); i++) {
			if (((Produto) carrinho.get(i)).getId() == encontrado.getId()) {
				return i;
			}
		}
		return -1;
	}

	//A remoção devolve a quantidade de produtos a todos eles
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
