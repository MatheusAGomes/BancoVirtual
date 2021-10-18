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
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExtratoDoGerente extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public ExtratoDoGerente(Gerente gerente[],int indice) {
		int i = 0 ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seus clientes");
		lblNewLabel.setBounds(10, 21, 98, 14);
		contentPane.add(lblNewLabel);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 415, 364);
		contentPane.add(scrollPane);
		DefaultTableModel tableModel = new DefaultTableModel();
		table = new JTable();
		scrollPane.setViewportView(table);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		tableModel.addColumn("Nome do cliente");
		tableModel.addColumn("Numero da conta");
		tableModel.addColumn("Tipo da conta");
		tableModel.addColumn("Saldo");
		tableModel.addColumn("Extrato");

		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AreaLogadaGerente(gerente,indice).setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(336, 432, 89, 23);
		contentPane.add(btnVoltar);
		
		

		JComboBox comboBoxCliente = new JComboBox();
		comboBoxCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarExtratoTabela(gerente[indice],comboBoxCliente,tableModel,table);
			}
		});
		comboBoxCliente.setBounds(93, 17, 332, 22);
		contentPane.add(comboBoxCliente);
		while(gerente[indice].seuCliente[i] != null) {
			System.out.print(gerente[indice].seuCliente[i].nomedapessoa);
			comboBoxCliente.addItem(gerente[indice].seuCliente[i].nomedapessoa);
			i++;
			}
	}
	public void MostrarExtratoTabela(Gerente gerente,JComboBox comboBoxCliente,DefaultTableModel tableModel,JTable table)
	{
		
		
		((DefaultTableModel)table.getModel()).setNumRows(0);
		int indicedocliente = gerente.AcharIndicePeloNome(comboBoxCliente.getSelectedItem().toString(), gerente);
		int indicedaconta= 0;
		int i=0;
		
		while(gerente.seuCliente[indicedocliente].conta[indicedaconta] != null)
		{
			i= 0;
			while(gerente.seuCliente[indicedocliente].conta[indicedaconta].Movimentações[i] != null) 
			{
				if(i==0) {
				if(gerente.seuCliente[indicedocliente].conta[indicedaconta].tipodeconta == 1)
				{
					tableModel.insertRow(i,new Object[] {gerente.seuCliente[indicedocliente].nomedapessoa,gerente.seuCliente[indicedocliente].conta[indicedaconta].numerodaconta,"Simples",gerente.seuCliente[indicedocliente].conta[indicedaconta].saldo,gerente.seuCliente[indicedocliente].conta[indicedaconta].Movimentações[i]});
				}
				if(gerente.seuCliente[indicedocliente].conta[indicedaconta].tipodeconta == 2)
				{
					tableModel.insertRow(i,new Object[] {gerente.seuCliente[indicedocliente].nomedapessoa,gerente.seuCliente[indicedocliente].conta[indicedaconta].numerodaconta,"Especial",gerente.seuCliente[indicedocliente].conta[indicedaconta].saldo,gerente.seuCliente[indicedocliente].conta[indicedaconta].Movimentações[i]});
				}
				if(gerente.seuCliente[indicedocliente].conta[indicedaconta].tipodeconta == 3)
				{
					tableModel.insertRow(i,new Object[] {gerente.seuCliente[indicedocliente].nomedapessoa,gerente.seuCliente[indicedocliente].conta[indicedaconta].numerodaconta,"Poupanca",gerente.seuCliente[indicedocliente].conta[indicedaconta].saldo,gerente.seuCliente[indicedocliente].conta[indicedaconta].Movimentações[i]});
				}}
				else
				{
					tableModel.insertRow(i,new Object[] {null,null,null,null,gerente.seuCliente[indicedocliente].conta[indicedaconta].Movimentações[i]});

				}
			i++;
			}
			indicedaconta++;
		}
		
		
	}
}
