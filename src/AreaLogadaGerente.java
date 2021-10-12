import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class AreaLogadaGerente extends JFrame {

	private JPanel contentPane;


	public AreaLogadaGerente(Gerente gerente) {
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
		lblNewLabel.setBounds(10, 11, 104, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNomeDoGerente = new JLabel(gerente.nomedapessoa);
		lblNomeDoGerente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDoGerente.setBounds(41, 11, 82, 14);
		panel.add(lblNomeDoGerente);
		
		JButton btnVerificarContas = new JButton("Verificar Contas");
		btnVerificarContas.setBounds(10, 59, 170, 23);
		panel.add(btnVerificarContas);
		
		JButton btnMovimentacoesDeClientes = new JButton("Movimentacoes de clientes");
		btnMovimentacoesDeClientes.setBounds(10, 93, 170, 23);
		panel.add(btnMovimentacoesDeClientes);
		
		JButton btnAplicacoes = new JButton("Aplica\u00E7\u00F5es");
		btnAplicacoes.setBounds(10, 127, 170, 23);
		panel.add(btnAplicacoes);
		
		JButton btnTransferencias = new JButton("Transfer\u00EAncias");
		btnTransferencias.setBounds(10, 161, 170, 23);
		panel.add(btnTransferencias);
		
		JButton btnSaques = new JButton("Saques");
		btnSaques.setBounds(10, 195, 170, 23);
		panel.add(btnSaques);
		
		JButton btnLimitesETaxas = new JButton("Limites e Taxas");
		btnLimitesETaxas.setBounds(10, 229, 170, 23);
		panel.add(btnLimitesETaxas);
		
		JButton btnCadastroDeUsuarios = new JButton("Cadastro de usuarios");
		btnCadastroDeUsuarios.setBounds(10, 263, 170, 23);
		panel.add(btnCadastroDeUsuarios);
		
		JButton btnAlterarsuaSenha = new JButton("Alterar sua senha");
		btnAlterarsuaSenha.setBounds(10, 297, 170, 23);
		panel.add(btnAlterarsuaSenha);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(225, 297, 170, 23);
		panel.add(btnSair);
	}

}
