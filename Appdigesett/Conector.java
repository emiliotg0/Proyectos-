package Appdigesett;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class Conector {
	Connection con=null;
	public Connection conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/digesett", "root","");}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return con;}
}
