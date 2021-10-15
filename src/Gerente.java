
public class Gerente extends Pessoas {
	int quantidadedeclientes;
	Cliente seuCliente[] = new Cliente[5];

	public Gerente(String nome,String senha) {
		super(nome,senha);
		this.quantidadedeclientes = 0;
	}
	
	public void AgregarCliente(Cliente novoCliente)
	{
		this.seuCliente[quantidadedeclientes] = novoCliente;
		this.quantidadedeclientes = this.quantidadedeclientes + 1;
	}
	
	public void AlterarSenha(String novaSenha)
	{
		
		
		this.senha = novaSenha;
	}
	

}
