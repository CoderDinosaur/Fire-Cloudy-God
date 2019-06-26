package windows;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import sql.UserAct;
import sql.Get;
import sql.ManagerAct;
import sql.Show_RoomTable;

public class W_User_UnsubscribeRoom {

	private JFrame frame;
	private JTable table;
	JScrollPane scrollPane;
	private JTextField NoField;
	private JLabel lblNewLabel;
	private JButton button;
	String RoomNo;
	String name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					W_User_UnsubscribeRoom window = new W_User_UnsubscribeRoom();
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
	public W_User_UnsubscribeRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7533\u8BF7\u9000\u623F");
		frame.setBounds(100, 100, 546, 377);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		scrollPane = new JScrollPane();//添加滚动面板
		scrollPane.setBounds(14, 13, 498, 192);
		frame.getContentPane().add(scrollPane);
		
		String[] columnName = {"房间号","顾客姓名"};
		Show_RoomTable room = new Show_RoomTable();
		try {
			table = new JTable(room.User_UnsubscribeRoom(),columnName);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 显示表头
		JTableHeader jth = table.getTableHeader();
		scrollPane.setViewportView(table);
		lblNewLabel = new JLabel("\u623F\u95F4\u53F7");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblNewLabel.setBounds(14, 241, 72, 39);
		frame.getContentPane().add(lblNewLabel);
		
		NoField = new JTextField();
		NoField.setBounds(89, 251, 86, 24);
		frame.getContentPane().add(NoField);
		NoField.setColumns(10);
		
		button = new JButton("\u7533\u8BF7\u9000\u623F");
		button.setBounds(400, 280, 113, 27);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					RoomNo= NoField.getText();	
					name=Get.name;
					UserAct tempActRoom = new UserAct();
					tempActRoom.User_ApplyUnsubscribeRoom(RoomNo);
					JOptionPane.showMessageDialog(null, "操作成功！！！", "提示", JOptionPane.INFORMATION_MESSAGE);
					table.validate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.setVisible(true);
	}

}
