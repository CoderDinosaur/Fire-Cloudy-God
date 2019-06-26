package sql;

import java.awt.print.Printable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Get {
	public static String name = "null";
	public static String username = "null";
//	public static ResultSet re;
	public static String getName(String tempUsername) throws SQLException{

		String sql = "select * from GuestMessage where Guest_username = ?";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		prestmt.setObject(1, tempUsername);
		ResultSet re = prestmt.executeQuery();
		
		if(re.next()) {
			 
			name = re.getString("Guest_name");
			return name;
			}
		
		else return "null";
		
}
	
	public static String getUsername(String tempUsername) throws SQLException{

		String sql = "select * from GuestMessage where Guest_username = ?";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		prestmt.setObject(1, tempUsername);
		ResultSet re = prestmt.executeQuery();
		
		if(re.next()) {
			 
			username = re.getString("Guest_username");
			return username;
			}
		
		else return "null";
		
}

	public static String getUser(String tempUsername) throws SQLException{

			String sql = "select * from GuestMessage where Guest_username = ?";
			PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
			prestmt.setObject(1, tempUsername);
			ResultSet re = prestmt.executeQuery();
			
			if(re.next()) {
				 
				String temp = re.getString("Guest_name");
				return temp;
				}
			else return "null";
			
	}
	public  String getPassword(String tempUsername) throws SQLException{
		String password = "null";
		try {
			String sql = "select * from GuestMessage where Guest_username = ?";
			PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
			prestmt.setObject(1, tempUsername);
			ResultSet re = prestmt.executeQuery();
			 password = re.getString("Guest_password");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return password;
	}
	
	}

