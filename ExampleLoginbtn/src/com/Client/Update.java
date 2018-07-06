package com.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.DAOInterface.CRUDInterface;
import com.provider.DAOProvider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField oldHSN;
	private JTextField newHSN;
	private JTextField newPName;
	private JTextField newRate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public int atoi(String str) {
		if (str == null || str.length() < 1)
			return 0;
	 
		// trim white spaces
		str = str.trim();
	 
		char flag = '+';
	 
		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;
	 
		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
	 
		if (flag == '-')
			result = -result;
	 
		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	 
		return (int) result;
	}


	/**
	 * Create the frame.
	 */
	public Update() {
		JFrame frame=new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setBounds(215, 26, 70, 15);
		contentPane.add(lblUpdate);
		
		oldHSN = new JTextField();
		oldHSN.setBounds(302, 70, 142, 37);
		contentPane.add(oldHSN);
		oldHSN.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String oldH=oldHSN.getText();
				String newH=newHSN.getText();
				String newPn=newPName.getText();
				String newR=newRate.getText();
				Update ob=new Update();
				int oH, nH, nR;
				oH=ob.atoi(oldH);
				nH=ob.atoi(newH);
				nR=ob.atoi(newR);
				CRUDInterface cI=DAOProvider.provideCRUD();
				cI.update(oH, nH, newPn, nR);
				JOptionPane.showMessageDialog(frame, "Information Updated Successfully!");
				DBManip obj=new DBManip();
				obj.setVisible(true);
			}
		});
		btnUpdate.setBounds(187, 332, 117, 25);
		contentPane.add(btnUpdate);
		
		JLabel lblOldHsnCode = new JLabel("Old HSN Code");
		lblOldHsnCode.setBounds(67, 81, 97, 15);
		contentPane.add(lblOldHsnCode);
		
		JLabel lblNewHsnCode = new JLabel("New HSN Code");
		lblNewHsnCode.setBounds(67, 122, 122, 15);
		contentPane.add(lblNewHsnCode);
		
		newHSN = new JTextField();
		newHSN.setBounds(302, 119, 142, 37);
		contentPane.add(newHSN);
		newHSN.setColumns(10);
		
		JLabel lblNewProductName = new JLabel("New Product Name");
		lblNewProductName.setBounds(67, 172, 148, 15);
		contentPane.add(lblNewProductName);
		
		newPName = new JTextField();
		newPName.setBounds(302, 168, 142, 37);
		contentPane.add(newPName);
		newPName.setColumns(10);
		
		JLabel lblNewRateunit = new JLabel("New Rate/unit");
		lblNewRateunit.setBounds(67, 235, 122, 15);
		contentPane.add(lblNewRateunit);
		
		newRate = new JTextField();
		newRate.setBounds(302, 217, 142, 37);
		contentPane.add(newRate);
		newRate.setColumns(10);
	}
}
