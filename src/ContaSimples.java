import javax.swing.JOptionPane;

public class ContaSimples extends Conta{

	
	public ContaSimples(int numero) {
		if(this.quantidadedaconta < 1)
		{
		this.numerodaconta = numero;
		this.saldo = 0;
		this.limite = 0;
		this.quantidadedaconta = this.quantidadedaconta + 1;
		this.tipodeconta=1;
		}
		else
		{
			
			JOptionPane.showMessageDialog(null,"Essa conta nao pode ser criada devido a quantidade excedida de numero de contas");
			
		}
	}

	
	
}
