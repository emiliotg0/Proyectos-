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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ingreso extends JFrame {

	private JPanel contentPane;
	private JTextField codigopc;
	private JTextField ram;
	private JTextField disco;
	private JTextField nombrepc;
	private JTextField cantidadpc;
	private JTextField preciopc;
	private JTextField procesador;
	private JTextField nombrecell;
	private JTextField cantidadcell;
	private JTextField preciocell;
	private JTextField operador;
	private JTextField codigocell;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingreso frame = new Ingreso();
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
	public Ingreso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 44, 411, 287);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Computadora", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Codigo de producto:");
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setBounds(10, 140, 163, 23);
		panel_1.add(label);
		
		codigopc = new JTextField();
		codigopc.setColumns(10);
		codigopc.setBounds(170, 142, 98, 20);
		panel_1.add(codigopc);
		
		JLabel label_1 = new JLabel("Memoria ram:");
		label_1.setFont(new Font("Calibri", Font.BOLD, 18));
		label_1.setBounds(10, 72, 115, 23);
		panel_1.add(label_1);
		
		ram = new JTextField();
		ram.setColumns(10);
		ram.setBounds(125, 74, 98, 20);
		panel_1.add(ram);
		
		JLabel label_2 = new JLabel("Disco duro:");
		label_2.setFont(new Font("Calibri", Font.BOLD, 18));
		label_2.setBounds(10, 106, 85, 23);
		panel_1.add(label_2);
		
		disco = new JTextField();
		disco.setColumns(10);
		disco.setBounds(97, 108, 98, 20);
		panel_1.add(disco);
		
		JLabel label_3 = new JLabel("Nombre:");
		label_3.setFont(new Font("Calibri", Font.BOLD, 18));
		label_3.setBounds(10, 10, 74, 23);
		panel_1.add(label_3);
		
		nombrepc = new JTextField();
		nombrepc.setColumns(10);
		nombrepc.setBounds(83, 12, 98, 20);
		panel_1.add(nombrepc);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCantidad.setBounds(20, 176, 74, 23);
		panel_1.add(lblCantidad);
		
		cantidadpc = new JTextField();
		cantidadpc.setColumns(10);
		cantidadpc.setBounds(93, 178, 98, 20);
		panel_1.add(cantidadpc);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Calibri", Font.BOLD, 18));
		lblPrecio.setBounds(213, 176, 57, 23);
		panel_1.add(lblPrecio);
		
		preciopc = new JTextField();
		preciopc.setColumns(10);
		preciopc.setBounds(266, 178, 98, 20);
		panel_1.add(preciopc);
		
		JLabel lblProcesador = new JLabel("Procesador:");
		lblProcesador.setFont(new Font("Calibri", Font.BOLD, 18));
		lblProcesador.setBounds(10, 38, 115, 23);
		panel_1.add(lblProcesador);
		
		procesador = new JTextField();
		procesador.setColumns(10);
		procesador.setBounds(109, 43, 98, 20);
		panel_1.add(procesador);
		
		JButton btnRegistrar = new JButton("Ingresar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();
				try {
					
					Statement stmt= con.createStatement();
					stmt.executeUpdate("Insert into pc values('"+(codigopc.getText())+"','"+(nombrepc.getText())+"','"+(ram.getText())+"','"+(disco.getText())+"','"+(procesador.getText())+"','"+(preciopc.getText())+"','"+(cantidadpc.getText())+"')");
					JOptionPane.showMessageDialog(null, "Listo!");
					codigopc.setText(null);
					nombrepc.setText(null);
					ram.setText(null);
					disco.setText(null);
					procesador.setText(null);
					preciopc.setText(null);
					cantidadpc.setText(null);
					
					
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnRegistrar.setBounds(97, 225, 191, 23);
		panel_1.add(btnRegistrar);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Celular", null, panel, null);
		panel.setLayout(null);
		
		JLabel label_4 = new JLabel("Nombre:");
		label_4.setFont(new Font("Calibri", Font.BOLD, 18));
		label_4.setBounds(10, 11, 74, 23);
		panel.add(label_4);
		
		nombrecell = new JTextField();
		nombrecell.setColumns(10);
		nombrecell.setBounds(83, 13, 98, 20);
		panel.add(nombrecell);
		
		cantidadcell = new JTextField();
		cantidadcell.setColumns(10);
		cantidadcell.setBounds(83, 127, 98, 20);
		panel.add(cantidadcell);
		
		JLabel label_5 = new JLabel("Cantidad:");
		label_5.setFont(new Font("Calibri", Font.BOLD, 18));
		label_5.setBounds(10, 125, 74, 23);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Precio:");
		label_6.setFont(new Font("Calibri", Font.BOLD, 18));
		label_6.setBounds(203, 125, 57, 23);
		panel.add(label_6);
		
		preciocell = new JTextField();
		preciocell.setColumns(10);
		preciocell.setBounds(256, 127, 98, 20);
		panel.add(preciocell);
		
		operador = new JTextField();
		operador.setColumns(10);
		operador.setBounds(94, 45, 98, 20);
		panel.add(operador);
		
		JLabel lblOperador = new JLabel("Operador:");
		lblOperador.setFont(new Font("Calibri", Font.BOLD, 18));
		lblOperador.setBounds(10, 43, 83, 23);
		panel.add(lblOperador);
		
		JLabel label_7 = new JLabel("Codigo de producto:");
		label_7.setFont(new Font("Calibri", Font.BOLD, 18));
		label_7.setBounds(10, 76, 163, 23);
		panel.add(label_7);
		
		codigocell = new JTextField();
		codigocell.setColumns(10);
		codigocell.setBounds(170, 78, 98, 20);
		panel.add(codigocell);
		
		JButton button = new JButton("Ingresar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
				{
				Conector c = new Conector();
				Connection con = c.conexion();

					try {
						
						Statement stmt= con.createStatement();
						stmt.executeUpdate("Insert into cel values('"+(codigocell.getText())+"','"+(nombrecell.getText())+"','"+(cantidadcell.getText())+"','"+(preciocell.getText())+"','"+(operador.getText())+"')");
						JOptionPane.showMessageDialog(null, "Listo!");
						codigocell.setText(null);
						nombrecell.setText(null);
						cantidadcell.setText(null);
						preciocell.setText(null);
						operador.setText(null);
						
						
						
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			});
				
			
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setBounds(94, 189, 191, 23);
		panel.add(button);
	}
}
