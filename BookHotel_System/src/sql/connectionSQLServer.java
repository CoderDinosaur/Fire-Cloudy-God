package sql;
import java.sql.*;

public class connectionSQLServer{
	public static Connection conn=null;
	public static Statement stmt=null;
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	final static String DB_USER = "root";
	final static String PASSWORD = "LJ13437859062";

	public static Connection getconnection(){//获取数据库信息

			try{
				Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
					//System.out.println("驱动加载成功");
			    }catch(Exception e) {
					e.printStackTrace();
				}
			try {
				conn =  DriverManager.getConnection(DB_URL,DB_USER,PASSWORD);//
				stmt=conn.createStatement();
				//System.out.println("连接数据库成功");
			}catch(Exception e) {
				e.printStackTrace();
			}
			return conn;
	 	}
	
	 public static void closeMyConnection(){//关闭数据库连接
			try{
				stmt.close();
				conn.close();
				//System.out.println("数据库已关闭");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	
	 
	 public static void main(String args[]) {
		 getconnection();
		 
		 closeMyConnection();
	}
	
}
