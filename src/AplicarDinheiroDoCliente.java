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

public class AplicarDinheiroDoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox_1;

	public AplicarDinheiroDoCliente(int indice, Gerente gerente[]) {
		int i = 0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do correntista");
		lblNewLabel.setBounds(24, 28, 111, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(130, 24, 111, 22);
		contentPane.add(comboBox);
		while(gerente[indice].seuCliente[i] != null) {
			comboBox.addItem(gerente[indice].seuCliente[i].nomedapessoa);
			i++;
			}
		
		JLabel lblNewLabel_1 = new JLabel("Conta");
		lblNewLabel_1.setBounds(24, 63, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(63, 59, 301, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade");
		lblNewLabel_2.setBounds(24, 96, 308, 14);
		contentPane.add(lblNewLabel_2);
		
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
		textField.setBounds(95, 93, 269, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				AplicarDinheiro(comboBox.getSelectedItem().toString(),comboBox_1,gerente[indice],Double.valueOf(textField.getText()));
				setVisible(false);
				new AreaLogadaGerente(gerente,indice).setVisible(true);
				}
				catch (Exception d) {
					JOptionPane.showMessageDialog(null,"Há campos não preenchidos");
				}
				}
		});
		btnAplicar.setBounds(20, 121, 344, 23);
		contentPane.add(btnAplicar);
		JButton btnMostrarContas = new JButton("Mostrar contas");
		btnMostrarContas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_1.removeAllItems();
				MostrarContas((comboBox.getSelectedItem().toString()),comboBox_1,gerente[indice]);
				
			}
		});
		btnMostrarContas.setBounds(251, 24, 113, 23);
		contentPane.add(btnMostrarContas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				AreaLogadaGerente jvoltar = new AreaLogadaGerente(gerente,indice);
				jvoltar.setVisible(true);
				
			}
		});
		btnVoltar.setBounds(20, 155, 344, 23);
		contentPane.add(btnVoltar);
	}
	public void MostrarContas(String nomedocorrentista,JComboBox comboBox,Gerente gerente){
		
		int indiceDoCliente = gerente.AcharIndicePeloNome(nomedocorrentista, gerente);
		int i = 0;
		
		while(gerente.seuCliente[indiceDoCliente].conta[i] != null) {
			comboBox.addItem(gerente.seuCliente[indiceDoCliente].conta[i].numerodaconta);
			i++;
			}
	}
	public void AplicarDinheiro(String nomedocorrentista,JComboBox comboBox,Gerente gerente,Double valor)
	{
		int indiceDoCliente = gerente.AcharIndicePeloNome(nomedocorrentista, gerente);
		int i = 0;
		if(comboBox_1.getSelectedItem() == null)
		{
			JOptionPane.showMessageDialog(null, "Este cliente não contém conta aberta");
		}
		else {
			while(gerente.seuCliente[indiceDoCliente].conta[i] != null) {
				if(gerente.seuCliente[indiceDoCliente].conta[i].numerodaconta == Integer.valueOf(comboBox.getSelectedItem().toString()) ) {
					gerente.seuCliente[indiceDoCliente].conta[i].Aplicar(valor,gerente.seuCliente[indiceDoCliente]);
					JOptionPane.showMessageDialog(null,"Valor aplicada !");
				}
			i++;
			}
		}
	}
}
