import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		
		
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
			br.close();
			
			
		}
		catch(IOException e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		
		try(BufferedReader cr = new BufferedReader(new FileReader(BancoDeClientes)))
		{
			String line = cr.readLine();
			
			while(line != null)
			{
				
				String[] vetor = line.split(",");
				String login = vetor[0];
				String nome = vetor[1];
				String senha = vetor[2];
				int indicedogerente = Integer.valueOf(vetor[3]);
				Cliente novoCliente = new Cliente(login,nome,senha,gerentebasico[indicedogerente]);
				gerentebasico[indicedogerente].AgregarCliente(novoCliente); 
				line = cr.readLine();
			
			}
			cr.close();
			
			
		}
		catch(IOException e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		i = 0;
			/*
		while(gerentebasico[i] != null)
		{
			j=0;
			while(gerentebasico[i].seuCliente[j] != null)
			{
				System.out.print(gerentebasico[i].seuCliente[j].nomedapessoa); 
				j++;
			}
			i++;
		}
		*/
	
		Login MenuDeLogin = new Login(gerentebasico);
		MenuDeLogin.setVisible(true);
	}


	

}