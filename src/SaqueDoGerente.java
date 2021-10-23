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

public class SaqueDoGerente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox_1;

	public SaqueDoGerente(int indice, Gerente gerente[]) {
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
			System.out.print(gerente[indice].seuCliente[i].nomedapessoa);
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
		lblNewLabel_2.setBounds(24, 96, 340, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(95, 93, 269, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				AplicarDinheiro(comboBox.getSelectedItem().toString(),comboBox_1,gerente[indice],Double.valueOf(textField.getText()));
				new AreaLogadaCliente(indice, gerente, indice);
				}
				catch (Exception d) {
					JOptionPane.showMessageDialog(null,"Há campos não preenchidos");
				
				}
			}
		});
		btnSacar.setBounds(20, 121, 344, 23);
		contentPane.add(btnSacar);
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
				if(((gerente.seuCliente[indiceDoCliente].conta[i].saldo +gerente.seuCliente[indiceDoCliente].conta[i].limite)-valor)>=0 || valor >= 110000 ) {
				gerente.seuCliente[indiceDoCliente].conta[i].Sacar(valor,gerente.seuCliente[indiceDoCliente]);
				JOptionPane.showMessageDialog(null,"Saque efetuado !");
				}
			}
		i++;
		}
		}
	}
}
