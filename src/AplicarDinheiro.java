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

public class AplicarDinheiro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public AplicarDinheiro(Cliente cliente) {
		int i = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 190);
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
		while(cliente.conta[i] != null)
		{
			comboBox.addItem(cliente.conta[i].numerodaconta);
			
			i++;
		}
		
		JLabel lblNewLabel_1 = new JLabel("Valor da aplica\u00E7\u00E3o");
		lblNewLabel_1.setBounds(10, 48, 97, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(117, 45, 177, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Aplicar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double valoraaplicar = Double.valueOf(textField.getText());
				int indicedaconta = cliente.AcharIndice(String.valueOf(comboBox.getSelectedItem()),cliente);
				cliente.conta[indicedaconta].saldo = cliente.conta[indicedaconta].saldo + valoraaplicar;
				JOptionPane.showMessageDialog(null,"VALOR APLICADO");
				AreaLogadaCliente janeladecliente = new AreaLogadaCliente(cliente);
				setVisible(false);
				janeladecliente.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 91, 284, 23);
		panel.add(btnNewButton);
	}
	

}