import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
			
			String NomeTestado  = (gerente.seuCliente[i].nomedapessoa);
			
			if(NomeTestado.equals(NomeaSerEncontrado))
			{
					valorencontrado = i;
			
			
			}
			i++;
		}
		return valorencontrado;
	}
	public void Salvar(Gerente gerente[])
	{
		int i =0;
		FileWriter fw;
		FileWriter bc;

		try {
				fw = new FileWriter("BancoDeGerente.txt");
				PrintWriter pw = new PrintWriter(fw);
				while(gerente[i] != null)
				{
					
					pw.print(gerente[i].login+","+gerente[i].senha+"\n");
					i++;
				}
				pw.flush();
				pw.close();
				fw.close();
			

		} 
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		i = 0;
		int j = 0;
		
		try {
			bc = new FileWriter("BancoDeClientes.txt");
			PrintWriter pw = new PrintWriter(bc);
			while(gerente[i] != null)
			{
				j = 0 ;
					while(gerente[i].seuCliente[j] != null)
					{
						System.out.print(gerente[i].seuCliente[j].nomedapessoa);
						pw.print(gerente[i].seuCliente[j].login+","+gerente[i].seuCliente[j].nomedapessoa+","+gerente[i].seuCliente[j].senha+","+i+"\n");
						j++;
					}
				i++;
			}
			pw.flush();
			pw.close();
			bc.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
	}
	


	
	
	
	

}
