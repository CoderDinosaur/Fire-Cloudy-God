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
import sql.ManagerAct;
import sql.Show_RoomTable;

public class W_Manager_ActUnsubscribeRoom {

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
					W_Manager_ActUnsubscribeRoom window = new W_Manager_ActUnsubscribeRoom();
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
	public W_Manager_ActUnsubscribeRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u9000\u623F\u7BA1\u7406");
		frame.setBounds(100, 100, 546, 377);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		scrollPane = new JScrollPane();//��ӹ������
		scrollPane.setBounds(14, 13, 498, 192);
		frame.getContentPane().add(scrollPane);
		
		String[] columnName = {"�˶������","�û���","�˿�����"};
		Show_RoomTable room = new Show_RoomTable();
		try {
			table = new JTable(room.Act_ApplyUnsubscribeRoom(),columnName);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		// ��ʾ��ͷ
		JTableHeader jth = table.getTableHeader();
		scrollPane.setViewportView(table);
		lblNewLabel = new JLabel("\u623F\u95F4\u53F7");
		lblNewLabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lblNewLabel.setBounds(14, 241, 72, 39);
		frame.getContentPane().add(lblNewLabel);
		
		label = new JLabel("\u987E\u5BA2\u59D3\u540D");
		label.setFont(new Font("΢���ź�", Font.BOLD, 20));
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
		
		button = new JButton("\u786E\u8BA4\u9000\u623F");
		button.setBounds(400, 280, 113, 27);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					RoomNo= NoField.getText();	
					name=NameField.getText();
					ManagerAct Act = new ManagerAct();
					Act.Confirm_UnsubscribeRoom(RoomNo,name);
					Act.Delete_UnsubscribeApply(RoomNo,name);
					JOptionPane.showMessageDialog(null, "�����ɹ�������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					table.validate();
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
			}
		});
		frame.setVisible(true);
	}

}
