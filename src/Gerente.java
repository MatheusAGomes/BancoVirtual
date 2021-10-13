
public class Gerente extends Pessoas {
	String senha;
	int quantidadedeclientes;
	Cliente seuCliente[] = new Cliente[5];

	public Gerente(String nome,String senha) {
		super(nome);
		this.senha = senha;
		this.quantidadedeclientes = 0;
	}
	
	public void AgregarCliente(Cliente novoCliente)
	{
		this.seuCliente[quantidadedeclientes] = novoCliente;
	}
	

}
