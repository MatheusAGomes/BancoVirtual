
public class Conta {
	public int numerodaconta;
	public String senha;
	public double saldo;
	public int quantidadedaconta = 0;
	String[] Movimenta��es = new String[20];
	int quantidadedemovimentacoes=0;
	double limite;
	
	
	
	public void Movimentacoes(Cliente cliente,double valor,int somaousub){
		
		if(somaousub == 1)
		{
		this.Movimenta��es[this.quantidadedemovimentacoes] = "+"+valor;
		}
		else
		{
		this.Movimenta��es[this.quantidadedemovimentacoes] = "-"+valor;
		}
		cliente.quantidadedeacoes ++;
		this.quantidadedemovimentacoes++;
	}

}
