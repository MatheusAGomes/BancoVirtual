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
	
	
	public void CriarContaSimples(int numerodaconta) {
		if(quantidadedecontasSimples<1)
		{
		this.conta[quantidadedecontasSimples] = new ContaSimples(numerodaconta);
		this.quantidadedecontasSimples = this.quantidadedecontasSimples + 1;
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Voce não pode criar mais contas desse tipo");
		}
	}
	
	
	public void CriarContaEspecial(int numerodaconta) {
		if(quantidadedecontasEspecial<2)
		{
			this.conta[quantidadedecontasEspecial] = new ContaEspecial(numerodaconta);
			this.quantidadedecontasEspecial = this.quantidadedecontasEspecial + 1;

		}
		else
		{
			JOptionPane.showMessageDialog(null,"Voce não pode criar mais contas desse tipo");
		}
		}


	public void CriarContaPoupanca(int numerodaconta) {
		if(quantidadedecontasPoupanca<=1)
		{
		this.conta[quantidadedecontasPoupanca] = new ContaPoupanca(numerodaconta);
		this.quantidadedecontasPoupanca = this.quantidadedecontasPoupanca + 1;

		}
		else
		{
			JOptionPane.showMessageDialog(null,"Voce não pode criar mais contas desse tipo");
		}
	}
	public int AcharIndice(String numero,Cliente cliente){
		int i=0;
		int valorencontrado=0;
		int NumeroaSerEncontrado = Integer.valueOf(numero);
		while(cliente.conta[i] != null)
		{
			
			int NumeroTestado  = cliente.conta[i].numerodaconta;
			
			if(NumeroTestado == NumeroaSerEncontrado)
			{
					valorencontrado = i;
			
			
			}
			i++;
		}
		return valorencontrado;
	}
	public double TotalSoma()
	{
		double valortotal = 0;
		int i = 0;
		
		while(this.conta[i] != null)
		{
			
			valortotal = this.conta[i].saldo + valortotal;
			i++;
			
		}
		return valortotal;
	}
	
	

}
