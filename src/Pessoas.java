import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Pessoas {
	String nomedapessoa;
	String senha;
	public Pessoas(String nome,String senhadocliente) {
		// TODO Auto-generated constructor stub
		
		this.nomedapessoa = nome;
		this.senha = senhadocliente;
		
		
	}
	
	public void AlterarSenha(String novasenha){
		
		this.senha = novasenha;
		
	}
	public void SalvarPessoas(Gerente gerente[])
	{
		int i =0;
		int j = 0;
		FileWriter fw;
		try {
			fw = new FileWriter("BancoDeUsuarios.txt");
			PrintWriter pw = new PrintWriter(fw);
			while(gerente[j] != null)
			{
				pw.println("Nome: "+this.nomedapessoa);
				pw.println("Senha: "+this.senha);
				pw.println("Clientes: ");
				i=0;
				while(gerente[j].seuCliente[i] != null)
				{
					pw.println("Nome: "+gerente[j].seuCliente[i].nomedapessoa);
					pw.println("Senha: "+gerente[j].seuCliente[i].senha);
					i++;
				}
				j++;
			}
			pw.flush();
			pw.close();
			fw.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
