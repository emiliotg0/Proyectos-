package Appdigesett;
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



import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Entrada extends JFrame {

	private JPanel contentPane;
	private JTextField Codigo;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrada frame = new Entrada();
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
	public Entrada() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 27, 286, 2);
		contentPane.add(separator);
		
		JLabel lblDigesettSistemaDe = new JLabel("DIGESETT SISTEMA DE MULTAS");
		lblDigesettSistemaDe.setFont(new Font("Calibri Light", Font.BOLD, 15));
		lblDigesettSistemaDe.setBounds(44, 11, 217, 14);
		contentPane.add(lblDigesettSistemaDe);
		
		JLabel lblCodigoDeEmpleado = new JLabel("Codigo de empleado");
		lblCodigoDeEmpleado.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblCodigoDeEmpleado.setBounds(79, 40, 138, 14);
		contentPane.add(lblCodigoDeEmpleado);
		
		Codigo = new JTextField();
		Codigo.setBounds(79, 65, 138, 20);
		contentPane.add(Codigo);
		Codigo.setColumns(10);
		
		JButton btnNewButton = new JButton("entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();
				Formulario fr = new Formulario();
				try {
					Statement stmt= con.createStatement();
					ResultSet rs = stmt.executeQuery("Select Codigo FROM oficial; ");
					while(rs.next()) {
						if (Codigo.getText().equals(rs.getString(1))) {
							fr.setVisible(true);
							setVisible(false);
							break;}
						}
					}catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
				}
	
			
		});
		btnNewButton.setBounds(108, 96, 89, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 144, 306, 2);
		contentPane.add(separator_1);
		
		JButton Consultar = new JButton("Consultar");
		Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cedula= JOptionPane.showInputDialog("Escriba el numero de cedula");
				
				Conector c = new Conector();
				Connection con = c.conexion();
				ResultSet rs;
				Statement stmt;
				try {
				stmt= con.createStatement();
				rs = stmt.executeQuery("Select descripcion,idconductor FROM multas;");
					while (rs.next()) {

						if (cedula.equals(rs.getString(2))) {
							JOptionPane.showMessageDialog(null, "Tiene multas por:"+rs.getString(1));
							break;}
					}
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		Consultar.setBounds(39, 194, 222, 20);
		contentPane.add(Consultar);
		
		JLabel lblConsultaDeMultas = new JLabel("Consulta de multas");
		lblConsultaDeMultas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeMultas.setFont(new Font("Calibri Light", Font.BOLD, 15));
		lblConsultaDeMultas.setBounds(44, 152, 217, 14);
		contentPane.add(lblConsultaDeMultas);
		
	}
	
}
