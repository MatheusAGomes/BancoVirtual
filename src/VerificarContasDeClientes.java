import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VerificarContasDeClientes extends JFrame {

	private JPanel contentPane;

	public VerificarContasDeClientes(Gerente gerente) {
		int i = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(104, 36, 159, 22);
		panel.add(comboBox);
		
		
		
		while(i<gerente.quantidadedeclientes) {
		comboBox.addItem(gerente.seuCliente[i].nomedapessoa);
		System.out.print(gerente.seuCliente[i].nomedapessoa);
		i++;
		}
		
		JLabel lblNewLabel = new JLabel("Seus clientes");
		lblNewLabel.setBounds(20, 40, 74, 14);
		panel.add(lblNewLabel);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(273, 36, 137, 23);
		panel.add(btnPesquisar);
	}

}
