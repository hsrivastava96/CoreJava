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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField hsnCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		JFrame frame=new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemove = new JLabel("Remove");
		lblRemove.setBounds(187, 33, 70, 15);
		contentPane.add(lblRemove);
		
		JLabel lblHsnCode = new JLabel("HSN Code");
		lblHsnCode.setBounds(33, 119, 70, 15);
		contentPane.add(lblHsnCode);
		
		JLabel lblEnterTheHsn = new JLabel("Enter the HSN Code of Item to be deleted");
		lblEnterTheHsn.setBounds(72, 69, 300, 15);
		contentPane.add(lblEnterTheHsn);
		
		hsnCode = new JTextField();
		hsnCode.setBounds(187, 106, 184, 30);
		contentPane.add(hsnCode);
		hsnCode.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String hsnC=hsnCode.getText();
				Delete dl=new Delete();
				int hsn=dl.atoi(hsnC);
				CRUDInterface cI=DAOProvider.provideCRUD();
				cI.remove(hsn);
				JOptionPane.showMessageDialog(frame,"Item has been deleted successfully!");
				DBManip obj=new DBManip();
				obj.setVisible(true);
			}
		});
		btnDelete.setBounds(148, 165, 117, 25);
		contentPane.add(btnDelete);
	}

}
