package Appdigesett;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Conductor extends JFrame {

	private JPanel contentPane;
	private JTextField Cedula;
	private JTextField Nombre;
	private JTextField Apellido;
	private JTextField Direccion;
	private JTextField Birthday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conductor frame = new Conductor();
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
	public Conductor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCedula.setBounds(10, 44, 56, 14);
		contentPane.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(10, 69, 64, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellido.setBounds(10, 94, 64, 14);
		contentPane.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDireccion.setBounds(10, 121, 72, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblTipoDeLicencia = new JLabel("Tipo de licencia:");
		lblTipoDeLicencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDeLicencia.setBounds(10, 147, 108, 14);
		contentPane.add(lblTipoDeLicencia);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaDeNacimiento.setBounds(10, 174, 141, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		Cedula = new JTextField();
		Cedula.setBounds(76, 42, 86, 20);
		contentPane.add(Cedula);
		Cedula.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setBounds(76, 67, 86, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		Apellido = new JTextField();
		Apellido.setBounds(76, 92, 86, 20);
		contentPane.add(Apellido);
		Apellido.setColumns(10);
		
		Direccion = new JTextField();
		Direccion.setBounds(76, 119, 133, 20);
		contentPane.add(Direccion);
		Direccion.setColumns(10);
		
		JComboBox Tipo = new JComboBox();
		Tipo.setModel(new DefaultComboBoxModel(new String[] {"Tipo A", "Tipo B", "Tipo C"}));
		Tipo.setBounds(123, 145, 86, 20);
		contentPane.add(Tipo);
		
		Birthday = new JTextField();
		Birthday.setBounds(151, 172, 86, 20);
		contentPane.add(Birthday);
		Birthday.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();
				try {
					
					Statement stmt= con.createStatement();
					stmt.executeUpdate("Insert into conductor values('"+(Cedula.getText())+"','"+(Nombre.getText())+"','"+(Apellido.getText())+"','"+(Birthday.getText())+"','"+(Direccion.getText())+"','"+(Tipo.getSelectedItem().toString())+"')");
					JOptionPane.showMessageDialog(null, "Listo!");
					Cedula.setText(null);
					Nombre.setText(null);
					Apellido.setText(null);
					Direccion.setText(null);
					Birthday.setText(null);
					
					
					
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setBounds(208, 208, 118, 48);
		contentPane.add(btnRegistrar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 26, 336, 2);
		contentPane.add(separator);
		
		JLabel lblRegistroDeConductores = new JLabel("Registro de conductores");
		lblRegistroDeConductores.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegistroDeConductores.setBounds(10, 11, 166, 14);
		contentPane.add(lblRegistroDeConductores);
	}
}
