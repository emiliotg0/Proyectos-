package Apptienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Eliminar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eliminar frame = new Eliminar();
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
	public Eliminar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoDeProductos = new JLabel("Codigo de producto:");
		lblCodigoDeProductos.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCodigoDeProductos.setBounds(10, 55, 163, 23);
		contentPane.add(lblCodigoDeProductos);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(183, 57, 98, 20);
		contentPane.add(textField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 271, 2);
		contentPane.add(separator);
		
		JLabel lblEliminarProductos = new JLabel("Eliminar Productos");
		lblEliminarProductos.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEliminarProductos.setBounds(10, 11, 163, 23);
		contentPane.add(lblEliminarProductos);
		
		JLabel lblTipoDeProducto = new JLabel("Tipo de producto:");
		lblTipoDeProducto.setFont(new Font("Calibri", Font.BOLD, 18));
		lblTipoDeProducto.setBounds(31, 89, 142, 23);
		contentPane.add(lblTipoDeProducto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Computadora", "Celular"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(183, 91, 116, 20);
		contentPane.add(comboBox);
		
		JButton Eliminar = new JButton("ELIMINAR");
		Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();

				try {
					
					Statement stmt= con.createStatement();
					if(comboBox.getSelectedIndex()== 0) {
					stmt.executeUpdate("DELETE FROM pc WHERE codigo = " + textField.getText() + ";");
					JOptionPane.showMessageDialog(null, "Listo!");} else {stmt.executeUpdate("DELETE FROM cel WHERE codigo = " + textField.getText() + ";");
					JOptionPane.showMessageDialog(null, "Listo!");}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		Eliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		Eliminar.setBounds(48, 137, 201, 23);
		contentPane.add(Eliminar);
	}
}
