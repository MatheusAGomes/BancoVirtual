import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SacarDinheiro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public SacarDinheiro(int indicedocliente,Gerente gerente[],int indicedogerente) {
		int i = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contas:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 7, 228, 22);
		panel.add(comboBox);
		


		while(gerente[indicedogerente].seuCliente[indicedocliente].conta[i] != null)
		{
			comboBox.addItem(gerente[indicedogerente].seuCliente[indicedocliente].conta[i].numerodaconta);
			
			i++;
		}
		
		JLabel lblNewLabel_1 = new JLabel("Valor do saque");
		lblNewLabel_1.setBounds(10, 48, 97, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = textField.getText();
	            //int l = value.length();
	            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
	            	//textField.setEditable(true);
	               
	            } else {
	            	//textField.setEditable(false);
	            	String texto = textField.getText();
	            	textField.setText(texto.substring(0,texto.length() - 1));
	            	JOptionPane.showMessageDialog(null,"Voce so pode digitar numeros neste campo");
	            	
	            }
			}
		});
		textField.setBounds(117, 45, 177, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indicedaconta = gerente[indicedogerente].seuCliente[indicedocliente].AcharIndice(String.valueOf(comboBox.getSelectedItem()),gerente[indicedogerente].seuCliente[indicedocliente]);
				//System.out.print(cliente[indice].conta[indicedaconta].saldo);
				double valorasacar = Double.valueOf(textField.getText());
				if(((gerente[indicedogerente].seuCliente[indicedocliente].conta[indicedaconta].limite + gerente[indicedogerente].seuCliente[indicedocliente].conta[indicedaconta].saldo)-valorasacar)>=0) {
				
				gerente[indicedogerente].seuCliente[indicedocliente].conta[indicedaconta].Sacar(valorasacar,gerente[indicedogerente].seuCliente[indicedocliente]);
				JOptionPane.showMessageDialog(null,"VALOR SACADO");
				AreaLogadaCliente janeladecliente = new AreaLogadaCliente(indicedocliente,gerente,indicedogerente);
				setVisible(false);
				janeladecliente.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"VALOR NAO SACADO DEVIDO AO LIMITE");
				}
			}
		});
		btnSacar.setBounds(10, 91, 284, 23);
		panel.add(btnSacar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AreaLogadaCliente janeladecliente = new AreaLogadaCliente(indicedocliente,gerente,indicedogerente);
				setVisible(false);
				janeladecliente.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 125, 284, 23);
		panel.add(btnVoltar);
	}
}
