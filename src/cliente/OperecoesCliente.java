package cliente;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import carrinho.Carrinho;
import produto.Produto;
import compras.Compras;

public class OperecoesCliente {

	public Vector adicionarCliente(Vector lista, Cliente cl) {
		int index = procuraBI(lista, cl.getBi());
		if (index == -1 || lista.size() == 0) {
			lista.add(cl);
			return lista;
		} else {
			System.out.println("Cliente com este BI já existe");
			return lista;
		}
	}

	public int geracaoID(Vector lista) {
		Random random = new Random();
		int id = random.nextInt(101);
		for (int i = 0; i < lista.size(); i++) {
			if (((Cliente) lista.get(i)).getId() == id) {
				return geracaoID(lista);
			}
		}
		return id;
	}

	public int procuraBI(Vector lista, String bi) {
		for (int i = 0; i < lista.size(); i++) {
			if ((((Cliente) lista.get(i)).getBi()).equalsIgnoreCase(bi)) {
				return i;
			}
		}
		return -1;
	}

	public int procuraID(Vector lista, int id) {
		for (int i = 0; i < lista.size(); i++) {
			if ((((Cliente) lista.get(i)).getId()) == id) {
				return i;
			}
		}
		return -1;
	}

	public void apagarCliente(Vector lista, int id) {
		int index = procuraID(lista, id);
		if (index != -1) {
			lista.remove(index);
			System.out.println("Removido com sucesso");
		} else {
			System.out.println("ID NÃO EXISTE");
		}
	}

	/*
	 * Recebe o ID do cliente que está a usar o programa no da compra Recebe a lista
	 * de clientes E recebe o cliente Compra recebe o objecto carrinho depois de
	 * seleccionar tudo que quer comprar
	 * 
	 */

	public void editarDadoCliente(Vector clientes, int id) {
		int index = procuraID(clientes, id);

		if (index != -1) {
			for (int i = 0; i < clientes.size(); i++) {
				Scanner input = new Scanner(System.in);
				int escolha;
				do {
					System.out.println("***Menu de Edição de Dados do Cliente***");
					System.out.println("\nModifique dados do Cliente" + ((Cliente) clientes.get(index)).toString()
							+ "\n1-Nome do Cliente \n2-BI \n3-Número de telefone \n0 - Sair");
					escolha = input.nextInt();
					switch (escolha) {
					case 0:

						break;
					case 1:
						System.out.println("Insira o nome do cliente:");
						String nome = input.next().toUpperCase();
						input.nextLine();
						((Cliente) clientes.get(index)).setNome(nome);
						;
						System.out.println("Nome atualizado para: " + ((Cliente) clientes.get(index)).getNome());
						break;
					case 2:
						System.out.println("Insira o novo nº de BI para o cliente:");
						String bi = input.next().toUpperCase();
						input.nextLine();
						int indice = procuraBI(clientes, bi);
						if(indice!=-1) {
							((Cliente) clientes.get(index)).setBi(bi);
							System.out.println(
									"Código de identificação atualizado para: " + ((Cliente) clientes.get(index)).getBi());
							
						}else {
							System.out.println("Número de BI já existente!");
						}
						break;
					case 3:
						System.out.println("Insira o novo número de telefone do cliente:");
						String telefone = "+" + input.next().toUpperCase();
						input.nextLine();
						((Cliente) clientes.get(index)).setNumeroTel(telefone);
						System.out
								.println("Telefone atualizado para: " + ((Cliente) clientes.get(index)).getNumeroTel());
						break;
					default:
						System.out.println("Opção Inválida!\nInsira novamente:");

						break;
					}
				} while (escolha != 0);

			}
		} else {
			System.out.println("Cliente não encontrado!");
		}
	}

	public void imprimirTodos(Vector lista) {
		if (lista.size() > 0) {
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(((Cliente) lista.get(i)).toString());
			}

		} else {
			System.out.println("SEM CLIENTES!");
		}
	}

	// Ver conta corrente do Cliente (Tudo que o cliente já comprou em produtos)
	public void verContaCorrente(Vector clientes, int id) {
		Scanner input = new Scanner(System.in);
		double valorTotal = 0;

		int index = procuraID(clientes, id);

		if (index != -1) {
			Vector compras = ((Cliente) clientes.get(index)).getCompras();
			for (int j = 0; j < compras.size(); j++) {
				System.out.println(((Compras) compras.get(j)).toString());
				valorTotal += ((Compras) compras.get(j)).getTotal();
			}
			System.out.println(((Cliente) clientes.get(index)).curtoString()+" já gastou "+valorTotal+",00MT");
		} else {
			System.out.println("Este Cliente não existe");
		}

	}
}
