import javax.swing.JOptionPane;

public class ContaSimples extends Conta{

	
	public ContaSimples(int numero) {
		if(this.quantidadedaconta < 1)
		{
		this.numerodaconta = numero;
		this.saldo = 0;
		this.tipodaconta = 1 ;
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
	
}
