package cliente;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import carrinho.Carrinho;
import produto.Produto;
import compras.Compras;
import interfaces.InterfaceOperacoes;

public class OperecoesCliente implements InterfaceOperacoes{

	// Método para adicionar cliente
	public Vector adicionarCliente(Vector lista, Cliente cl) {

		int index = procuraBI(lista, cl.getBi());// Verifica se o cliente já existe
		if (index == -1 || lista.size() == 0) {
			lista.add(cl);// Adiciona na lista
			return lista;
		} else {
			System.out.println("Cliente com este BI já existe");
			return lista;
		}
	}

	// Gerar id aleatorio
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

	// Método para retornar posição do cliente com o BI
	public int procuraBI(Vector lista, String bi) {
		for (int i = 0; i < lista.size(); i++) {
			if ((((Cliente) lista.get(i)).getBi()).equalsIgnoreCase(bi)) {
				return i;
			}
		}
		return -1;
	}

	// Método para retornar posição do cliente com o ID
	public int procuraID(Vector lista, int id) {
		for (int i = 0; i < lista.size(); i++) {
			if ((((Cliente) lista.get(i)).getId()) == id) {
				return i;
			}
		}
		return -1;
	}

	// Método para apagar CLiente
	public void apagarCliente(Vector lista, int id) {
		int index = procuraID(lista, id);
		if (index != -1) {
			lista.remove(index);
			System.out.println("Removido com sucesso");
		} else {
			System.out.println("ID NÃO EXISTE");
		}
	}

	// Editar dados do cliente
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
						String nome = input.nextLine().toUpperCase();
						input.nextLine();
						((Cliente) clientes.get(index)).setNome(nome);
						System.out.println("Nome atualizado para: " + ((Cliente) clientes.get(index)).getNome());
						break;
					case 2:
						System.out.println("Insira o novo nº de BI para o cliente:");
						String bi = input.next().toUpperCase();
						input.nextLine();
						int indice = procuraBI(clientes, bi);
						if (indice != -1) {
							((Cliente) clientes.get(index)).setBi(bi);
							System.out.println("Código de identificação atualizado para: "
									+ ((Cliente) clientes.get(index)).getBi());

						} else {
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

	// Imprimir todos os clientes
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
			Vector compras = ((Cliente) clientes.get(index)).getCompras(); // Pega as compras co cliente
			for (int j = 0; j < compras.size(); j++) {
				System.out.print(((Compras) compras.get(j)).toString()); // Imprime toda a conta
				valorTotal += ((Compras) compras.get(j)).getTotal(); // Para dizer quanto é que já gastou na loja
			}
			System.out.println(((Cliente) clientes.get(index)).curtoString() + " já gastou " + valorTotal + ",00MT");
		} else {
			System.out.println("Este Cliente não existe");
		}

	}
}
