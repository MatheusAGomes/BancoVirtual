import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.text.DecimalFormat;

public class Aplicações extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public Aplicações(Cliente cliente[], int indice, Gerente gerente[]) {
		int i = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conta");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 7, 141, 22);
		contentPane.add(comboBox);
		while(cliente[indice].conta[i] != null)
		{
			if(cliente[indice].conta[i].tipodeconta == 3)
			{
				comboBox.addItem(cliente[indice].conta[i].numerodaconta);
			}
			i++;
		}
		
		JLabel lblNewLabel_1 = new JLabel("Valor aplicado");
		lblNewLabel_1.setBounds(20, 36, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSaldo = new JLabel(String.valueOf(cliente[indice].conta[cliente[indice].AcharIndice(comboBox.getSelectedItem().toString(),cliente[indice])].saldo));
		lblSaldo.setBounds(106, 36, 121, 14);
		contentPane.add(lblSaldo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 414, 389);
		contentPane.add(scrollPane);
		
		DefaultTableModel tableModel = new DefaultTableModel();
		table = new JTable();
		scrollPane.setViewportView(table);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		tableModel.addColumn("Mes");
		tableModel.addColumn("Extrato");
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Taxa(%)");
		lblNewLabel_3.setBounds(256, 36, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblTaxa = new JLabel(String.valueOf(cliente[indice].conta[cliente[indice].AcharIndice(comboBox.getSelectedItem().toString(),cliente[indice])].taxa));
		lblTaxa.setBounds(312, 36, 112, 14);
		contentPane.add(lblTaxa);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AreaLogadaCliente janelaCliente = new AreaLogadaCliente(cliente,indice,gerente);
				janelaCliente.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(335, 461, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnNewButton = new JButton("Mostrar Rendimentos");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MostrarRendimentos(cliente,indice,gerente,tableModel,comboBox,lblTaxa,lblSaldo,table);
			}
		});
		btnNewButton.setBounds(217, 7, 141, 23);
		contentPane.add(btnNewButton);
	}
	
	
	public void MostrarRendimentos(Cliente cliente[], int indice, Gerente gerente[],DefaultTableModel tableModel,JComboBox comboBox,JLabel lblTaxa, JLabel lblSaldo,JTable table){
		int i = 0;
		
		((DefaultTableModel)table.getModel()).setNumRows(0);
		
		
		int indicedaconta = cliente[indice].AcharIndice(comboBox.getSelectedItem().toString(),cliente[indice]);
		double taxaaomes = (cliente[indice].conta[indicedaconta].taxa)/12;
		double montante = (cliente[indice].conta[indicedaconta].saldo);
		lblTaxa.setText(String.valueOf(cliente[indice].conta[indicedaconta].taxa));
		lblSaldo.setText(String.valueOf(cliente[indice].conta[indicedaconta].saldo));
		
		
		
		DecimalFormat deci = new DecimalFormat("0.00");
		while(i <= 12)
		{
			
			
			montante = montante + ((montante * taxaaomes)/10);
		
			tableModel.insertRow(i, new Object[] {i,deci.format(montante)});
				
			i++;
		}
		
		
		
		
		
		
	}
}
