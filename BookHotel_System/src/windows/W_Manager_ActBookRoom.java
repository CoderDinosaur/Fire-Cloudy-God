package windows;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import sql.UserAct;
import sql.ManagerAct;
import sql.Show_RoomTable;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class W_Manager_ActBookRoom {

	private JFrame frame;
	private JTable table;
	JScrollPane scrollPane;
	private JTextField NoField;
	private JLabel lblNewLabel;
	private JLabel label;
	private JTextField NameField;
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
					W_Manager_ActBookRoom window = new W_Manager_ActBookRoom();
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
	public W_Manager_ActBookRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8BA2\u623F\u7BA1\u7406");
		frame.setBounds(100, 100, 545, 367);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		scrollPane = new JScrollPane();//添加滚动面板
		scrollPane.setBounds(14, 13, 498, 192);
		frame.getContentPane().add(scrollPane);
		
		String[] columnName = {"预定房间号","用户名","顾客姓名"};
		Show_RoomTable room = new Show_RoomTable();
		try {
			table = new JTable(room.Act_ApplyBookRoom(),columnName);
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
		
		label = new JLabel("\u987E\u5BA2\u59D3\u540D");
		label.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label.setBounds(209, 241, 102, 39);
		frame.getContentPane().add(label);
		
		NoField = new JTextField();
		NoField.setBounds(89, 251, 86, 24);
		frame.getContentPane().add(NoField);
		NoField.setColumns(10);
			
		
		NameField = new JTextField();
		NameField.setColumns(10);
		NameField.setBounds(310, 251, 86, 24);
		frame.getContentPane().add(NameField);
		
		button = new JButton("\u786E\u8BA4\u8BA2\u623F");
		button.setBounds(400, 280, 113, 27);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					RoomNo= NoField.getText();	
					name=NameField.getText();
					ManagerAct Act = new ManagerAct();
					Act.Confirm_BookRoom(RoomNo,name);
					Act.Delete_BookApply(RoomNo,name);
					JOptionPane.showMessageDialog(null, "操作成功！！！", "提示", JOptionPane.INFORMATION_MESSAGE);
					table.validate();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
		});
		frame.setVisible(true);
	}

}
