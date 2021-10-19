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
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
		int j = 0;
		int chave = 0;
		
		String Opção = comboBox.getSelectedItem().toString();
		String Gerente = "GERENTE";
		String Cliente = "CLIENTE";
		//String UsernameObtido = txtUsername.getText();
		//String SenhaObtida = txtSenha.getText();
		
		String UsernameObtido = criptografia(txtUsername.getText());
		String SenhaObtida = criptografia(txtSenha.getText());

		
		
		try {
	
			//GERENTE
			while(i < 21)
			{
							if(Opção.equals(Gerente))
							{
								System.out.print(gerentebasico[i].nomedapessoa);
								if(UsernameObtido.equals(gerentebasico[i].nomedapessoa))
								{
									System.out.print(gerentebasico[i].senha);
					
									if(SenhaObtida.equals(gerentebasico[i].senha))
									{
										chave = 1;
										AreaLogadaGerente MenuDoGerente = new AreaLogadaGerente(gerentebasico,i);
										this.setVisible(false);
										MenuDoGerente.setVisible(true);
										break;
										
									}
								}
							}
							//
							if(Opção.equals(Cliente))
							{	
								j=0;
								while(j<21)
								{
									
									
								if(UsernameObtido.equals(gerentebasico[i].seuCliente[j].nomedapessoa))
								{
									
									if(SenhaObtida.equals(gerentebasico[i].seuCliente[j].senha))
									{
										chave = 1;
										AreaLogadaCliente MenuDoCliente = new AreaLogadaCliente(j,gerentebasico,i);
										setVisible(false);
										MenuDoCliente.setVisible(true);
										break;
										
									}
								}
								
								j++;
								
								}
							}
		
		
						i++;
		
			
			}
		}
		catch(Exception e) {
			if(chave == 0)
			{
				JOptionPane.showMessageDialog(null,"Usuario ou senhas incorretos");
			}
		}
		
		
		
			
		
			
		
	
	}
	public String criptografia(String Senhacriptografada){
		
		String senha = Senhacriptografada;
		
	
			
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
			
			
			byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
			
			StringBuilder sb = new StringBuilder();
			
			
				for(byte b: messageDigest)
				{
				sb.append(String.format("%02X", 0xFF & b));	
				}
				
				return sb.toString();
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return senha;
			
			
		
		
		
		
		
	}
}
