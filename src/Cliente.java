
public class Cliente extends Pessoas {
	String senha;
	int quantidadedecontas = 0;
	Gerente SeuGerente;
	Conta conta[] = new Conta[5];
	
			
	public Cliente(String nome,String senha,Gerente Gerente) {
		super(nome);
		this.senha = senha;
		this.SeuGerente = Gerente;
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
