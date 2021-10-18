import javax.swing.JOptionPane;

public class Conta {
	public int numerodaconta;
	public double saldo;
	public int quantidadedaconta = 0;
	String[] Movimentações = new String[20];
	int quantidadedemovimentacoes=0;
	double limite;
	int tipodeconta;
	double taxa;
	
	
	
	public void Movimentacoes(Cliente cliente,double valor,int somaousub){
		
		if(somaousub == 1)
		{
		this.Movimentações[this.quantidadedemovimentacoes] = "+"+valor;
		}
		else
		{
		this.Movimentações[this.quantidadedemovimentacoes] = "-"+valor;
		}
		cliente.quantidadedeacoes ++;
		this.quantidadedemovimentacoes++;
	}
	public void Aplicar(Double valor,Cliente cliente)
	{
		this.saldo = this.saldo + valor;
		this.Movimentacoes(cliente,valor,1);
	}
	public void Sacar(Double valor,Cliente cliente)
	{
		if(((this.saldo+this.limite) - valor)>=0) {
		this.saldo = this.saldo - valor;
		this.Movimentacoes(cliente,valor,2);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Voce nao pode efetuar essa operacao devido ao seu limite");
		}
	}
	
		
	

}
