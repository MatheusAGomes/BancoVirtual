import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Pessoas {
	String login;
	String nomedapessoa;
	String senha;
	public Pessoas(String nome,String senhadocliente) {
		// TODO Auto-generated constructor stub
		
		this.login = nome;
		this.senha = senhadocliente;
		
		
	}
	
	public void AlterarSenha(String novasenha){
		
		this.senha = novasenha;
		
	}
	public void setNome(String Nome)
	{
		this.nomedapessoa= Nome;
	}
	public String criptografia(String Senhacriptografada){
		
		String senha = Senhacriptografada;
		
	
			
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
			
			
			byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
			
			StringBuilder sb = new StringBuilder();
			
			
				for(byte b: messageDigest)
				{
				sb.append(String.format("%02X", 0xFF & b));	
				}
				
				return sb.toString();
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return senha;
			
			
		
		
		
		
		
	}
	
	
	
	

}
