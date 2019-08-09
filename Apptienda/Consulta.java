package Apptienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Consulta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JLabel label_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta frame = new Consulta();
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
	public Consulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Codigo de producto:");
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setBounds(20, 110, 163, 23);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10); 
		textField.setBounds(193, 112, 98, 20);
		contentPane.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 473, 88);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label_1 = new JLabel("Tipo de producto:");
		label_1.setFont(new Font("Calibri", Font.BOLD, 18));
		label_1.setBounds(20, 142, 142, 23);
		contentPane.add(label_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Computadora \t", "Celular"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(172, 144, 116, 20);
		contentPane.add(comboBox);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();

				try {
					
					Statement stmt= con.createStatement();
					if(comboBox.getSelectedIndex()== 0) {
					ResultSet rs = stmt.executeQuery("Select * FROM pc where codigo ="+textField.getText() +";");
					table.setModel(DbUtils.resultSetToTableModel(rs));}else {ResultSet rs = stmt.executeQuery("Select * FROM cel where codigo ="+textField.getText() +";");
					table.setModel(DbUtils.resultSetToTableModel(rs));}

					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnConsultar.setBounds(110, 176, 243, 23);
		contentPane.add(btnConsultar);
	}
}
