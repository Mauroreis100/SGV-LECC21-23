package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import produto.Produto;

public class OperacoesVitais {

	public int procurarCodigo(Vector lista,int codigo) {
		for (int i = 0; i < lista.size(); i++) {
			if( ((Produto)lista.get(i)).getId() ==codigo) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean gravarObjecto(Object obj, String caminho) {
		File arquivo=new File(caminho);
		if(! arquivo.exists()) {
			try {
				arquivo.createNewFile();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream fileOutput=new FileOutputStream(arquivo);
			ObjectOutputStream objOutput=new ObjectOutputStream(fileOutput);
			objOutput.writeObject(obj);
			objOutput.flush();
			fileOutput.flush();
			objOutput.close();
			fileOutput.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	public static Object recuperarObjecto(String caminho) {
		File arquivo=new File(caminho);
		try {
			FileInputStream fileInput=new FileInputStream(arquivo);
			ObjectInputStream objInput=new ObjectInputStream(fileInput);
			Object retorno=objInput.readObject();
			objInput.close();
			fileInput.close();
			return retorno;
			}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
