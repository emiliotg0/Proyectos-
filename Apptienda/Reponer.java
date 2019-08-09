package Apptienda;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Reponer extends JFrame {

	private JPanel contentPane;
	private JTextField Codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reponer frame = new Reponer();
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
	public Reponer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Codigo de producto:");
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setBounds(18, 43, 163, 23);
		contentPane.add(label);
		
		Codigo = new JTextField();
		Codigo.setColumns(10);
		Codigo.setBounds(183, 45, 98, 20);
		contentPane.add(Codigo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 271, 2);
		contentPane.add(separator);
		
		JLabel lblRponerProducto = new JLabel("Reponer Producto");
		lblRponerProducto.setFont(new Font("Calibri", Font.BOLD, 18));
		lblRponerProducto.setBounds(10, 11, 163, 23);
		contentPane.add(lblRponerProducto);
		
		JLabel lblTipoDeProducto = new JLabel("Tipo de Producto");
		lblTipoDeProducto.setFont(new Font("Calibri", Font.BOLD, 18));
		lblTipoDeProducto.setBounds(18, 77, 163, 23);
		contentPane.add(lblTipoDeProducto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Computadoras", "Celulares"}));
		comboBox.setBounds(183, 76, 98, 20);
		contentPane.add(comboBox);
		
		JButton btnReponer = new JButton("Reponer");
		btnReponer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();
				String cantidad="";
				ResultSet rs;
				try {
					Statement stmt= con.createStatement();
					if(comboBox.getSelectedIndex()==0) {
					rs= stmt.executeQuery("Select cantidad from pc where codigo='"+Codigo.getText()+"';");}
					else {rs= stmt.executeQuery("Select cantidad from cel where codigo='"+Codigo.getText()+"';");}
					
					while(rs.next()) {
					cantidad=rs.getString(1);
					}


					int x = (Integer.parseInt(cantidad)+1);
					if(comboBox.getSelectedIndex()==0) {
						stmt.executeUpdate("UPDATE pc SET Cantidad='"+x+"'where codigo='"+Codigo.getText()+"';");
						}else {stmt.executeUpdate("UPDATE cel SET Cantidad='"+x+"'where codigo='"+Codigo.getText()+"';");}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnReponer.setBounds(57, 122, 163, 23);
		contentPane.add(btnReponer);
	}
}
