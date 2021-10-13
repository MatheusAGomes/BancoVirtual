import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lblSenha;
	private JTextField txtSenha;

	public Login(Gerente gerentebasico[]) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(32, 27, 55, 14);
		panel.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(119, 24, 138, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(32, 89, 55, 14);
		panel.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(119, 86, 138, 20);
		panel.add(txtSenha);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(97, 147, 160, 22);
		panel.add(comboBox);
		comboBox.addItem(" ");
		comboBox.addItem("GERENTE");
		comboBox.addItem("CLIENTE");
		
		JLabel lblNewLabel_1 = new JLabel("Op\u00E7\u00E3o");
		lblNewLabel_1.setBounds(32, 151, 46, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Logar(gerentebasico,comboBox);
			}
		});
		btnLogar.setBounds(32, 207, 225, 23);
		panel.add(btnLogar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(32, 241, 225, 23);
		panel.add(btnLimpar);
	}
	
	public void Logar(Gerente gerentebasico[],JComboBox comboBox) {
		
		int i = 0;
		
		String Opção = comboBox.getSelectedItem().toString();
		String Gerente = "GERENTE";
		String Cliente = "CLIENTE";
		String UsernameObtido = txtUsername.getText();
		String SenhaObtida = txtSenha.getText();

	
		
		
		try {
			//GERENTE
			while(i < 21)
			{
		if(Opção.equals(Gerente))
		{
			System.out.print("a");
			if(UsernameObtido.equals(gerentebasico[i].nomedapessoa))
			{
				if(SenhaObtida.equals(gerentebasico[i].senha))
				{
					AreaLogadaGerente MenuDoGerente = new AreaLogadaGerente(gerentebasico[i]);
					this.setVisible(false);
					MenuDoGerente.setVisible(true);
					break;
					
				}
			}
		}
		// CLIENTE
		
		
		i++;
		
			
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Username ou senha incorretos");
		}
			
		
	
	}
}
