import javax.swing.JOptionPane;

public class ContaEspecial extends Conta {
	
	
	double limite;

	public ContaEspecial(int numero) {
		if(this.quantidadedaconta < 3)
		{
		this.numerodaconta = numero;
		//this.limite = limitedogerente;
		this.saldo = 0;
		this.limite = 0;
		this.tipodaconta = 2 ;
		this.quantidadedaconta = this.quantidadedaconta + 1;
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
}
