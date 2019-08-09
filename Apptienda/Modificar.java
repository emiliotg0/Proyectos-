package Apptienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Modificar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField Procesador;
	private JTextField Ram;
	private JTextField Disco;
	private JTextField Precio;
	private JTable table_1;
	private JTextField Operador;
	private JTextField PrecioCel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar frame = new Modificar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Modificar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 535, 341);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Computadora", null, panel, null);
		panel.setLayout(null);
		
		Procesador = new JTextField();
		Procesador.setColumns(10);
		Procesador.setBounds(119, 245, 98, 20);
		panel.add(Procesador);
		
		JLabel label_1 = new JLabel("Procesador:");
		label_1.setFont(new Font("Calibri", Font.BOLD, 18));
		label_1.setBounds(20, 240, 115, 23);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Memoria ram:");
		label_2.setFont(new Font("Calibri", Font.BOLD, 18));
		label_2.setBounds(20, 172, 115, 23);
		panel.add(label_2);
		
		Ram = new JTextField();
		Ram.setColumns(10);
		Ram.setBounds(135, 174, 98, 20);
		panel.add(Ram);
		
		JLabel label_3 = new JLabel("Disco duro:");
		label_3.setFont(new Font("Calibri", Font.BOLD, 18));
		label_3.setBounds(20, 206, 85, 23);
		panel.add(label_3);
		
		Disco = new JTextField();
		Disco.setColumns(10);
		Disco.setBounds(107, 208, 98, 20);
		panel.add(Disco);
		
		JLabel label_4 = new JLabel("Precio:");
		label_4.setFont(new Font("Calibri", Font.BOLD, 18));
		label_4.setBounds(272, 193, 57, 23);
		panel.add(label_4);
		
		Precio = new JTextField();
		Precio.setColumns(10);
		Precio.setBounds(325, 195, 98, 20);
		panel.add(Precio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 510, 124);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				int row = table.getSelectedRow();
				
				String disco=table.getValueAt(row, 3).toString();
				String ram=table.getValueAt(row, 2).toString();
				String procesador=table.getValueAt(row, 4).toString();
				String precio=table.getValueAt(row, 5).toString();
				Disco.setText(disco);
				Ram.setText(ram);
				Procesador.setText(procesador);
				Precio.setText(precio);
				
			}
		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Conector c = new Conector();
				Connection con = c.conexion();

					try {
						
						Statement stmt= con.createStatement();
						ResultSet rs = stmt.executeQuery("Select * FROM pc");
						table.setModel(DbUtils.resultSetToTableModel(rs));}
						 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				
			}
		});
		
		
		btnCargar.setBounds(399, 135, 121, 31);
		panel.add(btnCargar);
		
		JButton btnNewButton = new JButton("MODIFICAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();

					try {
						
						Statement stmt= con.createStatement();
						int row = table.getSelectedRow();
						String codigo = table.getValueAt(row,0).toString();
						System.out.println(codigo);
						stmt.executeUpdate("UPDATE PC SET Ram='"+Ram.getText()+"',Disco='"+Disco.getText()+"',Procesador='"+Procesador.getText()+"',precio='"+Precio.getText()+"'where codigo='"+codigo+"';");
						}
						 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			});
				
		
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(297, 245, 126, 46);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Celular", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 510, 165);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int row = table_1.getSelectedRow();
				
				String operador=table_1.getValueAt(row, 4).toString();
				String precio=table_1.getValueAt(row, 3).toString();
				Operador.setText(operador);
				PrecioCel.setText(precio);

			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JLabel label = new JLabel("Operador:");
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setBounds(20, 182, 83, 23);
		panel_1.add(label);
		
		Operador = new JTextField();
		Operador.setColumns(10);
		Operador.setBounds(104, 184, 98, 20);
		panel_1.add(Operador);
		
		JLabel label_5 = new JLabel("Precio:");
		label_5.setFont(new Font("Calibri", Font.BOLD, 18));
		label_5.setBounds(51, 216, 57, 23);
		panel_1.add(label_5);
		
		PrecioCel = new JTextField();
		PrecioCel.setColumns(10);
		PrecioCel.setBounds(104, 218, 98, 20);
		panel_1.add(PrecioCel);
		
		JButton button = new JButton("MODIFICAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();
				try {
					Statement stmt= con.createStatement();
					int row = table_1.getSelectedRow();
					String codigo = table_1.getValueAt(row,0).toString();
					System.out.println(codigo);
					stmt.executeUpdate("UPDATE cel SET Operador='"+Operador.getText()+"',Precio='"+PrecioCel.getText()+"'where codigo='"+codigo+"';");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setBounds(364, 256, 126, 46);
		panel_1.add(button);
		
		JButton btnNewButton_1 = new JButton("Cargar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();

				try {
					
					Statement stmt= con.createStatement();
					ResultSet rs = stmt.executeQuery("Select * FROM cel");
					table_1.setModel(DbUtils.resultSetToTableModel(rs));}
					 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		
	});
		btnNewButton_1.setBounds(384, 182, 89, 23);
		panel_1.add(btnNewButton_1);
	}
}
