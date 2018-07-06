package com.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.DAOInterface.CRUDInterface;
import com.provider.DAOProvider;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class View extends JFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 471);
		getContentPane().setLayout(null);
		
		JButton btnLoadItems = new JButton("Load Items");
		btnLoadItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ResultSet rs=null;
				CRUDInterface cI=DAOProvider.provideCRUD();
				rs=cI.search();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		btnLoadItems.setBounds(200, 24, 117, 25);
		getContentPane().add(btnLoadItems);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 61, 493, 324);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DBManip ob=new DBManip();
				ob.setVisible(true);
			}
		});
		btnReturn.setBounds(200, 397, 117, 25);
		getContentPane().add(btnReturn);
	}
}
