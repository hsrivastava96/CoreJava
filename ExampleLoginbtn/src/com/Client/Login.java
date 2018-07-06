package com.Client;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(38, 67, 136, 45);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(38, 124, 70, 38);
		frame.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setBounds(170, 74, 148, 32);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String uname=username.getText();
				String pwd=password.getText();
				
				if(uname.equals("admin") && pwd.equals("admin@123"))
				{
					JOptionPane.showMessageDialog(frame, "You are successfully logged in!");
					DBManip ob=new DBManip();
					ob.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
			}
		});
		btnLogin.setBounds(104, 174, 117, 32);
		frame.getContentPane().add(btnLogin);
		
		password = new JPasswordField();
		password.setBounds(170, 125, 148, 32);
		frame.getContentPane().add(password);
	}
}
