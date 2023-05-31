package main;

import produto.Produto;
import produto.Stock;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import carrinho.*;
import cliente.*;
import compras.Compras;

public class Main {
//ver situação de IDS
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		// Instância de operações comuns
		OperacoesVitais opVitais = new OperacoesVitais();
		// Instância Vector dos Clientes (Eventualmente deve recuperar do ficheiro de
		// texto)

		Vector clientes = new Vector();
		String caminhoClientes = "Cliente\\ClientesDB.txt";
		File fileClientes = new File(caminhoClientes);
		if (fileClientes.length() != 0) {
			clientes = (Vector) opVitais.recuperarObjecto(caminhoClientes);
		}

		// Instância Vector dos Produtos no Stock. (Eventualmente deve recuperar do
		// ficheiro de texto)
		Vector stock = new Vector();
		String caminhoProduto = "Produtos\\ProdutosDB.txt";
		File fileProdutos = new File(caminhoProduto);
		if (fileProdutos.length() != 0) {
			stock = (Vector) opVitais.recuperarObjecto(caminhoProduto);
		}

		Vector vendas = new Vector();
		String caminhoVendas = "Vendas\\VendasDB.txt";
		File fileVendas = new File(caminhoVendas);
		if (fileVendas.length() != 0) {
			vendas = (Vector) opVitais.recuperarObjecto(caminhoVendas);
		}
		// Instância de Operações do Vector Clientes
		OperecoesCliente opCliente = new OperecoesCliente();

		// Instância de Operações do Vector Clientes
		OperacoesCarrinho operacoesCart = new OperacoesCarrinho();

		// Instância de Operações do Stock
		Stock armazem = new Stock();

		// Recuperação de produtos do ficheiro de texto
		// Recuperando o que já tem

		/*
		 * Vector stockRecuperado=(Vector)opVitais.recuperarObjecto(caminhoProduto);
		 * System.out.println(stockRecuperado.toString());
		 */
		Scanner ler = new Scanner(System.in);

		Random aleatorio = new Random();

		int operacao;
		int id;// Usando variavel id para todos requisitos
		do {// OPERAÇÕES PRINCIPAL E TELA DE BEM-VINDO
			System.out.println(
					"\t-----\tBEM-VINDO(A) AO SUPERMERCADO LECC21\t-----\n SELECCIONE A SUA OPÇÃO\n1.Comprar\n2. Mais Opções(Cliente/Produto/Vendas)\n0. SAIR DO PROGRAMA\n>>> ");
			operacao = ler.nextInt();
			int procuraCodigo = -1;
			switch (operacao) {
			case 1:
				// Instância Vector dos Produtos no Carrinho. Não recupera nada. guarda tudo na
				// mémoria temporária
				Vector carrinho = new Vector();
				System.out.print("\nIDENTIFIQUE-SE USANDO O CÓDIGO LECC\n>>>");
				// int identificacao=ler.nextInt();
				int codeLECC = ler.nextInt();
				procuraCodigo = opCliente.procuraID(clientes, codeLECC);
				if (procuraCodigo != -1) {
					int opcoesCarrinho;
					do {
						System.out.print("\n BEM-VINDO(A) (" + ((Cliente) clientes.get(procuraCodigo)).getId() + ") "
								+ ((Cliente) clientes.get(procuraCodigo)).getNome() + " "
								+ "\n-----\tESCOLHA A SUA OPERAÇÃO DE CARRINHO\t------\n1. Adicionar produto no carrinho\n2. Remover Produto do carrinho\n3. Ver produtos no carrinho\n4. Ver produtos disponíveis\n5. Finalizar Compra\n0. CANCELAR\n>>> ");
						opcoesCarrinho = ler.nextInt();

						Vector stockTemporario = stock;
						switch (opcoesCarrinho) {
						case 1:
							// Instancia do carrinho cheio de produtos
							System.out.println("Qual é o código do produto que pretende adicionar no carrinho?");
							int codProd = ler.nextInt();
							int index = armazem.procurarCodigo(stock, codProd);
							if (index != -1) {

								System.out.println("E qual é a quantidade de " + ((Produto) stock.get(index)).getNome()
										+ " que pretende adicionar ao carrinho?");
								// cart.getProdutos().add(((Produto) stock.get(index)));
								int quantidade = ler.nextInt();
								// Index do produto no stock
								operacoesCart.adicionarProduto(((Produto) stock.get(index)).getId(), carrinho,
										stockTemporario, quantidade);
								// DEVE MULTIPLICAR OS PRODUTOS PELA QUANTIDADE
							} else {
								System.out.println("Produto não está em stock");
							}

							break;
						case 2:
							System.out.println("Qual é o código do produto que pretende remover no carrinho?");
							int code = ler.nextInt();
							// REMOÇÃO DEVOLVE TODOS OS CARRINHOS AO STOCK TEMPORÁRIO
							// REMOVER TUDO OU 1?
							// operacoesCart.removerProduto(code, cart);

							operacoesCart.removerProdutoQuantidade(code, carrinho, stockTemporario, 2);
							break;
						case 3:
							System.out.println("\n--------------------\tITENS DO CARRINHO\t--------------------");
							operacoesCart.listarItensCarrinho(carrinho);
							break;
						case 4:
							armazem.imprimirTodos(stockTemporario);
							break;
						case 5:
							// AUMENTAR VENDA e GRAVAR A COMPRA NO CLIENTE QUE ESTÁ A USAR O PROGRAMA
							int idCompra = operacoesCart.geracaoID(vendas);
							if (operacoesCart.vendaDinheiro(idCompra, carrinho,
									(Cliente) clientes.get(procuraCodigo))) {
								operacoesCart.actualizarVendas(carrinho, stockTemporario);
								boolean record = opVitais.gravarObjecto(stockTemporario, caminhoProduto);
								boolean gravou = opVitais.gravarObjecto(clientes, caminhoClientes);

								boolean registado = opVitais.gravarObjecto(vendas, caminhoVendas);

							} else {
								System.out.println("\nErro na compra, contacte o suporte ao cliente!\n\n");
							}
							opcoesCarrinho = 0;

							break;
						}
					} while (opcoesCarrinho != 0);
				} else {
					System.out.println("-----------------------------------\nCLIENTE COM CÓDIGO " + codeLECC
							+ " NÃO CADASTRADO! TENTE DE NOVO\n------------------------------------");
				}
				break;
			case 2:
				int opcoes;

				do {// OPERAÇÕES MAIS OPERAÇÕES
					System.out.println("-----\tOPÇÕES\t-----");
					System.out.print("\n1. Clientes\n2. Produtos\n3. Vendas\n0. Voltar\n>>> ");
					opcoes = ler.nextInt();
					switch (opcoes) {
					case 1:
						int opcaoCliente;
						do {// OPERAÇÕES DOS CLIENTES

							System.out.print(
									"\n\t-----OPERAÇÕES CLIENTE-----\n1. Criar Cliente\n2. Actualizar Cliente\n3. Remover Cliente\n4. Pesquisar Cliente\n5. Ver todos os clientes\n6. Ver conta Correne do Cliente\n0. SAIR E SALVAR ALTERAÇÕES\n>>> ");
							opcaoCliente = ler.nextInt();
							switch (opcaoCliente) {
							case 0:
								boolean gravou = opVitais.gravarObjecto(clientes, caminhoClientes);
								break;
							case 1:
								// 1-INSERIR CLIENTE
								Vector compras = new Vector();// Vector vazio com compras do Cliente novo
								// GERAÇÃO DE ID
								int codigo = opCliente.geracaoID(clientes);
								System.out.println("BI DO CLIENTE:");
								String bi = ler.next().toUpperCase().replace(" ", "");
								// VERIFICAÇÃO DE BIS DUPLICADOS
								ler.nextLine();
								System.out.println("Nome do Cliente:");
								String nome = ler.nextLine().toUpperCase();
								// ler.nextLine();
								System.out.println("Número de telemóvel Cliente");
								String numeroTel = "+" + ler.nextLine().replace(" ", "");
								;
								System.out.println("E-mail");
								String email = "+" + ler.next().replace(" ", "");
								;
								ler.nextLine();
								Cliente cl = new Cliente(cal, codigo, bi, nome, numeroTel, email, compras);
								opCliente.adicionarCliente(clientes, cl);
								break;
							case 2:
								// 2 - Actualizar dados do Cliente
								System.out.println("Por-favor insira o ID do cliente que pretende editar os dados");
								int identi = ler.nextInt();
								opCliente.editarDadoCliente(clientes, identi);
								break;
							case 3:
								// 3 - Remover Cliente
								System.out.println("Digite o ID do cliente que pretende apagar");
								int identificacao = ler.nextInt();
								opCliente.apagarCliente(clientes, identificacao);
								break;
							case 4:
								// Pesquisar Cliente específico
								System.out.println("Digite o ID do cliente que pretende ver");
								int iD = ler.nextInt();
								int index = opCliente.procuraID(clientes, iD);
								if (index != -1) {
									System.out.println(((Cliente) clientes.get(index)).toString());
								} else {
									System.out.println("Esse ID não existe");
								}
								break;
							case 5:
								// Ver todos os clientes
								opCliente.imprimirTodos(clientes);
								break;
							case 6:
								// Ver conta corrente do Cliente (Tudo que já comprou em valores)
								System.out.println("Insira o código de identificação do cliente:");
								int codigoCl = ler.nextInt();
								//int getCode = opCliente.procuraID(clientes, codigoCl);

								opCliente.verContaCorrente(clientes, codigoCl);/// saiu

								break;
							default:
								break;
							}
						} while (opcaoCliente != 0);// FIM DAS OPERAÇÕES DO CLIENTE

						break;// BREAK PARA OPERAÇÕES DO CLIENTE

					case 2:// OPERAÇÕES PARA OS PRODUTOS
						int opcaoProduto;
						do {
							System.out.println(
									"\n\t-----OPERAÇÕES PRODUTO-----\n1. Encomendar produto\n2. Actualizar Produto\n3. Remover Produto\n4. Pesquisar Produto\n5. Emitir Relatórios do Stock\n6. Ver todos os produtos\n0. SAIR E SALVAR ALTERAÇÕES\n>>>");
							opcaoProduto = ler.nextInt();
							switch (opcaoProduto) {
							case 0:

								boolean gravou = opVitais.gravarObjecto(stock, caminhoProduto);

								break;
							case 1:
								// Adicionar produtos no Stock
								// !AO ENCOMENDAR O PRODUTO PODE DEVE/PODE ESCOLHER A QUANTIDADE!
								int codigo = armazem.geracaoID(stock);
								System.out.println("Quantidade da encomenda: ");
								int qtd = ler.nextInt();
								ler.nextLine();

								System.out.println("Preço do produto: ");
								double preco = ler.nextDouble();
								ler.nextLine();

								System.out.println("Nome do produto que pretende encomendar: ");
								String nomeProduto = ler.nextLine().toUpperCase();

								Produto prod = new Produto(codigo, nomeProduto, qtd, preco);
								armazem.adicionarNovoProduto(stock, prod);
								break;
							case 2:
								// 2 - Actualizar dados do Produto
								System.out.println("ID do produto que pretende actualizar:");
								id = ler.nextInt();
								armazem.editarDadoProduto(stock, id);
								break;
							case 3:
								// 3 - Remover Produto
								System.out.println("ID do produto que pretende remover:");
								id = ler.nextInt();
								armazem.removerProduto(stock, id);
								break;
							case 4:
								// Pesquisar Produto
								System.out.println("ID do produto que pretende pesquisar: ");
								id = ler.nextInt();
								int indice = armazem.procurarCodigo(stock, id);
								if (indice != -1) {
									System.out.println(((Produto) stock.get(indice)).toString());
								} else {
									System.out.println("Produto inexistente");
								}

								break;
							case 5:
								// Emitir Relatórios do Stock (produtos abaixo de 5 unidades e produtos mais
								// vendidos)
								System.out.println("OS PRODUTOS ABAIXO DE 5 UNIDADES SÃO:");
								armazem.abaixoDe5(stock);

								System.out
										.println("\nListagem de quantos produtos mais vendidos(EM ORDEM CRESCENTE): ");
								armazem.maisVendidos(stock);
								break;
							case 6:
								armazem.imprimirTodos(stock);
								break;
							default:
								System.out.println("OPÇÃO INVÁLIDA! TENTE DE NOVO");
								break;
							}
						} while (opcaoProduto != 0);// FIM DA OPERAÇÕES DE PRODUTOS

						break;
					case 3:// VENDAS IGUALAR TEMPORARIO COM O QUE ESTÁ FORA
							// PIV EVERY VENDA
						for (int i = 0; i < clientes.size(); i++) {
							for (int j = 0; j < ((Cliente) clientes.get(i)).getCompras().size(); j++) {
//								for (int k = 0; k < (Compra) ((Cliente)clientes.get(j)).getCompras().get(j); k++) {
//									System.out.println("");
//								}
							}

						}

						break;
					}
				} while (opcoes != 0);
				break;
			case 0:

				System.out.println("VOLTE SEMPRE");
				break;
			}

		} while (operacao != 0);// FIM DA TELA PRINCIPAL

	}

}
