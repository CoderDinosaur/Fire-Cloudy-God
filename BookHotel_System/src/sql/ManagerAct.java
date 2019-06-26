package sql;
import java.security.PublicKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ManagerAct {

	//ȷ�϶���
	public void Confirm_BookRoom(String RoomNo,String name) throws SQLException {	//ȷ�϶���
		String sql = "Update Room SET Room_status = ? ,Room_guest = ?  where Room_no = ?";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		prestmt.setObject(1, "����ס");
		prestmt.setObject(2, name);
		prestmt.setObject(3, RoomNo);
		prestmt.execute();
		
	}
	
	//�Ӷ���������ɾ����¼
	public void Delete_BookApply(String RoomNo,String name) throws SQLException {	//ɾ����������
		String sql = "Delete from ApplysubscribeRoom where (no= ? And name= ? );";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		prestmt.setObject(1, RoomNo);
		prestmt.setObject(2, name);
		prestmt.execute();
		
	}
	
	//ȷ���˷�
	public void Confirm_UnsubscribeRoom(String RoomNo,String name) throws SQLException {		//ȷ���˷�
		String sql = "Update Room SET Room_status = ? ,Room_guest = ? where (Room_no= ? And Room_guest= ? )";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);	
		prestmt.setObject(1, "δ��ס");
		prestmt.setObject(2, "NULL");
		prestmt.setObject(3, RoomNo);
		prestmt.setObject(4, name);
		prestmt.execute();	
		
	}
	
	//���˷�������ɾ����¼
	public void Delete_UnsubscribeApply(String RoomNo,String name) throws SQLException {		//ɾ���˷�����
		String sql = "Delete from ApplyUnsubscribeRoom where (no= ? And name= ? );";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		prestmt.setObject(1, RoomNo);
		prestmt.setObject(2, name);
		prestmt.execute();
		
	}
	
}
