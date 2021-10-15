import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CadastroDeCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSenha;

	
	public CadastroDeCliente(Gerente gerente[],int indice) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(47, 44, 46, 14);
		panel.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(120, 41, 188, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(47, 75, 46, 14);
		panel.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(120, 72, 188, 20);
		panel.add(txtSenha);
		
		JButton btnCadastrarCliente = new JButton("CadastrarCliente");
		btnCadastrarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastrarCliente(gerente,indice);
			}
		});
		btnCadastrarCliente.setBounds(47, 107, 261, 23);
		panel.add(btnCadastrarCliente);
	}
	
	public void CadastrarCliente(Gerente gerente[],int indice) {
		
		Cliente novocliente = new Cliente(txtNome.getText(),txtSenha.getText(),gerente[indice]);
		gerente[indice].AgregarCliente(novocliente);
		gerente[indice].quantidadedeclientes = gerente[indice].quantidadedeclientes + 1;
		this.setVisible(false);
		AreaLogadaGerente MenuDoGerente = new AreaLogadaGerente(gerente,indice);
		MenuDoGerente.setVisible(true);

		
	}

}
