import javax.swing.JOptionPane;

public class ContaEspecial extends Conta {
	
	
	double limite;

	public ContaEspecial(int numero) {
		if(this.quantidadedaconta < 3)
		{
		this.numerodaconta = numero;
		this.saldo = 0;
		this.limite = 0;
		this.limite = 0 ;
		this.quantidadedaconta = this.quantidadedaconta + 1;
		this.tipodeconta=2;
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Essa conta nao pode ser criada devido a quantidade excedida de numero de contas");

		}

	}
	
	public void setSacar(int valorsacado)
	{
			if(valorsacado > (this.saldo + this.limite))
			{
				System.out.print("Voc� n�o pode fazer essa opera��o!");
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
}
