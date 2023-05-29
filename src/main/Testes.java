//package main;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Vector;
//
//public class Testes {
//
//	public static void main(String[] args) {
//		String caminho = "Produtos\\caminho.txt";
//		Vector pessoas = new Vector();
//		Pessoas p = new Pessoas(1, "Mauro");
//		pessoas.add(new Pessoas(1, "Mauro"));
//		pessoas.add(new Pessoas(2, "Milton"));
//		pessoas.add(new Pessoas(3, "Shelton"));
//		OperacoesVitais opVitais = new OperacoesVitais();
//		File file = new File("Produtos\\caminho.txt");
//		System.out.println(file.length());
//		Vector obj;
//		if (file.length() != 0) {
//			obj = (Vector) opVitais.recuperarObjecto(caminho);
//			for (int i = 0; i < obj.size(); i++) {
//				System.out.println(((Pessoas) obj.get(i)).nome);
//			}
//		}
//		boolean gravou = opVitais.gravarObjecto(pessoas, caminho);
//		obj = (Vector) opVitais.recuperarObjecto(caminho);
//		// Vector obj=(Vector)opVitais.recuperarObjecto(caminho);
//
//		for (int i = 0; i < obj.size(); i++) {
//			System.out.println("-" + ((Pessoas) obj.get(i)).nome);
//		}
//		System.out.println(((Pessoas) obj.get(0)).id);
//	}
//
//}
