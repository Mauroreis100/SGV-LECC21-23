package carrinho;

import java.util.Iterator;
import java.util.Vector;

import cliente.Cliente;
import compras.Compras;
import produto.Produto;
import produto.Stock;

public class OperacoesCarrinho {

	public Vector adicionarProduto(int index, Vector carrinho, Vector lista, int quantidade) {
		Stock stock = new Stock();
		//Vector carrinho = carrinho;
		Produto encontrado = ((Produto) lista.get(index));
		Produto adicionar = new Produto(index, encontrado.getNome(), quantidade, encontrado.getPreco());
		int indexExiste = verificaExistenciaCarinho(index, carrinho, lista);
		boolean situacaoStock = verificacaoQuantidade(index, lista, quantidade);

		if (situacaoStock) {
			if (indexExiste != -1) {
				encontrado.setQtd(encontrado.getQtd() - quantidade);
				((Carrinho) carrinho.get(indexExiste))
						.setQtd((((Carrinho) carrinho.get(indexExiste))).getQtd() + quantidade);
				(((Carrinho) carrinho.get(indexExiste))).setTotal(encontrado.getPreco()*(((Carrinho) carrinho.get(indexExiste))).getQtd());
			} else {
				encontrado.setQtd(encontrado.getQtd() - quantidade);
				Carrinho produto=new Carrinho(index, encontrado.getNome(), quantidade, encontrado.getPreco(),encontrado.getPreco()*quantidade);
				carrinho.add(produto);
//				(((Carrinho) carrinho.get(carrinho.size()-1))).setTotal(encontrado.getPreco()*quantidade);

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


	public boolean verificacaoQuantidade(int index, Vector lista, int quantidade) {
		Stock stock = new Stock();
		Produto encontrado = ((Produto) lista.get(index));
		if (quantidade > encontrado.getQtd()) {
			System.out.println("Em stock só tem " + encontrado.getQtd() + " de " + encontrado.getNome());
			return false;
		} else if (encontrado.getQtd() < 0) {
			System.out.println("Acabou o stock com! Tente outra quantidade");
			return false;

		} else if (quantidade < 0) {
			System.out.println("Insira uma quantidade válida");
			return false;
		} else {
			return true;
		}
	}

	public int verificaExistenciaCarinho(int index, Vector carrinho, Vector lista) {
		Stock stock = new Stock();
		Produto encontrado = ((Produto) lista.get(index));
		for (int i = 0; i < carrinho.size(); i++) {
			//Ele peda o id do Produto
			if (((Carrinho) carrinho.get(i)).getId() == encontrado.getId()) {
				return i;
			}
		}
		return -1;
	}

	// A remoção devolve a quantidade de produtos
	public Vector removerProduto(int id, Vector carrinho, Vector temporario) {
		int index = procuraProdutoCarrinho(id, carrinho);
		for (int i = 0; i < carrinho.size(); i++) {
			// && ((Produto)cart.getProdutos().get(i)).getQtd()
			if (((Produto) carrinho.get(i)).getId() == id) {

				carrinho.remove(i);
				System.out.println("ECONTRAMOS");
				return carrinho;
			}
		}
		System.out.println("NÃO ECONTRAMOS");

		return carrinho;
	}

	public Vector removerProdutoQuantidade(int id, Vector carrinho, Vector temporario, int quantidade) {
		int index = procuraProdutoCarrinho(id, carrinho);

		Stock stock = new Stock();
		int indexStock = stock.procurarCodigo(temporario, id);
		// IF TEM NO CARRINHO E NO STOCK DEVOLVE QUANTIDADE DE STOCK E DIMINUI A
		// QUANTIDADE NO CARRINHO
		if (index != -1) {// Caso encontre no carrinho
			if (((Produto) carrinho.get(index)).getId() == ((Produto) temporario.get(indexStock)).getId()) {// Se tem no
																											// carrinho,
																											// tem no
																										// stock
				((Produto) temporario.get(indexStock))
						.setQtd(((Produto) temporario.get(indexStock)).getQtd() + quantidade);
				((Produto) carrinho.get(index)).setQtd(((Produto) carrinho.get(index)).getQtd() - quantidade);
				// ((Produto) temporario.get(indexStock)).setQtd(2);
				if (((Produto) carrinho.get(index)).getQtd() < 0) {
					carrinho.remove(index);
				}
			}
		} else {
			System.out.println("Produto não está no carrinho");
		}

		return carrinho;
	}

	public int procuraProdutoCarrinho(int id, Vector carrinho) {
		for (int i = 0; i < carrinho.size(); i++) {
			if (((Produto) carrinho.get(i)).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public void listarItensCarrinho(Vector carrinho) {
		for (int i = 0; i < carrinho.size(); i++) {
			System.out.println(((Produto) carrinho.get(i)).getId() + " | "
					+ ((Produto) carrinho.get(i)).getNome() + "|"
					+ ((Produto) carrinho.get(i)).getQtd()+"| "
					+((Carrinho) carrinho.get(i)).getTotal());
		}
	}

	public boolean estaVazio(Vector carrinho) {
		if (carrinho.size() == 0) {
			return false;
		}
		return true;
	}

	public boolean vendaDinheiro(Vector carrinho, Cliente cl) {
		
		double total = 0;
		Vector compraCliente=cl.getCompras();
		System.out.println(compraCliente.toString());
		for (int i = 0; i < carrinho.size(); i++) {
			total += ((Produto) carrinho.get(i)).getPreco();
			((Produto) carrinho.get(i)).setVendas(((Produto) carrinho.get(i)).getVendas() + 1);
		}
		System.out.println("TOTAL= "+total);
		if (estaVazio(carrinho)) {
			//compra.setTotal(total * (17 / 100));
			//
			Compras venda=new Compras(1,cl.getId(),cl.getNome(),carrinho,total);
			cl.getCompras().add(venda);
			System.out.println("Compra feita com sucesso");
			return true;
		}
		return false;
	}
	
	

}
