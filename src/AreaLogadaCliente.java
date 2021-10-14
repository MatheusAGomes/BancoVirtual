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

public class AreaLogadaCliente extends JFrame {

	private JPanel contentPane;
	
	public AreaLogadaCliente(Cliente cliente[],int indice,Gerente gerente[]) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 183, 295);
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
				cliente[indice].AlterarSenha(JOptionPane.showInputDialog("Nova senha:"));
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
		btnSair.setBounds(10, 206, 140, 23);
		panel.add(btnSair);
		
		
		
		
	}
}