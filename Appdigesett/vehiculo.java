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
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class vehiculo extends JFrame {

	private JPanel contentPane;
	private JTextField Placa;
	private JTextField Marca;
	private JTextField Modelo;
	private JTextField Color;
	private JTextField year;
	private JTextField Chasis;
	private JTextField Cedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vehiculo frame = new vehiculo();
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
	public vehiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlaca.setBounds(10, 56, 56, 14);
		contentPane.add(lblPlaca);
		
		Placa = new JTextField();
		Placa.setColumns(10);
		Placa.setBounds(76, 54, 86, 20);
		contentPane.add(Placa);
		
		JLabel lblMarca = new JLabel("marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarca.setBounds(10, 81, 64, 14);
		contentPane.add(lblMarca);
		
		Marca = new JTextField();
		Marca.setColumns(10);
		Marca.setBounds(76, 79, 86, 20);
		contentPane.add(Marca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModelo.setBounds(10, 106, 64, 14);
		contentPane.add(lblModelo);
		
		Modelo = new JTextField();
		Modelo.setColumns(10);
		Modelo.setBounds(76, 104, 86, 20);
		contentPane.add(Modelo);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblColor.setBounds(10, 133, 56, 14);
		contentPane.add(lblColor);
		
		Color = new JTextField();
		Color.setColumns(10);
		Color.setBounds(76, 131, 86, 20);
		contentPane.add(Color);
		
		JLabel lblA = new JLabel("A\u00F1o:");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblA.setBounds(10, 158, 64, 14);
		contentPane.add(lblA);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(76, 156, 86, 20);
		contentPane.add(year);
		
		Cedula = new JTextField();
		Cedula.setColumns(10);
		Cedula.setBounds(76, 208, 86, 20);
		contentPane.add(Cedula);
		
		JLabel lblChasis = new JLabel("Chasis:");
		lblChasis.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChasis.setBounds(10, 183, 64, 14);
		contentPane.add(lblChasis);
		
		Chasis = new JTextField();
		Chasis.setColumns(10);
		Chasis.setBounds(76, 181, 86, 20);
		contentPane.add(Chasis);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Conector c = new Conector();
					Connection con = c.conexion();
					try {
						
						Statement stmt= con.createStatement();
						stmt.executeUpdate("Insert into conductor values('"+(Placa.getText())+"','"+(Marca.getText())+"','"+(Modelo.getText())+"','"+(Color.getText())+"','"+(year.getText())+"','"+(Chasis.getText())+"','"+(Cedula.getText())+"')");
						JOptionPane.showMessageDialog(null, "Listo!");
						Placa.setText(null);
						Marca.setText(null);
						Modelo.setText(null);
						Color.setText(null);
						year.setText(null);
						Chasis.setText(null);
						
						
						
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			});
		
		btnNewButton.setBounds(130, 249, 89, 46);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 25, 209, 2);
		contentPane.add(separator);
		
		JLabel lblVincularVehiculo = new JLabel("Vincular vehiculo");
		lblVincularVehiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVincularVehiculo.setBounds(10, 11, 115, 14);
		contentPane.add(lblVincularVehiculo);
		
		JLabel lblCedulaDelPropietarop = new JLabel("Cedula:");
		lblCedulaDelPropietarop.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCedulaDelPropietarop.setBounds(10, 210, 56, 14);
		contentPane.add(lblCedulaDelPropietarop);
	}

}
