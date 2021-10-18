import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransferenciasEntreClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;


	public TransferenciasEntreClientes(int indice, Gerente gerente[]) {
		int i =0;
		int j = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(10, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Conta");
		lblNewLabel_1.setBounds(10, 50, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 106, 368, 23);
		contentPane.add(btnVoltar);
		
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 140, 368, 91);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente");
		lblNewLabel_2.setBounds(0, 4, 46, 14);
		panel.add(lblNewLabel_2);
		
		
		
		JComboBox comboBoxConta2 = new JComboBox();
		comboBoxConta2.setBounds(56, 35, 312, 22);
		panel.add(comboBoxConta2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Conta");
		lblNewLabel_1_1.setBounds(0, 39, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		
		
		
		
		
		
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(411, 11, 368, 91);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Valor");
		lblNewLabel_3.setBounds(10, 11, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		txtValor = new JTextField();
		txtValor.setBounds(66, 8, 292, 20);
		panel_1.add(txtValor);
		txtValor.setColumns(10);
		
		
		
		JComboBox comboBoxConta1 = new JComboBox();
		comboBoxConta1.setBounds(66, 46, 312, 22);
		contentPane.add(comboBoxConta1);
		
		JComboBox comboBoxCliente1 = new JComboBox();
		comboBoxCliente1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxConta1.removeAllItems();
				MostrarContas((comboBoxCliente1.getSelectedItem().toString()),comboBoxConta1,gerente[indice]);
			}
		});
		comboBoxCliente1.setBounds(66, 11, 312, 22);
		contentPane.add(comboBoxCliente1);
		while(gerente[indice].seuCliente[i] != null) {
			System.out.print(gerente[indice].seuCliente[i].nomedapessoa);
			comboBoxCliente1.addItem(gerente[indice].seuCliente[i].nomedapessoa);
			i++;
			}
		
		
		JComboBox comboBoxCliente2 = new JComboBox();
		comboBoxCliente2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxConta2.removeAllItems();
				MostrarContasComRestricoes((comboBoxCliente2.getSelectedItem().toString()),comboBoxConta2,gerente[indice],comboBoxConta1.getSelectedItem().toString());
			}
		});
		comboBoxCliente2.setBounds(56, 0, 312, 22);
		panel.add(comboBoxCliente2);
		comboBoxCliente2.addItem(" ");
		while(gerente[indice].seuCliente[j] != null) {
		//	System.out.print(gerente[indice].seuCliente[j].nomedapessoa);
			comboBoxCliente2.addItem(gerente[indice].seuCliente[j].nomedapessoa);
			j++;
			}
		
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxConta2.removeAllItems();
				setBounds(100, 100, 404, 314);
				btnVoltar.setBounds(10, 241, 368, 23);
				panel.setVisible(true);
				comboBoxCliente1.setEnabled(false);
				comboBoxConta1.setEnabled(false);
				
				
				
			}
		});
		btnSelecionar.setBounds(10, 79, 368, 23);
		contentPane.add(btnSelecionar);
		
		
		JButton btnSelecionar_1 = new JButton("Selecionar");
		btnSelecionar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBounds(100, 100, 799, 300);
				panel_1.setVisible(true);
				comboBoxCliente2.setEnabled(false);
				comboBoxConta2.setEnabled(false);
				

			}
		});
		btnSelecionar_1.setBounds(0, 68, 368, 23);
		panel.add(btnSelecionar_1);
		
		
		JButton btnTrasnferencias = new JButton("Transferir");
		btnTrasnferencias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//pegar a conta dos dois clientes 
				//primeiro cliente e conta
				int indicedocliente = gerente[indice].AcharIndicePeloNome(comboBoxCliente1.getSelectedItem().toString(),gerente[indice]);
				int indicedaconta = gerente[indice].seuCliente[indicedocliente].AcharIndice(comboBoxConta1.getSelectedItem().toString(),gerente[indice].seuCliente[indicedocliente]);
				//segundo cliente
				int idicedocliente2 = gerente[indice].AcharIndicePeloNome(comboBoxCliente2.getSelectedItem().toString(),gerente[indice]);
				int indicedaconta2 = gerente[indice].seuCliente[idicedocliente2].AcharIndice(comboBoxConta2.getSelectedItem().toString(),gerente[indice].seuCliente[idicedocliente2]);

				Transferir(gerente[indice].seuCliente[indicedocliente],gerente[indice].seuCliente[indicedocliente].conta[indicedaconta],gerente[indice].seuCliente[idicedocliente2],gerente[indice].seuCliente[idicedocliente2].conta[indicedaconta2],Double.valueOf(txtValor.getText().toString()));
				setVisible(false);
				new AreaLogadaGerente(gerente,indice).setVisible(true);;
			}
		});
		btnTrasnferencias.setBounds(10, 36, 348, 23);
		panel_1.add(btnTrasnferencias);
		
		
		
		
		
		panel.setVisible(false);
		panel_1.setVisible(false);
		setBounds(100, 100, 404, 177);
		
		
		
	}

	public void Transferir(Cliente transferidor, Conta contadotransferidor,Cliente receptor,Conta contadorecptor,double valoratransferir)
	{
		try {
		contadotransferidor.Sacar(valoratransferir,transferidor);
		contadorecptor.Aplicar(valoratransferir,receptor);
		JOptionPane.showMessageDialog(null,"Transferencia efetuada com sucesso");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
public void MostrarContas(String nomedocorrentista,JComboBox comboBox,Gerente gerente){
	
		comboBox.removeAllItems();
		int indiceDoCliente = gerente.AcharIndicePeloNome(nomedocorrentista, gerente);
		int i = 0;
		
		while(gerente.seuCliente[indiceDoCliente].conta[i] != null) {
			comboBox.addItem(gerente.seuCliente[indiceDoCliente].conta[i].numerodaconta);
			i++;
			}
	}

public void MostrarContasComRestricoes(String nomedocorrentista,JComboBox comboBox,Gerente gerente,String Primeirovalor){
	
	int indiceDoCliente = gerente.AcharIndicePeloNome(nomedocorrentista, gerente);
	int i = 0;
	int ValorValido = Integer.valueOf(Primeirovalor);
	
	try {
	
	while(gerente.seuCliente[indiceDoCliente].conta[i] != null) {
		System.out.print("\n"+gerente.seuCliente[indiceDoCliente].conta[i].numerodaconta+""+ValorValido);
		if(gerente.seuCliente[indiceDoCliente].conta[i].numerodaconta != ValorValido)
		{
		comboBox.addItem(gerente.seuCliente[indiceDoCliente].conta[i].numerodaconta);
		}
		i++;
		}
	}
	catch(Exception e)
	{
		
	}
}
	
}

