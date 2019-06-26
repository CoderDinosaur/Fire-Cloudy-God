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

	//�û����붩����������ApplysubscribeRoom����붩��������Ϣ
	public void User_ApplyBookRoom(String no) {             						
		try {	String sql = "insert into [ApplysubscribeRoom](no,username,name)values(?,?,?);"; 
		 PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		 prestmt.setObject(1,no);
		 prestmt.setObject(2,Get.username);
		 prestmt.setObject(3,Get.name);
		 prestmt.execute();	
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	//�û������˷���������ApplyUnsubscribeRoom������˷�������Ϣ
	public void User_ApplyUnsubscribeRoom(String no) { 
		try {	String sql = "insert into [ApplyUnsubscribeRoom](no,username,name)values(?,?,?);"; 
		 PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);	 
		 prestmt.setObject(1,no);
		 prestmt.setObject(2,Get.username);
		 prestmt.setObject(3,Get.name);
		 prestmt.execute();
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}			
	}
}
