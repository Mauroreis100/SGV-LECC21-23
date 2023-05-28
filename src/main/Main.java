package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import cliente.Cliente;
import cliente.OperacoesClientes;
import vendas.Vendas;

class ProductTest {
	int id, qtd;
	String nome;

	public ProductTest(int id, int qtd, String nome) {
		this.id = id;
		this.qtd = qtd;
		this.nome = nome;
	}

	public String retornar() {
		return id + "  " + nome;
	}
}
class VendaTest {
	int id;
	String clienteNome;

	public VendaTest(int id,  String clienteNome) {
		this.id = id;
		this.clienteNome = clienteNome;
	}

	public String retornar() {
		return id + "  " + clienteNome;
	}
}

public class Main {

	public static void main(String[] args) {
		System.out.println("C'mon");
	/*	Cliente cliente = new Cliente();
		
		Vector listaClientes = new Vector();
		Vector carrinho=new Vector();
		cliente.setId(21312);
		cliente.setNome("Ana Júlia");
		listaClientes.add(cliente.getId());
		// Criação do ficheiro

		// Gravação da lista de Clientes
		// Recuperação da lista de Clientes
		Cliente clienteTeste=new Cliente(123,"Mauro",855008414,carrinho);
		OperacoesClientes cl=new OperacoesClientes();
		cl.criarCliente(listaClientes, clienteTeste);
		
		Vendas compra=new Vendas(13123,2);
		cl.adicionarCompra(listaClientes, clienteTeste.getId(), compra);
		
		System.out.println(listaClientes.toString());
		
		String listagem = "";
		for (int i = 0; i < listaClientes.size(); i++) {
			listagem += (listaClientes.get(i)).toString() + "\n------------------------------";
		}
		System.out.println(listagem);
		try {
			FileWriter myWriter = new FileWriter(new File("M:\\SGV-LECC21-23\\Cliente\\ClientesDB.txt"));
			myWriter.write(listagem);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}*/
	}

}
