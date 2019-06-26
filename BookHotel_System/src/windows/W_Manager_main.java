package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class W_Manager_main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					W_Manager_main window = new W_Manager_main();
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
	public W_Manager_main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7BA1\u7406\u8005");
		frame.setBounds(100, 100, 347, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton RoomStatus = new JButton("\u623F\u95F4\u72B6\u6001");
		RoomStatus.setFont(new Font("微软雅黑", Font.BOLD, 20));
		RoomStatus.setBounds(96, 76, 136, 27);
		frame.getContentPane().add(RoomStatus);
		RoomStatus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new W_Manager_RoomStatus();
				
			}
		});
		
		JButton ActBookRoom = new JButton("\u5904\u7406\u8BA2\u623F");
		ActBookRoom.setFont(new Font("微软雅黑", Font.BOLD, 20));
		ActBookRoom.setBounds(96, 170, 136, 27);
		frame.getContentPane().add(ActBookRoom);
		ActBookRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new  W_Manager_ActBookRoom();
			}
		});
		
		
		JButton UnsubscribeRoom = new JButton("\u5904\u7406\u9000\u623F");
		UnsubscribeRoom.setFont(new Font("微软雅黑", Font.BOLD, 20));
		UnsubscribeRoom.setBounds(96, 265, 136, 27);
		frame.getContentPane().add(UnsubscribeRoom);
		UnsubscribeRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new W_Manager_ActUnsubscribeRoom();
			}
		});
		frame.setVisible(true);
	}

}
