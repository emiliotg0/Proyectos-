package Tareacentral;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Provincial extends JPanel {
	private JTextField Du;
	private JTextField NumD;
	private JTextField NumO;


	/**
	 * Create the panel.
	 */
	public Provincial() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(13, 11, 374, 230);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Franja");
		label.setFont(new Font("Calibri Light", Font.BOLD, 14));
		label.setBounds(10, 149, 104, 14);
		panel.add(label);
		
		JSpinner Fra = new JSpinner();
		Fra.setBounds(155, 143, 76, 20);
		panel.add(Fra);
		
		JLabel label_1 = new JLabel("Duracion");
		label_1.setFont(new Font("Calibri Light", Font.BOLD, 14));
		label_1.setBounds(10, 115, 104, 14);
		panel.add(label_1);
		
		Du = new JTextField();
		Du.setColumns(20);
		Du.setBounds(145, 112, 86, 20);
		panel.add(Du);
		
		JLabel label_2 = new JLabel("Numero destino");
		label_2.setFont(new Font("Calibri Light", Font.BOLD, 14));
		label_2.setBounds(10, 81, 104, 14);
		panel.add(label_2);
		
		NumD = new JTextField();
		NumD.setColumns(20);
		NumD.setBounds(145, 78, 86, 20);
		panel.add(NumD);
		
		JLabel label_3 = new JLabel("Numero Origen");
		label_3.setFont(new Font("Calibri Light", Font.BOLD, 14));
		label_3.setBounds(10, 43, 104, 14);
		panel.add(label_3);
		
		NumO = new JTextField();
		NumO.setColumns(20);
		NumO.setBounds(145, 40, 86, 20);
		panel.add(NumO);
		
		JLabel label_4 = new JLabel("Tipo de llamada");
		label_4.setFont(new Font("Calibri Light", Font.BOLD, 14));
		label_4.setBounds(10, 11, 104, 21);
		panel.add(label_4);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==1) {panel.removeAll();
				panel.setLocation(getLocation());
				Local l = new Local();

				panel.setLayout(new BorderLayout());
				panel.add(l);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Provincial", "Local"}));
		comboBox.setBounds(142, 11, 89, 21);
		panel.add(comboBox);
		
		JButton button = new JButton("Crear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Coneccion SQL
				Connection con= null;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/central_bd", "root","");
					Statement stmt= con.createStatement();
					//Obtener enteros de TextField
					long Num_origen =Long.parseLong(NumO.getText());
					long Num_destino = Long.parseLong(NumD.getText());
					int duracion = Integer.parseInt(Du.getText());
					int c = Integer.parseInt(Du.getText());
					//Para obtener el entero de un SPINNER
					int franja = Integer.parseInt(Fra.getValue().toString());
					//Variacion de precio por el numero de Spinner
					//Separados debido al error de la variable precio
					if(franja==1) {double precio= ((c*60)*0.20);
					//comando SQL para ingresar los datos a la base de datos
					String SQL = ("Insert into llamada values('"+(Num_origen)+"','"+(Num_destino)+"','"+(duracion)+"','"+(precio)+"')");
					stmt.executeUpdate(SQL);}
					
					
					
					else if (franja==2) {double precio= ((c*60)*0.25);
					String precios=Double.toString(precio); 
					String SQL = ("Insert into llamada values('"+(Num_origen)+"','"+(Num_destino)+"','"+(duracion)+"','"+(precio)+"')");
					stmt.executeUpdate(SQL);}
					
					
					
					else if (franja==3) {double precio= ((c*60)*0.30);
					String precios=Double.toString(precio); 
					String SQL = ("Insert into llamada values('"+(Num_origen)+"','"+(Num_destino)+"','"+(duracion)+"','"+(precio)+"')");
					stmt.executeUpdate(SQL);}
					
				
			}catch (SQLException err) {JOptionPane.showMessageDialog(null, err);} catch (InstantiationException e1) {
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
		button.setBounds(10, 184, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Borrar");
		button_1.setBounds(142, 184, 89, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Editar");
		button_2.setBounds(269, 184, 89, 23);
		panel.add(button_2);

	}
}
