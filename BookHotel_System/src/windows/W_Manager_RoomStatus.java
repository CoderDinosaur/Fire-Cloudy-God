package windows;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import sql.Show_RoomTable;
import sql.UserAct;
import sql.connectionSQLServer;

public class W_Manager_RoomStatus {

	private JFrame frame;
	private JTable table;
	JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					W_Manager_RoomStatus window = new W_Manager_RoomStatus();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	
	public W_Manager_RoomStatus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u623F\u95F4\u4FE1\u606F");
		frame.setBounds(100, 100, 553, 327);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		scrollPane = new JScrollPane();//��ӹ������
		scrollPane.setBounds(14, 13, 498, 214);
		frame.getContentPane().add(scrollPane);
		String[] columnName = {"�����","������ס���","����ס��","���������Ա"};
		try {
			Show_RoomTable room = new Show_RoomTable();
			table = new JTable(room.RoomStatus(),columnName);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		// ��ʾ��ͷ
		JTableHeader jth = table.getTableHeader();
		scrollPane.setViewportView(table);
		frame.setVisible(true);
	}

}
