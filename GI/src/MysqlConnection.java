import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class MysqlConnection {
	Connection con=null;
	public static Connection con() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","root");
			return con;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
