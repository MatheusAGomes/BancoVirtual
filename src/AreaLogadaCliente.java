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

public class AreaLogadaCliente extends JFrame {

	private JPanel contentPane;
	
	public AreaLogadaCliente(Cliente cliente[],int indice,Gerente gerente[]) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ol\u00E1,");
		lblNewLabel.setBounds(10, 30, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNomeDoCliente = new JLabel(cliente[indice].nomedapessoa);
		lblNomeDoCliente.setBounds(40, 30, 110, 14);
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
		btnAbrirConta.setBounds(10, 71, 140, 23);
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
		btnAplicarDinheiro.setBounds(10, 105, 140, 23);
		panel.add(btnAplicarDinheiro);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SacarDinheiro janelaDeSaque = new SacarDinheiro(cliente,indice,gerente);
				setVisible(false);
				janelaDeSaque.setVisible(true);
			}
		});
		btnSacar.setBounds(10, 139, 140, 23);
		panel.add(btnSacar);
		
		JButton btnExtrato = new JButton("Extrato");
		btnExtrato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Extrato janelaExtrato = new Extrato(cliente,indice,gerente);
				janelaExtrato.setVisible(true);
				setVisible(false);
			}
		});
		btnExtrato.setBounds(10, 173, 140, 23);
		panel.add(btnExtrato);
		
		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cliente[indice].AlterarSenha(JOptionPane.showInputDialog("Nova senha:"));
			}
		});
		btnAlterarSenha.setBounds(10, 207, 140, 23);
		panel.add(btnAlterarSenha);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(10, 241, 140, 23);
		panel.add(btnSair);
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Login teladelogin = new Login(gerente,cliente);
				teladelogin.setVisible(true);
				
			}
		});
	}

}
