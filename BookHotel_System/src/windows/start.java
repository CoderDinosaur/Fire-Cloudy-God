package windows;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//程序主入口
public class start {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start window = new start();
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
	public start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7A0B\u5E8F\u5165\u53E3");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton userButton = new JButton("\u987E\u5BA2\u767B\u5F55");
		userButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		userButton.setBounds(50, 92, 121, 44);
		frame.getContentPane().add(userButton);
		userButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				new W_User_Loading();	//用户登录注册界面
				
				frame.setVisible(false);// 本窗口隐藏,
				frame.dispose();//本窗口销毁,释放内存资源
			}
		});
		
		
		JButton managerButton = new JButton("\u7BA1\u7406\u8005\u767B\u5F55");
		managerButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		managerButton.setBounds(255, 92, 143, 44);
		frame.getContentPane().add(managerButton);
		managerButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				new W_Manager_main();	//管理者功能界面	
				
				frame.setVisible(false);// 本窗口隐藏,
				frame.dispose();//本窗口销毁,释放内存资源
				
			}
		});
		
	
		
	}
}
