package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import sql.InsertUser;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class W_User_Registered {

	public static  JFrame frame;
	private JTextField temp_username;
	private JTextField temp_password;
	private JTextField temp_name;
	private JTextField temp_sex;
	private JTextField temp_mobilephone;
	private JTextField temp_IDCardNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					W_User_Registered window = new W_User_Registered();
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
	public W_User_Registered() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7528\u6237\u6CE8\u518C");
		frame.setBounds(100, 100, 458, 583);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(36, 53, 108, 50);
		label.setFont(new Font("微软雅黑", Font.BOLD, 25));
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(36, 116, 108, 50);
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 25));
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u59D3\u540D");
		label_2.setBounds(36, 179, 108, 50);
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 25));
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u6027\u522B");
		label_3.setBounds(36, 242, 108, 50);
		label_3.setFont(new Font("微软雅黑", Font.BOLD, 25));
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u624B\u673A\u53F7");
		label_4.setBounds(36, 305, 108, 50);
		label_4.setFont(new Font("微软雅黑", Font.BOLD, 25));
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_5.setBounds(36, 368, 108, 50);
		label_5.setFont(new Font("微软雅黑", Font.BOLD, 25));
		frame.getContentPane().add(label_5);
		
		temp_username = new JTextField();
		temp_username.setBounds(186, 65, 188, 37);
		temp_username.setColumns(10);
		frame.getContentPane().add(temp_username);
		
		
		temp_password = new JTextField();
		temp_password.setBounds(186, 128, 188, 37);
		temp_password.setColumns(10);
		frame.getContentPane().add(temp_password);
		
		
		temp_name = new JTextField();
		temp_name.setBounds(186, 191, 188, 37);
		temp_name.setColumns(10);
		frame.getContentPane().add(temp_name);
		
		
		temp_sex = new JTextField();
		temp_sex.setBounds(186, 254, 188, 37);
		temp_sex.setColumns(10);
		frame.getContentPane().add(temp_sex);
		
		
		temp_mobilephone = new JTextField();
		temp_mobilephone.setBounds(186, 317, 188, 37);
		temp_mobilephone.setColumns(10);
		frame.getContentPane().add(temp_mobilephone);
		
		
		temp_IDCardNo = new JTextField();
		temp_IDCardNo.setBounds(186, 380, 188, 37);
		temp_IDCardNo.setColumns(10);
		frame.getContentPane().add(temp_IDCardNo);
		
		
		JButton button = new JButton("\u6CE8\u518C");
		button.setBounds(108, 468, 113, 37);
		button.setFont(new Font("微软雅黑", Font.BOLD, 20));
		button.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(button);
		
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				String username = temp_username.getText();
				String password = temp_password.getText();
				String name = temp_name.getText();
				String sex = temp_sex.getText();
				String mobilephone = temp_mobilephone.getText();
				String IDCardNo = temp_IDCardNo.getText();
				
				InsertUser temp = new InsertUser();
				try {
						if(temp.checkUser(username)) {
							JOptionPane.showMessageDialog(null, "该用户已存在！！！", "提示", JOptionPane.INFORMATION_MESSAGE);
							temp_username.setText("");
						}
						else {
							temp.registered(username,password,name,sex, mobilephone,IDCardNo);
							}
						
					
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		
		
		
		frame.setVisible(true);
	}
}
