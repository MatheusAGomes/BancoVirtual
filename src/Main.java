import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		
		
		Gerente gerentebasico[] = new Gerente[20];
		String BancoDeClientes = "BancoDeClientes.txt";
		String BancoDeGerentes = "BancoDeGerente.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(BancoDeGerentes)))
		{
			String line = br.readLine();
			while(line != null)
			{
				String[] vetor = line.split(",");
				String nome = vetor[0];
				String senha = vetor[1];
				gerentebasico[i] = new Gerente(nome,senha);
				line = br.readLine();
				i++;
			}
			
		}
		catch(IOException e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(BancoDeClientes)))
		{
			String line = br.readLine();
			
			while(line != null)
			{
				
				String[] vetor = line.split(",");
				String nome = vetor[0];
				System.out.print(nome);
				String senha = vetor[1];
				int indicedogerente = Integer.valueOf(vetor[2]);
				Cliente novoCliente = new Cliente(nome,senha,gerentebasico[indicedogerente]);
				gerentebasico[indicedogerente].AgregarCliente(novoCliente); 
				line = br.readLine();
			
			}
			
		}
		catch(IOException e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		
		//gerentebasico[0] = new Gerente("adm","123");
		Login MenuDeLogin = new Login(gerentebasico);
		MenuDeLogin.setVisible(true);
	}

	

}