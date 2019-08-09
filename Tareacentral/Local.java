package Tareacentral;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Local extends JPanel {
	private JTextField NumO;
	private JTextField NumD;
	private JTextField Du;

	/**
	 * Create the panel.
	 */
	public Local() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(-18, 0, 440, 269);
		add(panel);
		
		JLabel label = new JLabel("Tipo de llamada");
		label.setFont(new Font("Calibri Light", Font.BOLD, 14));
		label.setBounds(34, 28, 104, 21);
		panel.add(label);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==1) {panel.removeAll();
				panel.setLocation(getLocation());
				Provincial pv = new Provincial();

				panel.setLayout(new BorderLayout());
				panel.add(pv);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Local\t", "Provincial"}));
		comboBox.setBounds(166, 28, 89, 21);
		panel.add(comboBox);
		
		JLabel label_1 = new JLabel("Numero Origen");
		label_1.setFont(new Font("Calibri Light", Font.BOLD, 14));
		label_1.setBounds(34, 60, 104, 14);
		panel.add(label_1);
		
		NumO = new JTextField();
		NumO.setColumns(20);
		NumO.setBounds(169, 57, 86, 20);
		panel.add(NumO);
		
		JLabel label_2 = new JLabel("Numero destino");
		label_2.setFont(new Font("Calibri Light", Font.BOLD, 14));
		label_2.setBounds(34, 98, 104, 14);
		panel.add(label_2);
		
		NumD = new JTextField();
		NumD.setColumns(20);
		NumD.setBounds(169, 95, 86, 20);
		panel.add(NumD);
		
		JLabel label_3 = new JLabel("Duracion");
		label_3.setFont(new Font("Calibri Light", Font.BOLD, 14));
		label_3.setBounds(34, 132, 104, 14);
		panel.add(label_3);
		
		Du = new JTextField();
		Du.setColumns(10);
		Du.setBounds(169, 129, 86, 20);
		panel.add(Du);
		
		JButton button = new JButton("Crear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con= null;
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/central_bd", "root","");
					Statement stmt= con.createStatement();
					long Num_origen =Long.parseLong(NumO.getText());
					long Num_destino = Long.parseLong(NumD.getText());
					int duracion = Integer.parseInt(Du.getText());
					int c = Integer.parseInt(Du.getText());
					double precio= ((c*60)*0.15);
					String precios=Double.toString(precio); 
					String SQL = ("Insert into llamada values('"+(Num_origen)+"','"+(Num_destino)+"','"+(duracion)+"','"+(precios)+"')");
					stmt.executeUpdate(SQL);
			}catch (SQLException e1) {JOptionPane.showMessageDialog(null, e1);}
				catch (InstantiationException e1) {
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
		button.setBounds(34, 194, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Borrar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con= null;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/central_bd", "root","");
					Statement stmt= con.createStatement();
					String respuesta = JOptionPane.showInputDialog("Escriba el numero que quiere borrar", "ej:8095369931");
					
					ResultSet rs = stmt.executeQuery("Select "+respuesta+" FROM llamada ");
					while(rs.next()) {
						if (respuesta.equals(rs.getString(1))||(respuesta.equals(rs.getString(2)))) {
							Borrar b =new Borrar();
							Post_login ps=new Post_login();
							b.setVisible(true);
							ps.setVisible(false);
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
		button_1.setBounds(166, 194, 89, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Editar");
		button_2.setBounds(293, 194, 89, 23);
		panel.add(button_2);

	}

}
