package Tareacentral;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.swing.JProgressBar;
public class Post_login extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Post_login frame = new Post_login();
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
	public Post_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 47, 423, 273);
		contentPane.add(tabbedPane);
		
		JPanel PanelLLamada = new JPanel();
		PanelLLamada.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				PanelLLamada.remove(PanelLLamada);
				Local l =new Local();
				PanelLLamada.setLayout(new BorderLayout());
				PanelLLamada.add(l,JTabbedPane.CENTER);
			}
		});
		tabbedPane.addTab("Panel de llamadas", null, PanelLLamada, null);
		PanelLLamada.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Panel de reportes", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 398, 133);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnActualizar = new JButton("Cargar datos");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con= null;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/central_bd", "root","");
					Statement stmt= con.createStatement();
					String SQL = ("select * from llamada");
					ResultSet rs = stmt.executeQuery(SQL);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch(SQLException err){} catch (InstantiationException e1) {
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
		btnActualizar.setBounds(95, 191, 231, 23);
		panel_1.add(btnActualizar);
		
		JPanel ExportImport = new JPanel();
		tabbedPane.addTab("Exportar / importar datos", null, ExportImport, null);
		ExportImport.setLayout(null);
		
		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	Connection con= null;
			try {
				 PrintWriter pw= new PrintWriter(new File("C:\\Users\\Emilio\\Desktop\\Reporte_llamadas.csv"));
				    StringBuilder sb=new StringBuilder();
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/central_bd", "root","");
				Statement stmt= con.createStatement();
				String SQL = ("select * from llamada");
				ResultSet rs = stmt.executeQuery(SQL);
				while(rs.next()){
				     sb.append(rs.getString(1));
				     sb.append(","); 
				     sb.append(rs.getString(2));
				     sb.append(",");
				     sb.append(rs.getString(3));
				     sb.append(",");
				     sb.append(rs.getString(4));
				     sb.append("\r\n");
				    }
				 
				    pw.write(sb.toString());
				    pw.close();
				    JOptionPane.showMessageDialog(null, "Archivo exportado en el escritorio");
			}catch(SQLException err){} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
		btnExportar.setBounds(37, 66, 337, 23);
		ExportImport.add(btnExportar);
		
		JButton btnImportar = new JButton("Importar");
		btnImportar.setBounds(37, 137, 337, 23);
		ExportImport.add(btnImportar);
	
	}
}
