
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

}
