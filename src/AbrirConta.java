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
	
	


	public AbrirConta(Cliente cliente) {
		
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
		txtTitular.setText(cliente.nomedapessoa);
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
		ComboTipoConta.addItem("CONTA POUPANÇA");
		
		JButton btnCriarConta = new JButton("Criar conta");
		btnCriarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CriarConta(cliente,txtNumeroDaConta.getText());
			}
		});
		btnCriarConta.setBounds(163, 152, 201, 23);
		panel.add(btnCriarConta);
	}
	
	public String numeroAleatorio() {
			Random gerador = new Random();
			return String.valueOf((Math.abs(gerador.nextInt(10000))));
	}
	public void CriarConta(Cliente cliente,String NumeroemString) {
		String Opção = ComboTipoConta.getSelectedItem().toString();
		AreaLogadaCliente janelaCliente = new AreaLogadaCliente(cliente);
		int Numerodaconta = Integer.valueOf(NumeroemString);
		
		 switch(Opção){

	        case "CONTA SIMPLES":
	            cliente.CriarContaSimples(Numerodaconta);
	            this.setVisible(false);
	            JOptionPane.showMessageDialog(null,"CONTA CRIADA COM SUCESSO !");
	            janelaCliente.setVisible(true);
	            
	            break;

	        case "CONTA ESPECIAL":
	        	cliente.CriarContaEspecial(Numerodaconta);
	        	this.setVisible(false);
	            JOptionPane.showMessageDialog(null,"CONTA CRIADA COM SUCESSO !");
	            janelaCliente.setVisible(true);
	            break;
	            
	        case "CONTA POUPANÇA":
	        	cliente.CriarContaPoupanca(Numerodaconta);
	        	this.setVisible(false);
	            JOptionPane.showMessageDialog(null,"CONTA CRIADA COM SUCESSO !");
	            janelaCliente.setVisible(true);
	            break;

	        default:
	            JOptionPane.showMessageDialog(null,"Opção de conta inválida");


	    }
		
	}

}
