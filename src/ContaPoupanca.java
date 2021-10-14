import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta {
	
	double valoraplicado;

	public ContaPoupanca(int numero) {
		// TODO Auto-generated constructor stub
		if(this.quantidadedaconta < 2)
		{
		this.numerodaconta = numero;
		this.saldo = 0;
		this.valoraplicado = 0;
		this.limite = 0 ;
		this.quantidadedaconta = this.quantidadedaconta + 1;
		}
		else
		{
			
			JOptionPane.showMessageDialog(null,"Essa conta nao pode ser criada devido a quantidade excedida de numero de contas");
			
		}

	}
	
	public void setSacar(int valorsacado)
	{
			if(valorsacado > (this.saldo))
			{
				System.out.print("Você não pode fazer essa operação!");
			}
			else
			{
				this.saldo = this.saldo - valorsacado;
			}
	}	
	public void Depositar(int valorDepositado)
	{
		this.saldo = this.saldo + valorDepositado;
	}
	
	public void Aplicacao(double valoraaplicar,double valordojuros){
		
		
		if(valoraaplicar > (this.saldo))
		{
			System.out.print("Você não pode fazer essa operação!");
		}
		else
		{
			this.saldo = this.saldo - valoraaplicar;		
			this.valoraplicado = this.valoraplicado + valoraaplicar;
			//linha do valor do investimento
			this.valoraplicado = this.valoraplicado +((this.valoraplicado * valordojuros)/100);
			System.out.print("O valor do re");

		}
	
		
		
		
	}

}
