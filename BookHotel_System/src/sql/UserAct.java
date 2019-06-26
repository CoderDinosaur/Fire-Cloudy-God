package sql;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserAct {
	
	public void checkRoom()throws SQLException {
		String sql = "select Room_no from [Room] where Room_guest  = ?";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		prestmt.setObject(1, "null");
		ResultSet re = prestmt.executeQuery();
		while(re.next()) {
			System.out.println(re.getString("Room_no"));
		}
	}

	//用户申请订房函数，向ApplysubscribeRoom表插入订房申请信息
	public void User_ApplyBookRoom(String no) {             						
		try {	String sql = "insert into [ApplysubscribeRoom](no,username,name)values(?,?,?);"; 
		 PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		 prestmt.setObject(1,no);
		 prestmt.setObject(2,Get.username);
		 prestmt.setObject(3,Get.name);
		 prestmt.execute();	
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	//用户申请退房函数，向ApplyUnsubscribeRoom表插入退房申请信息
	public void User_ApplyUnsubscribeRoom(String no) { 
		try {	String sql = "insert into [ApplyUnsubscribeRoom](no,username,name)values(?,?,?);"; 
		 PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);	 
		 prestmt.setObject(1,no);
		 prestmt.setObject(2,Get.username);
		 prestmt.setObject(3,Get.name);
		 prestmt.execute();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}			
	}
}
