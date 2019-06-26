package sql;
import java.security.PublicKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ManagerAct {

	//确认订房
	public void Confirm_BookRoom(String RoomNo,String name) throws SQLException {	//确认订房
		String sql = "Update Room SET Room_status = ? ,Room_guest = ?  where Room_no = ?";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		prestmt.setObject(1, "已入住");
		prestmt.setObject(2, name);
		prestmt.setObject(3, RoomNo);
		prestmt.execute();
		
	}
	
	//从订房申请中删除记录
	public void Delete_BookApply(String RoomNo,String name) throws SQLException {	//删除订房申请
		String sql = "Delete from ApplysubscribeRoom where (no= ? And name= ? );";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		prestmt.setObject(1, RoomNo);
		prestmt.setObject(2, name);
		prestmt.execute();
		
	}
	
	//确认退房
	public void Confirm_UnsubscribeRoom(String RoomNo,String name) throws SQLException {		//确认退房
		String sql = "Update Room SET Room_status = ? ,Room_guest = ? where (Room_no= ? And Room_guest= ? )";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);	
		prestmt.setObject(1, "未入住");
		prestmt.setObject(2, "NULL");
		prestmt.setObject(3, RoomNo);
		prestmt.setObject(4, name);
		prestmt.execute();	
		
	}
	
	//从退房申请中删除记录
	public void Delete_UnsubscribeApply(String RoomNo,String name) throws SQLException {		//删除退房申请
		String sql = "Delete from ApplyUnsubscribeRoom where (no= ? And name= ? );";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		prestmt.setObject(1, RoomNo);
		prestmt.setObject(2, name);
		prestmt.execute();
		
	}
	
}
