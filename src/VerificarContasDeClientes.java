import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;


public class VerificarContasDeClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public VerificarContasDeClientes(int indice, Gerente gerente[]) {
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
		
		
		
		while(i<gerente[indice].quantidadedeclientes) {
		comboBox.addItem(gerente[indice].seuCliente[i].nomedapessoa);
		System.out.print(gerente[indice].seuCliente[i].nomedapessoa);
		i++;
		}
		
		JLabel lblNewLabel = new JLabel("Seus clientes");
		lblNewLabel.setBounds(20, 40, 74, 14);
		panel.add(lblNewLabel);
		
		
		
		DefaultTableModel tableModel = new DefaultTableModel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 414, 330);
		
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		tableModel.addColumn("N° da conta");
		tableModel.addColumn("Tipo da conta");
		tableModel.addColumn("Saldo da conta");
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MostarNaTabela(indice,gerente,tableModel,comboBox,table);
			}
		});
		btnPesquisar.setBounds(273, 36, 137, 23);
		panel.add(btnPesquisar);

	}
	
	public void MostarNaTabela(int indice, Gerente gerente[],DefaultTableModel tableModel,JComboBox comboBox,JTable table) {
		int i = 0;
		
		((DefaultTableModel)table.getModel()).setNumRows(0);
		
		
		//int indicedaconta = cliente[indice].AcharIndice(comboBox.getSelectedItem().toString(),cliente[indice]); - > para cliente
		
		//gerente[indice].seuCliente[i].conta[i].
		
		int indicedaconta = gerente[indice].AcharIndicePeloNome(comboBox.getSelectedItem().toString(),gerente[indice]);

		Cliente clienteescolhido = gerente[indice].seuCliente[indicedaconta];
		
		
		while(gerente[indice].seuCliente[indicedaconta].conta[i] != null)
		{
			if(clienteescolhido.conta[i].tipodeconta == 1) {
					
			tableModel.insertRow(i, new Object[] {clienteescolhido.conta[i].numerodaconta,"Conta Simples",clienteescolhido.conta[i].saldo});
			}
			if(clienteescolhido.conta[i].tipodeconta == 2) {
				
				tableModel.insertRow(i, new Object[] {clienteescolhido.conta[i].numerodaconta,"Conta Especial",clienteescolhido.conta[i].saldo});
			}
			if(clienteescolhido.conta[i].tipodeconta == 3) {
				
				tableModel.insertRow(i, new Object[] {clienteescolhido.conta[i].numerodaconta,"Conta Poupança",clienteescolhido.conta[i].saldo});
				}
				
			i++;
		}
		
		
		
		
		
		
	}

}
