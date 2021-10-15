import java.awt.BorderLayout;
import java.util.Random;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AbrirConta extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitular;
	private JTextField txtNumeroDaConta;
	private JComboBox ComboTipoConta;
	
	


	public AbrirConta(Cliente cliente[],int indice,Gerente gerente[]) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do titular da conta");
		lblNewLabel.setBounds(27, 22, 126, 14);
		panel.add(lblNewLabel);
		
		txtTitular = new JTextField();
		txtTitular.setText(cliente[indice].nomedapessoa);
		txtTitular.setEditable(false);
		txtTitular.setBounds(163, 19, 201, 20);
		panel.add(txtTitular);
		txtTitular.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Numero da conta");
		lblNewLabel_1.setBounds(27, 62, 126, 14);
		panel.add(lblNewLabel_1);
		
		txtNumeroDaConta = new JTextField();
		txtNumeroDaConta.setEditable(false);
		txtNumeroDaConta.setBounds(163, 59, 201, 20);
		panel.add(txtNumeroDaConta);
		txtNumeroDaConta.setColumns(10);
		txtNumeroDaConta.setText(numeroAleatorio());
		
		JLabel lblNewLabel_2 = new JLabel("Tipo da conta");
		lblNewLabel_2.setBounds(27, 100, 126, 14);
		panel.add(lblNewLabel_2);
		
		ComboTipoConta = new JComboBox();
		ComboTipoConta.setBounds(163, 96, 201, 22);
		panel.add(ComboTipoConta);
		ComboTipoConta.addItem(" ");
		ComboTipoConta.addItem("CONTA SIMPLES");
		ComboTipoConta.addItem("CONTA ESPECIAL");
		ComboTipoConta.addItem("CONTA POUPANCA");
		
		JButton btnCriarConta = new JButton("Criar conta");
		btnCriarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CriarConta(cliente,indice,gerente,txtNumeroDaConta.getText());
			}
		});
		btnCriarConta.setBounds(163, 152, 201, 23);
		panel.add(btnCriarConta);
		setVisible(true);
	}
	
	public String numeroAleatorio() {
			Random gerador = new Random();
			return String.valueOf((Math.abs(gerador.nextInt(10000))));
	}
	public void CriarConta(Cliente cliente[],int indice, Gerente gerente[],String NumeroemString) {
		String Opcao = ComboTipoConta.getSelectedItem().toString();
	//	AreaLogadaCliente janelaCliente = new AreaLogadaCliente(cliente,indice,gerente);
		int Numerodaconta = Integer.valueOf(NumeroemString);
		//colocando um em cada para poder atualizar com o valor novo
		
		 switch(Opcao){

	        case "CONTA SIMPLES":
	            cliente[indice].CriarContaSimples(Numerodaconta);
	            this.setVisible(false);
	    		AreaLogadaCliente janelaCliente1 = new AreaLogadaCliente(cliente,indice,gerente);
	            janelaCliente1.setVisible(true);
	            
	            break;

	        case "CONTA ESPECIAL":
	        	cliente[indice].CriarContaEspecial(Numerodaconta);
	        	this.setVisible(false);
	    		AreaLogadaCliente janelaCliente2 = new AreaLogadaCliente(cliente,indice,gerente);
	            janelaCliente2.setVisible(true);
	            break;
	            
	        case "CONTA POUPANCA":
	        	cliente[indice].CriarContaPoupanca(Numerodaconta);
	    		AreaLogadaCliente janelaCliente3 = new AreaLogadaCliente(cliente,indice,gerente);
	        	this.setVisible(false);
	            janelaCliente3.setVisible(true);
	            break;

	        default:
	            JOptionPane.showMessageDialog(null,"Opcao de conta inv�lida");


	    }
		
	}

}