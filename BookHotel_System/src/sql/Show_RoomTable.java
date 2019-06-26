package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Show_RoomTable {
	
	//�ͻ���ѯ�շ�,��ʾ�շ����
	public Object[][] User_checkRoom() throws SQLException {										
		String sql = "select * from Room where Room_status = ?"; 
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		 prestmt.setObject(1,"δ��ס");
		// ִ�в�ѯ
		ResultSet rs = prestmt.executeQuery();
		// �����ж�������¼
		int count = 0;
		while(rs.next()){
			count++;
		}
		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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

	
	//�ͻ���ѯ�Լ���Ԥ����ס������ʾ�Ѷ������
	public Object[][] User_UnsubscribeRoom() throws SQLException {  
									
		String sql = "select * from Room where Room_guest = ?"; 
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		// ִ�в�ѯ
		prestmt.setObject(1, Get.name);
		ResultSet rs = prestmt.executeQuery();
		// �����ж�������¼
		int count = 0;
		while(rs.next()){
			count++;
		}

		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
	
	//����˲鿴���з���״̬����ʾ���з�����
	public Object[][] RoomStatus() throws SQLException {	
		 String sql = "select * from Room "; 
		 PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		// ִ�в�ѯ
		 ResultSet rs = prestmt.executeQuery();
		// �����ж�������¼
		int count = 0;
		while(rs.next()){
			count++;
		}
		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
	
	//����˲鿴����Ԥ��������
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
	
	//����˲鿴�����˶�������
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
