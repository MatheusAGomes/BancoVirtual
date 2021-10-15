import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AreaLogadaCliente extends JFrame {

	private JPanel contentPane;
	
	public AreaLogadaCliente(Cliente cliente[],int indice,Gerente gerente[]) {
		int i = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ol\u00E1,");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNomeDoCliente = new JLabel(cliente[indice].nomedapessoa);
		lblNomeDoCliente.setBounds(40, 11, 110, 14);
		panel.add(lblNomeDoCliente);
		
		JButton btnAbrirConta = new JButton("Abrir conta");
		btnAbrirConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				AbrirConta janelaAbrirConta = new AbrirConta(cliente,indice,gerente);
				janelaAbrirConta.setVisible(true);
				
			}
		});
		btnAbrirConta.setBounds(10, 36, 140, 23);
		panel.add(btnAbrirConta);
		
		JButton btnAplicarDinheiro = new JButton("Aplicar dinheiro");
		btnAplicarDinheiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AplicarDinheiro janelaDeAplicarDinheiro = new AplicarDinheiro(cliente,indice,gerente);
				setVisible(false);
				janelaDeAplicarDinheiro.setVisible(true);
			}
		});
		btnAplicarDinheiro.setBounds(10, 70, 140, 23);
		panel.add(btnAplicarDinheiro);
		
		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TrocarSenha janelatrocar = new TrocarSenha(cliente[indice],cliente,indice,gerente);
				setVisible(false);
				janelatrocar.setVisible(true);
			}
		});
		btnAlterarSenha.setBounds(10, 172, 140, 23);
		panel.add(btnAlterarSenha);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SacarDinheiro janelaDeSacarDinheiro = new SacarDinheiro(cliente,indice,gerente);
				setVisible(false);
				janelaDeSacarDinheiro.setVisible(true);
			}
		});
		btnSacar.setBounds(10, 104, 140, 23);
		panel.add(btnSacar);
		
		JButton btnExtrato = new JButton("Extrato");
		btnExtrato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Extrato janelaExtrato = new Extrato(cliente,indice,gerente);
				setVisible(false);
				janelaExtrato.setVisible(true);
			}
		});
		btnExtrato.setBounds(10, 138, 140, 23);
		panel.add(btnExtrato);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login janeladeLogin	= new Login(gerente,cliente);
				setVisible(false);
				janeladeLogin.setVisible(true);
			}
		});
		btnSair.setBounds(10, 240, 140, 23);
		panel.add(btnSair);
		
		JButton btnVerificarAplicações = new JButton("Verificar rendimentos");
		btnVerificarAplicações.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int j = 0;
				try {
				while(cliente[indice].conta[j] != null)
				{
					
					if(cliente[indice].conta[j].tipodeconta == 3)
					{
						Aplicações janeladeaplicações = new Aplicações(cliente,indice,gerente);
						janeladeaplicações.setVisible(true);
						setVisible(false);
						break;
					}
					
					j = j + 1;
				}}catch(Exception i) {
					
				}
				JOptionPane.showMessageDialog(null,"Voce nao contém nenhuma conta poupanca");
				
			}
		});
		btnVerificarAplicações.setBounds(10, 206, 140, 23);
		panel.add(btnVerificarAplicações);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(196, 36, 171, 22);
		
		
		
		
		while(cliente[indice].conta[i] != null)
		{
			
				comboBox.addItem(cliente[indice].conta[i].numerodaconta);
			
			i++;
		}
		
		if(comboBox.getSelectedItem() != null) {
			panel.add(comboBox);
		Conta contacliente = cliente[indice].conta[cliente[indice].AcharIndice(comboBox.getSelectedItem().toString(),cliente[indice])];
		

		JLabel lblNewLabel_1 = new JLabel("Saldo total");
		lblNewLabel_1.setBounds(196, 142, 110, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblSaldoTotal = new JLabel(String.valueOf(cliente[indice].TotalSoma()));
		lblSaldoTotal.setBounds(301, 142, 186, 14);
		panel.add(lblSaldoTotal);
		
		JLabel lblNewLabel_2 = new JLabel("Saldo da conta");
		lblNewLabel_2.setBounds(196, 74, 110, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblSaldoDaConta = new JLabel(String.valueOf(contacliente.saldo));
		lblSaldoDaConta.setBounds(301, 74, 186, 14);
		panel.add(lblSaldoDaConta);
		
		JLabel lblNewLabel_3 = new JLabel("Saldo + Limite");
		lblNewLabel_3.setBounds(196, 108, 110, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblSaldoLimite = new JLabel("Está conta não contém limite");
		lblSaldoLimite.setBounds(301, 108, 186, 14);
		panel.add(lblSaldoLimite);
		if((contacliente.tipodeconta)==2)
		{
			lblSaldoLimite.setText(String.valueOf(contacliente.limite));
		}
		JButton btnTrocarConta = new JButton("Trocar conta");
		btnTrocarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarValores(cliente[indice],lblSaldoDaConta,lblSaldoLimite,comboBox);
			}
		});
		btnTrocarConta.setBounds(377, 36, 110, 23);
		panel.add(btnTrocarConta);
		}
		
		
		
	}
	public void mudarValores(Cliente cliente,JLabel lblSaldoDaConta,JLabel lblSaldoLimite,JComboBox comboBox){
		
		Conta contacliente = cliente.conta[cliente.AcharIndice(comboBox.getSelectedItem().toString(),cliente)];

		
		if((contacliente.tipodeconta)==2)
		{
			lblSaldoLimite.setText(String.valueOf(contacliente.limite));
		}
		else
		{
			lblSaldoLimite.setText("Está conta não contém limite");
		}
		
		lblSaldoDaConta.setText(String.valueOf(contacliente.saldo));
		
		
		
	}
}