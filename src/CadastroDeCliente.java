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
import java.util.ArrayList;
import javax.swing.JComboBox;

public class CadastroDeCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSenha;

	
	public CadastroDeCliente(Gerente gerente[],int indice) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 225);
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
		btnVoltar.setBounds(47, 141, 261, 23);
		panel.add(btnVoltar);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar");
		btnCadastrarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastrarCliente(gerente,indice,comboBox,txtNome,txtSenha);
			}
		});
		btnCadastrarCliente.setBounds(47, 107, 261, 23);
		panel.add(btnCadastrarCliente);
	}
	
	
	public void CadastrarCliente(Gerente gerente[],int indice,JComboBox comboBox,JTextField Nome,JTextField Senha) {
		int tamanhodovetor = 0;
		
		if(comboBox.getSelectedItem().toString() == "Cliente")
		{
		Cliente novocliente = new Cliente(txtNome.getText(),txtSenha.getText(),gerente[indice]);
		gerente[indice].AgregarCliente(novocliente);
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
					gerente[tamanhodovetor] = new Gerente(Nome.getText().toString(),Senha.getText().toString());
					JOptionPane.showMessageDialog(null,"Gerente cadastrado");
					setVisible(false);
					new AreaLogadaGerente(gerente,indice).setVisible(true);
					break;
					
				}
				
				
				tamanhodovetor ++;
			}
			
			
		}

		
	}

}
