package windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import sql.UserAct;
import sql.Get;
import sql.Show_RoomTable;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class W_User_BookRoom {

	private JFrame frame;
	private JTable table;
	JScrollPane scrollPane;
	private JTextField BookRoom_No;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					W_User_BookRoom window = new W_User_BookRoom();
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
	public W_User_BookRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7533\u8BF7\u8BA2\u623F");
		frame.setBounds(100, 100, 544, 343);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		scrollPane = new JScrollPane();//添加滚动面板
		scrollPane.setBounds(14, 13, 498, 192);
		frame.getContentPane().add(scrollPane);
		
		String[] columnName = {"房间号","房间入住情况","房间清洁人员"};
		Show_RoomTable room = new Show_RoomTable();
		try {
			table = new JTable(room.User_checkRoom(),columnName);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 显示表头
		JTableHeader jth = table.getTableHeader();
		scrollPane.setViewportView(table);
		
		BookRoom_No = new JTextField();
		BookRoom_No.setBounds(178, 248, 86, 24);
		frame.getContentPane().add(BookRoom_No);
		BookRoom_No.setColumns(10);
		
		JLabel label = new JLabel("\u9884\u5B9A\u623F\u95F4\u53F7");
		label.setBounds(55, 251, 99, 18);
		frame.getContentPane().add(label);
		
		JButton SumbitNo = new JButton("\u9884\u8BA2");
		SumbitNo.setBounds(298, 247, 113, 27);
		frame.getContentPane().add(SumbitNo);
		SumbitNo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String no = BookRoom_No.getText();
				if(no == "") {
					JOptionPane.showMessageDialog(null, "房间号不能为空！！！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					UserAct BookRoom = new UserAct();
					BookRoom.User_ApplyBookRoom(no);
					BookRoom_No.setText("");
					JOptionPane.showMessageDialog(null, "已发送订房请求！！！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		frame.setVisible(true);
	}
}
