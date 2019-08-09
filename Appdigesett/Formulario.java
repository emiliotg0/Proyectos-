package Appdigesett;

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

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField Cedula;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField CodigoOficial;
	private JTextField Fecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		
		setBounds(100, 100, 330, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelConductor = new JLabel("Cedula del conductor:");
		lblNombreDelConductor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDelConductor.setBounds(10, 47, 154, 14);
		contentPane.add(lblNombreDelConductor);
		
		Cedula = new JTextField();
		Cedula.setBounds(160, 45, 98, 20);
		contentPane.add(Cedula);
		Cedula.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 105, 294, 2);
		contentPane.add(separator);
		
		JLabel lblTipoDeInfraccion = new JLabel("Tipo de infraccion");
		lblTipoDeInfraccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDeInfraccion.setBounds(92, 105, 119, 14);
		contentPane.add(lblTipoDeInfraccion);
		
		JCheckBox Obstruccion = new JCheckBox("Obstruccion de transito");
		buttonGroup.add(Obstruccion);
		Obstruccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		Obstruccion.setBounds(10, 139, 171, 23);
		contentPane.add(Obstruccion);
		
		JCheckBox Rojo = new JCheckBox(" semaforo en rojo");
		buttonGroup.add(Rojo);
		Rojo.setFont(new Font("Tahoma", Font.BOLD, 12));
		Rojo.setBounds(10, 217, 154, 23);
		contentPane.add(Rojo);
		
		JCheckBox Celular = new JCheckBox("Hablar por celular");
		buttonGroup.add(Celular);
		Celular.setFont(new Font("Tahoma", Font.BOLD, 12));
		Celular.setBounds(10, 165, 154, 23);
		contentPane.add(Celular);
		
		JCheckBox Cinturon = new JCheckBox("Sin cinturon");
		buttonGroup.add(Cinturon);
		Cinturon.setFont(new Font("Tahoma", Font.BOLD, 12));
		Cinturon.setBounds(10, 243, 111, 23);
		contentPane.add(Cinturon);
		
		JCheckBox Licenciavencida = new JCheckBox("Licencia vencida");
		buttonGroup.add(Licenciavencida);
		Licenciavencida.setFont(new Font("Tahoma", Font.BOLD, 12));
		Licenciavencida.setBounds(10, 191, 154, 23);
		contentPane.add(Licenciavencida);
		
		JButton btnNewButton = new JButton("MULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();
				String descripcion="";
				int precio=0;
				try {
					Statement stmt= con.createStatement();
					if (Obstruccion.isSelected()) {
						 descripcion =("obstrucción de tránsito");
						 precio=1800;
					}else if (Rojo.isSelected()) {
						descripcion =("pase de semáforo en rojo");
						 precio=5950;
					}else if(Celular.isSelected()) {
						descripcion =("hablar por el celular");
						 precio=3750;
					}else if(Licenciavencida.isSelected()) {
						descripcion =("licencia vencida");
						 precio=3890;
					}else if(Cinturon.isSelected()) {
						descripcion =("conducir sin el cinturon");
						 precio=3890;
					}
					stmt.executeUpdate("Insert into multas values('"+(descripcion)+"','"+(Cedula.getText())+"','"+(CodigoOficial.getText())+"','"+(Fecha.getText())+"','"+(precio)+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "METELO PRESO QUE ESA CEDULA NO APARECE POR PARTE!");
				} 
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(186, 334, 118, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Verificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conector c = new Conector();
				Connection con = c.conexion();
				ResultSet rs;
				Statement stmt;
				try {
				stmt= con.createStatement();
				rs = stmt.executeQuery("Select cedula,Nombre FROM conductor;");
					while (rs.next()) {

						if (Cedula.getText().equals(rs.getString(1))) {
							JOptionPane.showMessageDialog(null, "Esta cedula pertence a:"+rs.getString(2));
							break;}
					}
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
				
			
		});
		btnNewButton_1.setBounds(215, 76, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 314, 21);
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmAgregarConductor = new JMenuItem("Agregar conductor");
		mnMenu.add(mntmAgregarConductor);
		
		JMenuItem mntmVincularVehiculoCon = new JMenuItem("Vincular vehiculo con conductor");
		mntmVincularVehiculoCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehiculo vh = new vehiculo();
				vh.setVisible(true);
				setVisible(false);
						
			}
		});
		mnMenu.add(mntmVincularVehiculoCon);
		
		JLabel lblCodigoOficial = new JLabel("Codigo Oficial:");
		lblCodigoOficial.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoOficial.setBounds(10, 275, 98, 14);
		contentPane.add(lblCodigoOficial);
		
		CodigoOficial = new JTextField();
		CodigoOficial.setColumns(10);
		CodigoOficial.setBounds(105, 273, 98, 20);
		contentPane.add(CodigoOficial);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha.setBounds(10, 302, 56, 14);
		contentPane.add(lblFecha);
		
		Fecha = new JTextField();
		Fecha.setColumns(10);
		Fecha.setBounds(57, 300, 98, 20);
		contentPane.add(Fecha);
	}
	
		
	
}
