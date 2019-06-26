package windows;
import sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class W_User_Loading {

	public static JFrame frame;
	private JTextField usernameField;
	private JTextField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					W_User_Loading window = new W_User_Loading();
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
	public W_User_Loading() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setTitle("\u7528\u6237\u767B\u5F55");
		frame.setBounds(100, 100, 559, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 25));
		lblNewLabel.setBounds(74, 66, 108, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 25));
		label.setBounds(85, 170, 67, 37);
		frame.getContentPane().add(label);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(277, 78, 188, 37);
		frame.getContentPane().add(usernameField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(277, 175, 188, 37);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(112, 290, 113, 37);
		frame.getContentPane().add(button);
		
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//»ñÈ¡ÕËºÅ
				String username = usernameField.getText();
				//»ñÈ¡ÃÜÂë
				String password = passwordField.getText();
				UserLoading user = new UserLoading();
				try {
					user.SignIn(username,password);
					frame.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		
		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		button_1.setBackground(SystemColor.activeCaption);
		button_1.setBounds(319, 290, 113, 37);
		frame.getContentPane().add(button_1);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO ×Ô¶¯Éú³ÉµÄ·½·¨´æ¸ù
				new W_User_Registered();
			}
		});
		
		
	}
}
