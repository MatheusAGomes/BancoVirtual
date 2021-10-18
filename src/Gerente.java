
public class Gerente extends Pessoas {
	int quantidadedeclientes;
	int quantidadedegerentes=0;
	Cliente seuCliente[] = new Cliente[5];

	public Gerente(String nome,String senha) {
		super(nome,senha);
		this.quantidadedeclientes = 0;
		this.quantidadedegerentes = this.quantidadedegerentes + 1;
	}
	
	public void AgregarCliente(Cliente novoCliente)
	{
		this.seuCliente[this.quantidadedeclientes] = novoCliente;
		this.quantidadedeclientes = this.quantidadedeclientes + 1;
	}
	
	public void AlterarSenha(String novaSenha)
	{
		this.senha = novaSenha;
	}
	public int AcharIndicePeloNome(String Nome,Gerente gerente){
		int i=0;
		int valorencontrado=0;
		String NomeaSerEncontrado = Nome;
		while(gerente.seuCliente[i] != null)
		{
			
			String NomeTestado  = gerente.seuCliente[i].nomedapessoa;
			
			if(NomeTestado.equals(NomeaSerEncontrado))
			{
					valorencontrado = i;
			
			
			}
			i++;
		}
		return valorencontrado;
	}
	

}
