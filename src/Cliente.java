import javax.swing.JOptionPane;

public class Cliente extends Pessoas {
	String senha;
	int quantidadedecontasSimples ;
	int quantidadedecontasEspecial ;
	int quantidadedecontasPoupanca ;
	Gerente SeuGerente;
	Conta conta[] = new Conta[5];
	
			
	public Cliente(String nome,String senha,Gerente Gerente) {
		super(nome);
		this.senha = senha;
		this.SeuGerente = Gerente;
		this.quantidadedecontasEspecial = 0;
		this.quantidadedecontasPoupanca = 0;
		this.quantidadedecontasSimples = 0;
	}
	
	
	public void CriarContaSimples() {
		if(quantidadedecontasSimples<1)
		{
		this.conta[quantidadedecontasSimples] = new ContaSimples(0);
		this.quantidadedecontasSimples = this.quantidadedecontasSimples + 1;
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Voce não pode criar mais contas desse tipo");
		}
	}
	
	
	public void CriarContaEspecial() {
		if(quantidadedecontasEspecial<2)
		{
			this.conta[quantidadedecontasEspecial] = new ContaEspecial(0);
			this.quantidadedecontasEspecial = this.quantidadedecontasEspecial + 1;

		}
		else
		{
			JOptionPane.showMessageDialog(null,"Voce não pode criar mais contas desse tipo");
		}
		}


	public void CriarContaPoupanca() {
		if(quantidadedecontasPoupanca<=1)
		{
		this.conta[quantidadedecontasPoupanca] = new ContaPoupanca(0);
		this.quantidadedecontasPoupanca = this.quantidadedecontasPoupanca + 1;

		}
		else
		{
			JOptionPane.showMessageDialog(null,"Voce não pode criar mais contas desse tipo");
		}
	}

}
