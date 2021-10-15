import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta {
		double juros;
	
	public ContaPoupanca(int numero) {
		// TODO Auto-generated constructor stub
		if(this.quantidadedaconta < 2)
		{
		this.numerodaconta = numero;
		this.saldo = 0;
		this.limite = 0 ;
		this.quantidadedaconta = this.quantidadedaconta + 1;
		this.tipodeconta = 3;
		this.taxa = 1.57;
		}
		else
		{
			
			JOptionPane.showMessageDialog(null,"Essa conta nao pode ser criada devido a quantidade excedida de numero de contas");
			
		}

	}
	
	
	
	

}
