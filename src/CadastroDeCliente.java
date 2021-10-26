import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JComboBox;

public class CadastroDeCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSenha;
	private JTextField txtLogin;

	
	public CadastroDeCliente(Gerente gerente[],int indice) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(47, 76, 46, 14);
		panel.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(120, 73, 188, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(47, 104, 46, 14);
		panel.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(120, 101, 188, 20);
		panel.add(txtSenha);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120, 11, 188, 22);
		panel.add(comboBox);
		comboBox.addItem("Cliente");
		comboBox.addItem("Gerente");

		
		JLabel lblNewLabel_1 = new JLabel("Tipo de conta");
		lblNewLabel_1.setBounds(47, 15, 104, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new AreaLogadaGerente(gerente,indice).setVisible(true);
			}
		});
		btnVoltar.setBounds(47, 163, 261, 23);
		panel.add(btnVoltar);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar");
		btnCadastrarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastrarCliente(gerente,indice,comboBox,txtNome,txtSenha);
			}
		});
		btnCadastrarCliente.setBounds(47, 129, 261, 23);
		panel.add(btnCadastrarCliente);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBounds(47, 51, 46, 14);
		panel.add(lblNewLabel_2);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(120, 48, 188, 20);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
	}
	
	
	public void CadastrarCliente(Gerente gerente[],int indice,JComboBox comboBox,JTextField Nome,JTextField Senha) {
		int tamanhodovetor = 0;
		String nome = (Nome.getText());
		String senha = (gerente[indice].criptografia(Senha.getText()));
		String login = (gerente[indice].criptografia(txtLogin.getText()));
		if(comboBox.getSelectedItem().toString().equals("Cliente"))
		{
		Cliente novocliente = new Cliente(login,nome,senha,gerente[indice]);
		gerente[indice].AgregarCliente(novocliente);
		gerente[indice].Salvar(gerente);
		JOptionPane.showMessageDialog(null,"Cliente cadastrado");
		this.setVisible(false);
		AreaLogadaGerente MenuDoGerente = new AreaLogadaGerente(gerente,indice);
		MenuDoGerente.setVisible(true);
		
		}
		else
		{	
			
			while(tamanhodovetor < 20)
			{
				if(gerente[tamanhodovetor] == null)
				{
					gerente[tamanhodovetor] = new Gerente(login,senha);
					gerente[tamanhodovetor].setNome(nome);
					JOptionPane.showMessageDialog(null,"Gerente cadastrado");
					setVisible(false);
					new AreaLogadaGerente(gerente,indice).setVisible(true);
					gerente[indice].Salvar(gerente);
					break;
					
				}
				
				
				tamanhodovetor ++;
			}
			
			
		}

		
	}
}
