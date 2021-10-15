import javax.swing.JOptionPane;

public class Cliente extends Pessoas {
	int quantidadedecontasSimples ;
	int quantidadedecontasEspecial ;
	int quantidadedecontasPoupanca ;
	int quantidadedeconta;
	int quantidadedeacoes;
	Conta conta[] = new Conta[5];
	
			
	public Cliente(String nome,String senha,Gerente Gerente) {
		super(nome,senha);
		this.quantidadedecontasEspecial = 0;
		this.quantidadedecontasPoupanca = 0;
		this.quantidadedecontasSimples = 0;
		this.quantidadedeconta = 0;
	}
	
	
	public void CriarContaSimples(int numerodaconta) {
		if(quantidadedecontasSimples<1)
		{
		this.conta[quantidadedeconta] = new ContaSimples(numerodaconta);
		this.quantidadedecontasSimples = this.quantidadedecontasSimples + 1;
		this.quantidadedeconta = this.quantidadedeconta + 1;
		 JOptionPane.showMessageDialog(null,"CONTA CRIADA COM SUCESSO !");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Voce não pode criar mais contas desse tipo");
		}
	}
	
	
	public void CriarContaEspecial(int numerodaconta) {
		if(quantidadedecontasEspecial<2)
		{
			this.conta[quantidadedeconta] = new ContaEspecial(numerodaconta);
			this.quantidadedecontasEspecial = this.quantidadedecontasEspecial + 1;
			this.quantidadedeconta = this.quantidadedeconta + 1;

			 JOptionPane.showMessageDialog(null,"CONTA CRIADA COM SUCESSO !");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Voce não pode criar mais contas desse tipo");
		}
		}


	public void CriarContaPoupanca(int numerodaconta) {
		if(quantidadedecontasPoupanca<=1)
		{
		this.conta[quantidadedeconta] = new ContaPoupanca(numerodaconta);
		this.quantidadedecontasPoupanca = this.quantidadedecontasPoupanca + 1;
		this.quantidadedeconta = this.quantidadedeconta + 1;

		 JOptionPane.showMessageDialog(null,"CONTA CRIADA COM SUCESSO !");
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
	public void AlterarSenha(String novaSenha)
	{
		this.senha = novaSenha;
	}
	
	
	

}
