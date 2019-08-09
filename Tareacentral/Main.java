package Tareacentral;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Main {
	
	private JFrame frame;
	private JTextField user;
	private JPasswordField pass;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 301, 357);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblLogueate = new JLabel("Logueate");
		lblLogueate.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogueate.setFont(new Font("Calibri", Font.BOLD, 18));
		lblLogueate.setBounds(93, 30, 95, 16);
		getFrame().getContentPane().add(lblLogueate);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(114, 57, 50, 16);
		getFrame().getContentPane().add(lblUsuario);
		
		user = new JTextField();
		user.setBounds(93, 78, 89, 20);
		getFrame().getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(103, 109, 71, 14);
		getFrame().getContentPane().add(lblContrasea);
		
		pass = new JPasswordField();
		pass.setBounds(93, 134, 89, 20);
		getFrame().getContentPane().add(pass);
		
		JButton btentrar = new JButton("Entrar");
		btentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Post_login pl= new Post_login();
				Connection con= null;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/central_bd", "root","");
					Statement stmt= con.createStatement();
					ResultSet rs = stmt.executeQuery("Select * FROM registro ");
					while(rs.next()) {
						if (user.getText().equals(rs.getString(1))&&(pass.getText().equals(rs.getString(2)))) {
							pl.setVisible(true);
							getFrame().setVisible(false);
							break;
							} 

			}
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					System.err.println("ERROR:"+ e1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		btentrar.setBounds(93, 176, 89, 23);
		getFrame().getContentPane().add(btentrar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 48, 266, 2);
		getFrame().getContentPane().add(separator);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro rg = new Registro();
				rg.setVisible(true);
				getFrame().setVisible(false);
			}
		});
		btnRegistrarse.setBounds(93, 278, 106, 23);
		getFrame().getContentPane().add(btnRegistrarse);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 237, 266, 2);
		getFrame().getContentPane().add(separator_1);
		
		JLabel lblEresNuevo = new JLabel("Eres nuevo?");
		lblEresNuevo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEresNuevo.setBounds(10, 251, 95, 16);
		getFrame().getContentPane().add(lblEresNuevo);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}
