package Tareacentral;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Calibri", Font.BOLD, 18));
		lblRegistro.setBounds(80, 11, 95, 16);
		contentPane.add(lblRegistro);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 29, 266, 2);
		contentPane.add(separator);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblNombreDeUsuario.setBounds(10, 56, 129, 14);
		contentPane.add(lblNombreDeUsuario);
		
		textField  = new JTextField();
		textField.setBounds(148, 53, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblClave.setBounds(87, 96, 52, 14);
		contentPane.add(lblClave);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 93, 86, 20);
		contentPane.add(passwordField);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblCorreo.setBounds(10, 139, 64, 14);
		contentPane.add(lblCorreo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(74, 136, 160, 20);
		contentPane.add(textField_1);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con= null;
				Main mn=new Main();
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/central_bd", "root","");
					Statement stmt= con.createStatement();
					String user = textField.getText();
					String clave = passwordField.getText();
					String correo = textField_1.getText();
					String SQL = ("Insert into registro values('"+(user)+"','"+(clave)+"','"+(correo)+"')");
					stmt.executeUpdate(SQL);
					setVisible(false);
					mn.getFrame().setVisible(true);}
					catch (SQLException err) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Este nombre de usuario ya lo han seleccionado utilize otro!!");
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}
		});
		btnCheck.setBounds(86, 182, 89, 23);
		contentPane.add(btnCheck);
	}

}
	
