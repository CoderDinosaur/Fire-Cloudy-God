package sql;
import java.sql.*;

public class connectionSQLServer{
	public static Connection conn=null;
	public static Statement stmt=null;
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	final static String DB_USER = "root";
	final static String PASSWORD = "LJ13437859062";

	public static Connection getconnection(){//��ȡ���ݿ���Ϣ

			try{
				Class.forName("com.mysql.jdbc.Driver");//�������ݿ�����
					//System.out.println("�������سɹ�");
			    }catch(Exception e) {
					e.printStackTrace();
				}
			try {
				conn =  DriverManager.getConnection(DB_URL,DB_USER,PASSWORD);//
				stmt=conn.createStatement();
				//System.out.println("�������ݿ�ɹ�");
			}catch(Exception e) {
				e.printStackTrace();
			}
			return conn;
	 	}
	
	 public static void closeMyConnection(){//�ر����ݿ�����
			try{
				stmt.close();
				conn.close();
				//System.out.println("���ݿ��ѹر�");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	
	 
	 public static void main(String args[]) {
		 getconnection();
		 
		 closeMyConnection();
	}
	
}
