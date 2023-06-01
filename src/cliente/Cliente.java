package cliente;

import java.io.Serializable; // //Importação para gravar no ficheiro de objectos
import java.text.DateFormat; //Para me dar data actual do computador
import java.text.SimpleDateFormat; //Para me dar data actual do computador
import java.util.Calendar; //Para me dar data actual do computador
import java.util.Vector; // Importação do vector

import carrinho.Carrinho; // Importação do carrinho

public class Cliente implements Serializable {

	private int id;
	private String nome, bi, email;
	private String numeroTel;
	private Vector compras = new Vector(); 
	/* Compras = Carrinho, é um vector que adiciona o objecto carrinho 
	 *  O carrinho tem produtos que o cliente adiciona e/ou remove
	 * Ao acabar a conta ele carrega todo o carrinho
	*/

	private Calendar data_Criacao;
	public Cliente(Calendar data_Criacao, int id, String bi, String nome, String numeroTel, String email,
			Vector compras) {
		this.id = id;
		this.bi = bi;
		this.numeroTel = numeroTel;
		this.email = email;
		this.data_Criacao = data_Criacao;
		this.nome = nome;
		this.compras = compras;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getData_Criacao() {
		return data_Criacao;
	}

	public void setData_Criacao(Calendar data_Criacao) {
		this.data_Criacao = data_Criacao;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getBi() {
		return bi;
	}

	public void setBi(String bi) {
		this.bi = bi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Vector getCompras() {
		return compras;
	}

	public void setCompras(Vector compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {//Não precisa de explicação...
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return "Cliente [CRIADO EM: "+dateFormat.format(data_Criacao.getTime())+"\t | ID=" + id + "\t | Nome=" + nome + "\t | BI=" + bi + "\t | E-mail=" + email + "\t | Telemóvel="
				+ numeroTel +"]";
	}
	public String curtoString() {//Uma impressão que só me dá o id e o nome
		return "\n\n------ID:"+id+"\tNome: "+nome;
	}

}
