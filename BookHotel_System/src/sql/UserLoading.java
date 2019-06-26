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
		String sql = "select Guest_username,Guest_password from GuestMessage where Guest_username = ? and Guest_password = ?";			//预处理
		PreparedStatement prestmt = connectionSQLServer.getconnection().prepareStatement(sql);
		
		prestmt.setObject(1, username);
		prestmt.setObject(2, password);
		ResultSet re = prestmt.executeQuery();     //将执行的结果赋给结果集 
	 if(re.next()) {
		 //new Get(username);
		//System.out.println("登录成功！！！");	
		Get.getName(username);
		Get.getUsername(username);
		JOptionPane.showMessageDialog(null, "登录成功！！！", "提示", JOptionPane.INFORMATION_MESSAGE);
		new W_User_main();
		W_User_Loading.frame.setVisible(false);// 本窗口隐藏,
		W_User_Loading.frame.dispose();//本窗口销毁,释放内存资源
		
	}else {
		//System.out.println("账号或密码错误！！！");	
		JOptionPane.showMessageDialog(null, "账号或密码错误！！！", "提示", JOptionPane.INFORMATION_MESSAGE);
	}
}

}
