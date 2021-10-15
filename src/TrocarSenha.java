import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class TrocarSenha extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordAntigaSenha;
	private JPasswordField passwordNovaSenha;
	private JPasswordField passwordConfirmeASenha;

	public TrocarSenha(Pessoas pessoa,Gerente gerente[],int indicedogerente,int indicedocliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Antiga senha");
		lblNewLabel.setBounds(65, 14, 70, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nova senha");
		lblNewLabel_1.setBounds(65, 39, 70, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirme a senha");
		lblNewLabel_2.setBounds(65, 64, 84, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnAlterarSenha = new JButton("Alterar");
		btnAlterarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Alterar(gerente[indicedogerente].seuCliente[indicedocliente],passwordAntigaSenha,passwordNovaSenha,passwordConfirmeASenha);
				passwordAntigaSenha.setText("");
				passwordNovaSenha.setText("");
				passwordConfirmeASenha.setText("");
				
			}
		});
		btnAlterarSenha.setBounds(65, 89, 233, 23);
		panel.add(btnAlterarSenha);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AreaLogadaCliente janelaCliente = new AreaLogadaCliente(indicedocliente,gerente,indicedogerente);
				setVisible(false);
				janelaCliente.setVisible(true);
			}
		});
		btnVoltar.setBounds(65, 123, 233, 23);
		panel.add(btnVoltar);
		
		passwordAntigaSenha = new JPasswordField();
		passwordAntigaSenha.setBounds(159, 11, 139, 20);
		panel.add(passwordAntigaSenha);
		
		passwordNovaSenha = new JPasswordField();
		passwordNovaSenha.setBounds(159, 36, 139, 20);
		panel.add(passwordNovaSenha);
		
		passwordConfirmeASenha = new JPasswordField();
		passwordConfirmeASenha.setBounds(159, 61, 139, 20);
		panel.add(passwordConfirmeASenha);
	}
	
	public void Alterar(Pessoas pessoa,JPasswordField passwordAntigaSenha,JPasswordField passwordNovaSenha,JPasswordField passwordConfirmeASenha){
		String antigasenha = pessoa.senha;
		if(String.valueOf(passwordAntigaSenha.getPassword()).equals(antigasenha))
		{
			if(String.valueOf(passwordNovaSenha.getPassword()).equals(String.valueOf(passwordConfirmeASenha.getPassword())))
			{
				pessoa.AlterarSenha(String.valueOf(passwordNovaSenha.getPassword()));
				JOptionPane.showMessageDialog(null,"Senha alterada");
			}
			
			
		}
		else {
			
			JOptionPane.showMessageDialog(null,"Senha anterior incorreta");			
		}
	}
}
