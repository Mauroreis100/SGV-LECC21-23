package cliente;

import java.util.Vector;

import vendas.Vendas;

public class OperacoesClientes {

	// Cria o cliente e o coloca dentro do vector
	public void criarCliente(Vector lista, Cliente cliente) {
		lista.add(cliente);
		// Adicionar a um ficheiro?
	}

	// Apagar pelo código
	public void apagarCliente(Vector lista, int id) {

	}
	// Como apagar clientes no ficheiro de texto depois de escritos?

	// Deve pesquisar pelo código
	public Cliente pesquisarCliente(Vector lista, int codigo) {
		return null;
	}

	// Actualizar Cliente
	public boolean actualizarCliente(Vector lista, int codigo) {

		for (int i = 0; i < lista.size(); i++) {
			if ((((Cliente) lista.get(i)).getId()) == codigo) {
				((Cliente) lista.get(i)).setId(codigo);
				return true;
			}
		}
		return false;
	}

	// Adicionando cada compra ao vector deste Cliente, provavelmente devia estar
	// nas operações das vendas
	public boolean adicionarCompra(Vector lista, int codigo, Vendas compra) {
		for (int i = 0; i < lista.size(); i++) {
			if ((((Cliente) lista.get(i)).getId()) == codigo) {
				((Cliente) lista.get(i)).getCompras().add(compra);
				return true;
			}
		}
		return false;
	}

	// Impressão de todas as vendas do cliente x
	public boolean verContaCorrente(Vector lista, int codigo) {
		double compras = 0;
		for (int i = 0; i < lista.size(); i++) {
			if ((((Cliente) lista.get(i)).getId()) == codigo) {
				for (int j = 0; j < (((Cliente) lista.get(i)).getCompras()).size(); j++) {
					// Cada compra feita deve entrar no verContaCorrente
					// compras+=((Cliente) lista.get(i)).getCompras().get(j);
					return true;
				}
			}
		}
		return false;
	}

	// Impressão de todos os clientes
	public void imprimirClientes(Vector lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(((Cliente) lista.get(i)).toString());
		}
	}
	/*
	 * public String verContaCorrente(Vector lista) { for (int i = 0; i <
	 * lista.size(); i++) { ((Cliente)lista.get(i)).getCompras(); } }
	 */

}
