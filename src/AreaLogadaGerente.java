import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AreaLogadaGerente extends JFrame {

	private JPanel contentPane;


	public AreaLogadaGerente(Gerente gerente[],int indicedogerente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ol\u00E1,");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 36, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNomeDoGerente = new JLabel(gerente[indicedogerente].nomedapessoa);
		lblNomeDoGerente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDoGerente.setBounds(45, 11, 371, 14);
		panel.add(lblNomeDoGerente);
		
		JButton btnVerificarContas = new JButton("Verificar Contas");
		btnVerificarContas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VerificarContasDeClientes menudeverificacao = new VerificarContasDeClientes(indicedogerente,gerente);
				menudeverificacao.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnVerificarContas.setBounds(10, 59, 170, 23);
		panel.add(btnVerificarContas);
		
		JButton btnMovimentacoesDeClientes = new JButton("Movimentacoes de clientes");
		btnMovimentacoesDeClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new ExtratoDoGerente(gerente,indicedogerente).setVisible(true);
				
			}
		});
		btnMovimentacoesDeClientes.setBounds(10, 93, 170, 23);
		panel.add(btnMovimentacoesDeClientes);
		
		JButton btnAplicacoes = new JButton("Aplica\u00E7\u00F5es");
		btnAplicacoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AplicarDinheiroDoCliente janeladeaplicacao = new AplicarDinheiroDoCliente(indicedogerente,gerente);
				janeladeaplicacao.setVisible(true);
				setVisible(false);
			}
		});
		btnAplicacoes.setBounds(10, 127, 170, 23);
		panel.add(btnAplicacoes);
		
		JButton btnTransferencias = new JButton("Transfer\u00EAncias");
		btnTransferencias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransferenciasEntreClientes jTransferencias = new TransferenciasEntreClientes(indicedogerente,gerente);
				jTransferencias.setVisible(true);
				setVisible(false);
			}
		});
		btnTransferencias.setBounds(10, 161, 170, 23);
		panel.add(btnTransferencias);
		
		JButton btnSaques = new JButton("Saques");
		btnSaques.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new SaqueDoGerente(indicedogerente,gerente).setVisible(true);
			}
		});
		btnSaques.setBounds(10, 195, 170, 23);
		panel.add(btnSaques);
		
		JButton btnLimitesETaxas = new JButton("Limites e Taxas");
		btnLimitesETaxas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new LimitesTaxas(gerente,indicedogerente).setVisible(true);
			}
		});
		btnLimitesETaxas.setBounds(10, 229, 170, 23);
		panel.add(btnLimitesETaxas);
		
		JButton btnCadastroDeUsuarios = new JButton("Cadastro de usuarios");
		btnCadastroDeUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				CadastroDeCliente CadastroCliente = new CadastroDeCliente(gerente,indicedogerente);
				CadastroCliente.setVisible(true);
			}
		});
		btnCadastroDeUsuarios.setBounds(10, 263, 170, 23);
		panel.add(btnCadastroDeUsuarios);
		
		JButton btnAlterarsuaSenha = new JButton("Alterar sua senha");
		btnAlterarsuaSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnAlterarsuaSenha.setBounds(10, 297, 170, 23);
		panel.add(btnAlterarsuaSenha);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Login teladelogin = new Login(gerente);
				teladelogin.setVisible(true);
			}
		});
		btnSair.setBounds(225, 297, 170, 23);
		panel.add(btnSair);
	}

}
