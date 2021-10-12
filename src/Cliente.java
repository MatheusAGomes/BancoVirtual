
public class Cliente extends Pessoas {
	String senha;
	int quantidadedecontas = 0 ;
	Conta conta[] = new Conta[5];
	
			
	public Cliente(String nome,String senha) {
		super(nome);
		this.senha = senha;
	}
	
	
	public void CriarContaSimples() {
		
		this.conta[quantidadedecontas] = new ContaSimples(0);
		
	}
	
	
	public void CriarContaEspecial() {
			
			this.conta[quantidadedecontas] = new ContaEspecial(0);
			
		}


	public void CriarContaPoupanca() {
		
		this.conta[quantidadedecontas] = new ContaEspecial(0);
		
	}

}
