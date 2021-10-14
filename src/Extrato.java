import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class Extrato extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public Extrato(Cliente cliente[],int indice,Gerente gerente[]) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saldo");
		lblNewLabel.setBounds(10, 22, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("R$");
		lblNewLabel_1.setBounds(46, 22, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblSaldo = new JLabel(String.valueOf(cliente[indice].TotalSoma()));
		lblSaldo.setBounds(66, 22, 105, 14);
		panel.add(lblSaldo);
		
		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AreaLogadaCliente janelaCliente = new AreaLogadaCliente(cliente,indice,gerente);
				setVisible(false);
				janelaCliente.setVisible(true);
			}
		});
		btnRetornar.setBounds(327, 357, 89, 23);
		panel.add(btnRetornar);
		
		table = new JTable();
		table.setBounds(20, 47, 390, 282);
		panel.add(table);
	}
}
