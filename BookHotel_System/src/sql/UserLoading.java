package sql;

import java.sql.PreparedStatement;
import windows.*;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UserLoading {
	String username;
	String password;
	
	//String username,String password
	public void SignIn(String username,String password) throws Exception {
		Scanner input = new Scanner(System.in);
		String sql = "select Guest_username,Guest_password from GuestMessage where Guest_username = ? and Guest_password = ?";			//Ԥ����
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		
		prestmt.setObject(1, username);
		prestmt.setObject(2, password);
		ResultSet re = prestmt.executeQuery();     //��ִ�еĽ����������� 
	 if(re.next()) {
		 //new Get(username);
		//System.out.println("��¼�ɹ�������");	
		Get.getName(username);
		Get.getUsername(username);
		JOptionPane.showMessageDialog(null, "��¼�ɹ�������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
		new W_User_main();
		W_User_Loading.frame.setVisible(false);// ����������,
		W_User_Loading.frame.dispose();//����������,�ͷ��ڴ���Դ
		
	}else {
		//System.out.println("�˺Ż�������󣡣���");	
		JOptionPane.showMessageDialog(null, "�˺Ż�������󣡣���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
	}
}

}
