package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.eclipse.ui.internal.handlers.WizardHandler.New;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class W_User_main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					W_User_main window = new W_User_main();
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
	public W_User_main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8BA2\u623F/\u9000\u623F");
		frame.setBounds(100, 100, 274, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton BookRoom = new JButton("\u8BA2\u623F");
		BookRoom.setFont(new Font("微软雅黑", Font.BOLD, 20));
		BookRoom.setBounds(72, 64, 106, 37);
		frame.getContentPane().add(BookRoom);
		BookRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new W_User_BookRoom();
				
				
			}
		});
		
		JButton button_1 = new JButton("\u9000\u623F");
		button_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		button_1.setBounds(72, 180, 106, 37);
		frame.getContentPane().add(button_1);
		frame.setVisible(true);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new W_User_UnsubscribeRoom();
				
			}
		});
	}
}
