package sql;

import java.security.PublicKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import windows.W_User_Registered;

public class InsertUser {
	//����Ƿ���ͬ�˺ŵ��û�

	public boolean checkUser(String account) throws SQLException {
		String sql = "select * from GuestMessage where Guest_username = ?";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		prestmt.setObject(1, account);
		ResultSet re = prestmt.executeQuery();
		//���˺ų�ͻ�ķ���true��û�з���false
		if(re.next()) {
			return true;
		}else {
			return false;
		}		
	}
		
	//ע���û�
	public void registered(String username,String password,String name,String sex,String mobilephone,String IDCardNo) throws Exception {
		String sql = "insert into GuestMessage(Guest_username,Guest_password,Guest_name,Guest_sex,Guest_mobilephone,Guest_IDCardNo,Guest_BookedRoom)values(?,?,?,?,?,?,?);";
		String BookedRoom = "null";
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		prestmt.setObject(1, username);
		prestmt.setObject(2, password);
		prestmt.setObject(3, name);
		prestmt.setObject(4, sex);
		prestmt.setObject(5, mobilephone);
		prestmt.setObject(6, IDCardNo);
		prestmt.setObject(7, BookedRoom);
		if(checkUser(username))
		{
			JOptionPane.showMessageDialog(null, "���û��Ѵ��ڣ�����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			prestmt.execute();
			JOptionPane.showMessageDialog(null, "ע��ɹ�������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			W_User_Registered.frame.setVisible(false);// ����������,
			W_User_Registered.frame.dispose();//����������,�ͷ��ڴ���Դ
		}
		
	}
	
	}

