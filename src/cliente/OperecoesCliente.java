package cliente;

import java.util.Scanner;
import java.util.Vector;

import carrinho.Carrinho;
import produto.Produto;

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
	public boolean compraIVA(int id, Vector lista, Carrinho compra) {
		int index = procuraID(lista, id);
		double soma = 0;
		if (index != -1) {
			for (int i = 0; i < compra.getProdutos().size(); i++) {
				soma += ((Produto) compra.getProdutos().get(i)).getPreco();
			}
			compra.setTotal(soma);
			((Cliente) lista.get(index)).setCompra(compra);
			System.out.println("COMPRA FEITA COM SUCESSO\nTOTAL = " + compra.getTotal() + "MT");
			return true;
		}
		System.out.println("FALHA NA COMPRA! TENTE DENOVO");
		return false;

	}

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
						((Cliente) clientes.get(index)).setBi(bi);
						System.out.println(
								"Código de identificação atualizado para: " + ((Cliente) clientes.get(index)).getBi());
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
			Vector compras=((Cliente)clientes.get(index)).getCompras();
			for (int j = 0; j < compras.size() ; j++) {
				valorTotal += ((Produto)compras.get(j)).getPreco();// Problemas com cast } } }
			}
		}
		
	}

	// TENHO DE APLICAR IVA AQUI

//	  //Verificar existencia do cliente public boolean
//	  verificarExistenciaCliente(Cliente cliente,Vector clientes,int
//	  codigoIdentificacao) { for(int i=0;i<clientes.size();i++) {
//	  if(((Cliente)clientes.get(i)).getCodigoIdentificacao()==codigoIdentificacao)
//	  { return true; } } return false; }
//	  
//	  //Registrar um novo cliente - Create public void registrarCliente(Cliente
//	  cliente,Vector clientes,Calendar data_criacao) {
//	  if(verificarExistenciaCliente(cliente, clientes, 0)==true) {
//	  clientes.add(cliente); data_criacao.getTime();
//	  System.out.println("Cliente adicionado com sucesso!"); }else {
//	  System.out.println("Cliente existente!"); } }
//	  
//	  //Editar algum dado do cliente - Update 
//	  
//	  
//	  // Pesquisar cliente pelo código public Object pesquisarCliente(Cliente
//	  cliente,Vector clientes, int codigoIdentificacao) { Cliente client=null;
//	  for(int i=0;i<clientes.size();i++) {
//	  if(((Cliente)clientes.get(i)).getCodigoIdentificacao()==codigoIdentificacao)
//	  { cliente=(Cliente)clientes.get(i); } } return client; }
//	  
//	  // Adicionando cada compra ao vector deste Cliente public boolean
//	  adicionarCompra(Cliente cliente,Vector clientes, int codigoIdentificacao,
//	  Vendas compra) { for (int i = 0; i < clientes.size(); i++) { if ((((Cliente)
//	  clientes.get(i)).getCodigoIdentificacao())==codigoIdentificacao) { ((Cliente)
//	  clientes.get(i)).getCompras().add(compra); return true; } } return false; }
//	  
//	  //Verificar as compras feitas pelo cliente public void
//	  verComprasFeitas(Cliente cliente,int codigoIdentificacao,Vector
//	  compras,Vector clientes) {
//	  if(verificarExistenciaCliente(cliente,null,codigoIdentificacao)==true) {
//	  for(int i=0;i<compras.size();i++) {
//	  if(((Cliente)clientes.get(i)).getCodigoIdentificacao()==codigoIdentificacao)
//	  { Cliente client=(Cliente)clientes.get(i);
//	  System.out.println(client.getCompras()); //or
//	  System.out.println(client.getCompras().toString()); break; } } } }
//	  

}
