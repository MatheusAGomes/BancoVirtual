
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

}
