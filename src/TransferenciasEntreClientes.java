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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TransferenciasEntreClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	private JTextField txtConta;


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
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				AreaLogadaGerente Voltar = new AreaLogadaGerente(gerente,indice);
				Voltar.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 106, 368, 23);
		contentPane.add(btnVoltar);
		
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 140, 368, 91);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente");
		lblNewLabel_2.setBounds(0, 4, 46, 14);
		panel.add(lblNewLabel_2);
		
		
		
		
		
		
		
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(411, 11, 368, 91);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Valor");
		lblNewLabel_3.setBounds(10, 11, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		txtValor = new JTextField();
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = txtValor.getText();
	            int l = value.length();
	            if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8) {
	            	txtValor.setEditable(true);
	               
	            } else {
	            	txtValor.setEditable(false);
	            	JOptionPane.showMessageDialog(null,"Voce so pode digitar numeros neste campo");
	                    }
	         }
		});
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
			comboBoxCliente1.addItem((gerente[indice].seuCliente[i].nomedapessoa));
			i++;
			}
		
		
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBounds(100, 100, 404, 314);
				
				
				panel.setVisible(true);
				panel.add(btnVoltar);
				btnVoltar.setBounds(0, 68, 368, 23);
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
				
				
				
				String ContaParaDeposito = txtConta.getText();
				
				
				if(PegarConta(ContaParaDeposito,gerente) == -1)
				{
					JOptionPane.showMessageDialog(null,"Conta inexistente");
				}
				else
				{
					setBounds(100, 100, 799, 300);
					
					panel_1.setVisible(true);
					panel_1.add(btnVoltar);
					btnVoltar.setBounds(10,68,348,23);
					txtConta.setEnabled(false);
				}
				
				
				
				

			}
		});
		btnSelecionar_1.setBounds(0, 35, 368, 23);
		panel.add(btnSelecionar_1);
		
		txtConta = new JTextField();
		txtConta.setBounds(56, 1, 312, 20);
		panel.add(txtConta);
		txtConta.setColumns(10);
		
		
		JButton btnTrasnferencias = new JButton("Transferir");
		btnTrasnferencias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//pegar a conta dos dois clientes 
				//primeiro cliente e conta
				int indicedocliente = gerente[indice].AcharIndicePeloNome(comboBoxCliente1.getSelectedItem().toString(),gerente[indice]);
				int indicedaconta = gerente[indice].seuCliente[indicedocliente].AcharIndice(comboBoxConta1.getSelectedItem().toString(),gerente[indice].seuCliente[indicedocliente]);
				//segundo cliente
				int indicedogerente2 = PegarGerente(txtConta.getText(),gerente);
				int idicedocliente2 = PegarCliente(txtConta.getText(),gerente);
				int indicedaconta2 = PegarConta(txtConta.getText(),gerente);

				Transferir(gerente[indice].seuCliente[indicedocliente],gerente[indice].seuCliente[indicedocliente].conta[indicedaconta],gerente[indicedogerente2].seuCliente[idicedocliente2],gerente[indicedogerente2].seuCliente[idicedocliente2].conta[indicedaconta2],Double.valueOf(txtValor.getText().toString()));
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
	public int PegarGerente(String NumeroConta,Gerente gerente[])
	{
		int i = 0;
		int j = 0;
		int k = 0;
		
		
		while(gerente[i] != null)
		{ 
			j = 0;
			while(gerente[i].seuCliente[j] != null)
			{
				k = 0;
				while(gerente[i].seuCliente[j].conta[k] != null)
				{
					
					if(gerente[i].seuCliente[j].conta[k].numerodaconta == Integer.valueOf(NumeroConta))
					{
						return i;
					}
					k++;
				}
				j++;
			}
			
			i++;
		}
		return -1;
	}
	
	public int PegarCliente(String NumeroConta,Gerente gerente[])
	{
		int i = 0;
		int j = 0;
		int k = 0;
		
		
		while(gerente[i] != null)
		{ 
			j = 0;
			while(gerente[i].seuCliente[j] != null)
			{
				k = 0;
				while(gerente[i].seuCliente[j].conta[k] != null)
				{
					
					if(gerente[i].seuCliente[j].conta[k].numerodaconta == Integer.valueOf(NumeroConta))
					{
						return j;
					}
					k++;
				}
				j++;
			}
			
			i++;
		}
		return -1;
		
		
	}
	public int PegarConta(String NumeroConta,Gerente gerente[])
	{
		int i = 0;
		int j = 0;
		int k = 0;
		
		
		while(gerente[i] != null)
		{ 
			j = 0;
			while(gerente[i].seuCliente[j] != null)
			{
				k = 0;
				while(gerente[i].seuCliente[j].conta[k] != null)
				{
					
					if(gerente[i].seuCliente[j].conta[k].numerodaconta == Integer.valueOf(NumeroConta))
					{
						System.out.print(gerente[i].seuCliente[j].nomedapessoa);
						return k;
					}
					k++;
				}
				j++;
			}
			
			i++;
		}
		return -1;
		
		
	}

	public void Transferir(Cliente transferidor, Conta contadotransferidor,Cliente receptor,Conta contadorecptor,double valoratransferir)
	{
		try {
			if(contadotransferidor.saldo >= valoratransferir) {
				contadotransferidor.Sacar(valoratransferir,transferidor);
				contadorecptor.Aplicar(valoratransferir,receptor);
				JOptionPane.showMessageDialog(null,"Transferencia efetuada com sucesso");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Saldo insuficiente");

			}
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

