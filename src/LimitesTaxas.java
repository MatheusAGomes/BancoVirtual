import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LimitesTaxas extends JFrame {

	private JPanel contentPane;
	private JTextField txtLimiteAtual;
	private JTextField txtLimiteNovo;
	private JTextField txtTaxaAtual;
	private JTextField txtNovaTaxa;

	public LimitesTaxas(Gerente gerente[],int indice) {
		int i = 0 ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contas");
		lblNewLabel.setBounds(20, 58, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		
		JPanel paneLimite = new JPanel();
		paneLimite.setBounds(10, 87, 372, 107);
		contentPane.add(paneLimite);
		paneLimite.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Limite atual");
		lblNewLabel_1.setBounds(10, 11, 237, 14);
		paneLimite.add(lblNewLabel_1);
		
		txtLimiteAtual = new JTextField();
		txtLimiteAtual.setEnabled(false);
		txtLimiteAtual.setBounds(80, 8, 282, 20);
		paneLimite.add(txtLimiteAtual);
		txtLimiteAtual.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Novo Limite");
		lblNewLabel_2.setBounds(10, 39, 247, 14);
		paneLimite.add(lblNewLabel_2);
		
		txtLimiteNovo = new JTextField();
		txtLimiteNovo.setBounds(80, 36, 282, 20);
		paneLimite.add(txtLimiteNovo);
		txtLimiteNovo.setColumns(10);
		
		
		
		
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new AreaLogadaGerente(gerente, indice).setVisible(true);
			}
		});
		btnVoltar.setBounds(293, 46, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_3 = new JLabel("Cliente");
		lblNewLabel_3.setBounds(20, 21, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBoxCliente = new JComboBox();
		comboBoxCliente.setBounds(76, 17, 199, 22);
		contentPane.add(comboBoxCliente);
		while(gerente[indice].seuCliente[i] != null)
		{
			comboBoxCliente.addItem(gerente[indice].seuCliente[i].nomedapessoa);
			
			i++;
		}
		
		
		
		
		
		
		JPanel paneTaxa = new JPanel();
		paneTaxa.setBounds(10, 87, 372, 107);
		contentPane.add(paneTaxa);
		paneTaxa.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Taxa atual");
		lblNewLabel_1_1.setBounds(10, 11, 237, 14);
		paneTaxa.add(lblNewLabel_1_1);
		
		txtTaxaAtual = new JTextField();
		txtTaxaAtual.setColumns(10);
		txtTaxaAtual.setEnabled(false);
		txtTaxaAtual.setBounds(78, 8, 284, 20);
		paneTaxa.add(txtTaxaAtual);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nova Taxa");
		lblNewLabel_2_1.setBounds(10, 39, 247, 14);
		paneTaxa.add(lblNewLabel_2_1);
		
		txtNovaTaxa = new JTextField();
		txtNovaTaxa.setColumns(10);
		txtNovaTaxa.setBounds(78, 36, 284, 20);
		paneTaxa.add(txtNovaTaxa);
		
		
		
		JComboBox comboBoxConta = new JComboBox();
		comboBoxConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 409, 215);
				int indiceDoCliente = gerente[indice].AcharIndicePeloNome(comboBoxCliente.getSelectedItem().toString(), gerente[indice]);
				int indicedaconta = gerente[indice].seuCliente[indiceDoCliente].AcharIndice(comboBoxConta.getSelectedItem().toString(),gerente[indice].seuCliente[indiceDoCliente]);
				txtTaxaAtual.setText(String.valueOf(gerente[indice].seuCliente[indiceDoCliente].conta[indicedaconta].taxa));
				txtLimiteAtual.setText(String.valueOf(gerente[indice].seuCliente[indiceDoCliente].conta[indicedaconta].limite));
				MostarCorreto((comboBoxCliente.getSelectedItem().toString()),comboBoxConta,gerente[indice],paneLimite,paneTaxa);
			}
		});
		comboBoxConta.setBounds(76, 54, 199, 22);
		contentPane.add(comboBoxConta);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxConta.removeAllItems();
				btnSelecionar.setEnabled(false);
				MostrarContas((comboBoxCliente.getSelectedItem().toString()),comboBoxConta,gerente[indice]);
				comboBoxCliente.setEnabled(false);
			//	comboBoxConta.setEnabled(false);
				setBounds(100, 100, 409, 233);
			}
		});
		btnSelecionar.setBounds(293, 17, 89, 23);
		contentPane.add(btnSelecionar);
		
		JButton btnTaxar = new JButton("Setar nova taxa");
		btnTaxar.setBounds(10, 64, 352, 23);
		paneTaxa.add(btnTaxar);
		paneTaxa.setVisible(false);
		btnTaxar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indiceDoCliente = gerente[indice].AcharIndicePeloNome(comboBoxCliente.getSelectedItem().toString(), gerente[indice]);
				int indicedaconta =gerente[indice].seuCliente[indiceDoCliente].AcharIndice(comboBoxConta.getSelectedItem().toString(),gerente[indice].seuCliente[indiceDoCliente]);
				
				
				
					gerente[indice].seuCliente[indiceDoCliente].MudarTaxa(indicedaconta,Double.valueOf(txtNovaTaxa.getText().toString()));
					JOptionPane.showMessageDialog(null,"Mudança de taxa concluida");
					new AreaLogadaGerente(gerente, indice).setVisible(true);
					setVisible(false);
				
			}
		});
		JButton btnLimitar = new JButton("Setar novo limite");
		btnLimitar.setBounds(10, 64, 352, 23);
		paneLimite.add(btnLimitar);
		btnLimitar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indiceDoCliente = gerente[indice].AcharIndicePeloNome(comboBoxCliente.getSelectedItem().toString(), gerente[indice]);
				int indicedaconta =gerente[indice].seuCliente[indiceDoCliente].AcharIndice(comboBoxConta.getSelectedItem().toString(),gerente[indice].seuCliente[indiceDoCliente]);
				
				gerente[indice].seuCliente[indiceDoCliente].MudarLimite(indicedaconta,Double.valueOf(txtLimiteNovo.getText().toString()));
				JOptionPane.showMessageDialog(null,"Mudança de limite concluido");
				new AreaLogadaGerente(gerente, indice).setVisible(true);
				setVisible(false);
			}
		});
		
		paneLimite.setVisible(false);
		paneTaxa.setVisible(false);
		setBounds(100, 100, 409, 120);
		
	}
		public void MostrarContas(String nomedocorrentista,JComboBox comboBox,Gerente gerente){
				
				int indiceDoCliente = gerente.AcharIndicePeloNome(nomedocorrentista, gerente);
				int i = 0;
				
				while(gerente.seuCliente[indiceDoCliente].conta[i] != null) {
					if(gerente.seuCliente[indiceDoCliente].conta[i].tipodeconta != 1) {
					comboBox.addItem(gerente.seuCliente[indiceDoCliente].conta[i].numerodaconta);
					}
					i++;
					
					}
			}
		public void MostarCorreto(String nomedocorrentista,JComboBox comboBox,Gerente gerente,JPanel paneLimite,JPanel paneTaxa)
		{
			int indiceDoCliente = gerente.AcharIndicePeloNome(nomedocorrentista, gerente);
			int indicedaconta =gerente.seuCliente[indiceDoCliente].AcharIndice(comboBox.getSelectedItem().toString(),gerente.seuCliente[indiceDoCliente]);
			if(gerente.seuCliente[indiceDoCliente].conta[indicedaconta].tipodeconta == 2)
			{
				paneLimite.setVisible(true);
				paneTaxa.setVisible(false);
				setBounds(100, 100, 409, 233);

			}
			else
			{
				paneTaxa.setVisible(true);
				paneLimite.setVisible(false);
				setBounds(100, 100, 409, 233);

			}
			
			
		}
}
