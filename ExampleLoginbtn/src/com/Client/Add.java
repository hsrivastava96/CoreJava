package com.Client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.DAOInterface.*;
import com.provider.DAOProvider;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField pName;
	private JTextField hsnCode;
	private JTextField rateUnit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add() {
		JFrame frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddItem = new JLabel("Add Item");
		lblAddItem.setBounds(175, 38, 70, 15);
		contentPane.add(lblAddItem);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(44, 73, 115, 15);
		contentPane.add(lblProductName);
		
		pName = new JTextField();
		pName.setBounds(241, 65, 142, 32);
		contentPane.add(pName);
		pName.setColumns(10);
		
		JLabel lblHsnCode = new JLabel("HSN Code");
		lblHsnCode.setBounds(44, 117, 70, 15);
		contentPane.add(lblHsnCode);
		
		hsnCode = new JTextField();
		hsnCode.setBounds(241, 109, 142, 32);
		contentPane.add(hsnCode);
		hsnCode.setColumns(10);
		
		JLabel lblRateunit = new JLabel("Rate/unit");
		lblRateunit.setBounds(44, 156, 70, 15);
		contentPane.add(lblRateunit);
		
		rateUnit = new JTextField();
		rateUnit.setBounds(241, 148, 142, 32);
		contentPane.add(rateUnit);
		rateUnit.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String pNm=pName.getText();
				String hsnC=hsnCode.getText();
				String rUnit=rateUnit.getText();
				Add ad=new Add();
				int rate, hc;
				rate=ad.atoi(rUnit);
				hc=ad.atoi(hsnC);
				CRUDInterface cI=DAOProvider.provideCRUD();
				cI.insert(pNm, hc, rate);
				JOptionPane.showMessageDialog(frame, "Item inserted");
				DBManip obj=new DBManip();
				obj.setVisible(true);
			}
		});
		btnAdd.setBounds(152, 192, 117, 25);
		contentPane.add(btnAdd);
	}

}
