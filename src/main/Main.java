package main;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Vector;

import cliente.Cliente;

import java.io.FileWriter;   // Import the FileWriter class
public class Main {

	public static void main(String[] args) {
		
		
		
		Cliente cliente=new Cliente();
		Vector listaClientes=new Vector();
		cliente.setId(21312);
		listaClientes.add(cliente.getId());
		//Criação do ficheiro
		
		//Gravação da lista de Clientes
		//Recuperação da lista de Clientes
		
		//
		 String listagem="";
		 for (int i = 0; i < listaClientes.size(); i++) {
			listagem+=(listaClientes.get(i)).toString()+"\n------------------------------";
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
		    }
	}

}
