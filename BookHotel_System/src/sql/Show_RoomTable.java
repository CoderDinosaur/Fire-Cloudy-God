package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Show_RoomTable {
	
	//客户查询空房,显示空房表格
	public Object[][] User_checkRoom() throws SQLException {										
		String sql = "select * from Room where Room_status = ?"; 
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		 prestmt.setObject(1,"未入住");
		// 执行查询
		ResultSet rs = prestmt.executeQuery();
		// 计算有多少条记录
		int count = 0;
		while(rs.next()){
			count++;
		}
		// 将查询获得的记录数据，转换成适合生成JTable的数据形式
		Object[][] Room = new Object[count][4];
		count = 0;
		rs = prestmt.executeQuery();
		while(rs.next()){
			Room[count][0] = rs.getString("Room_no");
			Room[count][1] = rs.getString("Room_status");
			Room[count][2] = rs.getString("Room_cleaner");
		//	System.out.println(Room[count][0]);
			count++;
		}
		return Room;
	}

	
	//客户查询自己已预订的住房，显示已订房表格
	public Object[][] User_UnsubscribeRoom() throws SQLException {  
									
		String sql = "select * from Room where Room_guest = ?"; 
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		// 执行查询
		prestmt.setObject(1, Get.name);
		ResultSet rs = prestmt.executeQuery();
		// 计算有多少条记录
		int count = 0;
		while(rs.next()){
			count++;
		}

		// 将查询获得的记录数据，转换成适合生成JTable的数据形式
		Object[][] Room = new Object[count][2];
		count = 0;
		rs = prestmt.executeQuery();
		while(rs.next()){
		
			Room[count][0] = rs.getString("Room_no");
			Room[count][1] = rs.getString("Room_guest");
	
			count++;
		}
		return Room;
	}
	
	//服务端查看所有房间状态，显示所有房间表格
	public Object[][] RoomStatus() throws SQLException {	
		 String sql = "select * from Room "; 
		 PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		// 执行查询
		 ResultSet rs = prestmt.executeQuery();
		// 计算有多少条记录
		int count = 0;
		while(rs.next()){
			count++;
		}
		// 将查询获得的记录数据，转换成适合生成JTable的数据形式
		Object[][] Room = new Object[count][4];
		count = 0;
		rs = prestmt.executeQuery();
		while(rs.next()){
		
			Room[count][0] = rs.getString("Room_no");
			Room[count][1] = rs.getString("Room_status");
			Room[count][2] = rs.getString("Room_guest");
			Room[count][3] = rs.getString("Room_cleaner");
			count++;
		}
		return Room;
	}
	
	//服务端查看申请预订房间表格
	public Object[][] Act_ApplyBookRoom() throws SQLException {
		String sql = "select * from ApplysubscribeRoom "; 
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		ResultSet rs = prestmt.executeQuery();
		int count = 0;
		while(rs.next()){
			count++;
		}
		Object[][] Room = new Object[count][3];
		count = 0;
		rs = prestmt.executeQuery();
		while(rs.next()){

			Room[count][0] = rs.getString("no");
			Room[count][1] = rs.getString("username");
			Room[count][2] = rs.getString("name");
			count++;
		}
		return Room;
	}
	
	//服务端查看申请退订房间表格
	public Object[][] Act_ApplyUnsubscribeRoom() throws SQLException {
		
		 String sql = "select * from ApplyUnsubscribeRoom "; 
		 PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		ResultSet rs = prestmt.executeQuery();
		int count = 0;
		while(rs.next()){
			count++;
		}
		Object[][] Room = new Object[count][3];
		count = 0;
		rs = prestmt.executeQuery();
	while(rs.next()){
		
		Room[count][0] = rs.getString("no");
		Room[count][1] = rs.getString("username");
		Room[count][2] = rs.getString("name");
		count++;
	}
		return Room;
	}
	
}
