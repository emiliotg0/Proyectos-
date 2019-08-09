package Apptienda;
//SQLConnector
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//SQLConnector
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField cantidadtext;
	private JTextField Ctext;
	public boolean vr=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 251);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("\r\n");
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmIngresarProducto = new JMenuItem("Ingresar producto");
		mntmIngresarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingreso i = new Ingreso();
				i.setVisible(true);
			}
		});
		mnMenu.add(mntmIngresarProducto);
		
		JMenuItem mntmEliminarProducto = new JMenuItem("Eliminar producto");
		mntmEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar el =new Eliminar();
				el.setVisible(true);
			}
		});
		mnMenu.add(mntmEliminarProducto);
		
		JMenuItem mntmConsultarProducto = new JMenuItem("Consultar producto");
		mntmConsultarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulta c =new Consulta();
				c.setVisible(true);
			}
		});
		mnMenu.add(mntmConsultarProducto);
		
		JMenuItem mntmReponerProducto = new JMenuItem("Reponer producto");
		mntmReponerProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reponer re =new Reponer();
				re.setVisible(true);
			}
			
		});
		mnMenu.add(mntmReponerProducto);
		
		JMenuItem mntmModificarProducto = new JMenuItem("Modificar producto");
		mntmModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar mo = new Modificar();
				mo.setVisible(true);
			}
		});
		mnMenu.add(mntmModificarProducto);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Total de ventas por dia");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Emilio\\Desktop\\Icon\\newspaper.png"));
		mnReportes.add(mntmNewMenuItem);
		
		JMenuItem mntmToalDeVentas = new JMenuItem("Total de ventas por producto");
		mntmToalDeVentas.setIcon(new ImageIcon("C:\\Users\\Emilio\\Desktop\\Icon\\market.png"));
		mnReportes.add(mntmToalDeVentas);
		
		JMenuItem mntmListadoDeProductos = new JMenuItem("Listado de productos en inventario");
		mntmListadoDeProductos.setIcon(new ImageIcon("C:\\Users\\Emilio\\Desktop\\Icon\\questionnaire.png"));
		mnReportes.add(mntmListadoDeProductos);
		
		JMenuItem mntmListadoDeVentas = new JMenuItem("Listado de ventas por mes");
		mntmListadoDeVentas.setIcon(new ImageIcon("C:\\Users\\Emilio\\Desktop\\Icon\\report.png"));
		mnReportes.add(mntmListadoDeVentas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCantidad.setBounds(93, 111, 80, 23);
		contentPane.add(lblCantidad);
		
		cantidadtext = new JTextField();
		cantidadtext.setBounds(170, 113, 86, 20);
		contentPane.add(cantidadtext);
		cantidadtext.setColumns(10);
		
		JLabel lblCodigoDeProducto = new JLabel("Codigo de producto:");
		lblCodigoDeProducto.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCodigoDeProducto.setBounds(10, 44, 163, 23);
		contentPane.add(lblCodigoDeProducto);
		
		Ctext = new JTextField();
		Ctext.setBounds(170, 46, 98, 20);
		contentPane.add(Ctext);
		Ctext.setColumns(10);
		
		JButton btnVerificarCodigo = new JButton("Verificar Codigo");
		btnVerificarCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();

				try {

					Statement stmt= con.createStatement();
					ResultSet rs = stmt.executeQuery("Select codigo FROM pc ");
					while(rs.next()) {
						if (Ctext.getText().equals(rs.getString(1))) {
							JOptionPane.showMessageDialog(null, "Este codigo es correcto");
							vr=true;
							break;
							} 
						}
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnVerificarCodigo.setBounds(154, 78, 137, 23);
		contentPane.add(btnVerificarCodigo);
		
		JButton btnRealizarVenta = new JButton("Realizar venta");
		btnRealizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();
				if (vr==true) {
					vr=false;
				try {
					Statement stmt= con.createStatement();
					ResultSet rs = stmt.executeQuery("Select cantidad FROM pc  where codigo ='"+Ctext.getText() +"' "); 	
					int cntd = (Integer.parseInt(cantidadtext.getText()));
					if(rs.next()) {
					int rsta = ((rs.getInt(1)) - (cntd));

					stmt.executeUpdate("UPDATE pc Set cantidad ='"+rsta+"'where codigo ='"+Ctext.getText() +"' ");
					}
						
					}
				 catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
				
			}else {JOptionPane.showMessageDialog(null, "No verifico el codigo!\n Verefica el codigo "); }
			}		
		});
		btnRealizarVenta.setBounds(93, 149, 114, 23);
		contentPane.add(btnRealizarVenta);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 31, 277, 2);
		contentPane.add(separator);
		
		JLabel lblVentaDeUn = new JLabel("Venta de un producto");
		lblVentaDeUn.setFont(new Font("Calibri", Font.BOLD, 18));
		lblVentaDeUn.setBounds(10, 10, 179, 23);
		contentPane.add(lblVentaDeUn);
	
}
}
