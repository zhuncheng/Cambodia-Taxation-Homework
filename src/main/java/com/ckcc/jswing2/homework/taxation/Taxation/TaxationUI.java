package com.ckcc.jswing2.homework.taxation.Taxation;

import java.awt.EventQueue;

import java.awt.Frame;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class TaxationUI implements TreeSelectionListener, ActionListener {

	private JFrame frame;
	private JMenuBar menuBar;
	private JTree tree;
	private JSplitPane sltPaneLeft, slpPaneRight;
	private JSplitPane splitPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxationUI window = new TaxationUI();
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
	public TaxationUI() {
		initialize();
	}

	
	public void createMenuBar() {
		menuBar = new JMenuBar();
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEmployeeMgt = new JMenu("Employee Mgt");
		menuBar.add(mnEmployeeMgt);
		
		JMenuItem mntmNewEmployee = new JMenuItem("New Employee");
		mnEmployeeMgt.add(mntmNewEmployee);
		
		JMenuItem mntmListOfEmployee = new JMenuItem("List Of Employee");
		mnEmployeeMgt.add(mntmListOfEmployee);
		
		JMenu mnReport = new JMenu("Report");
		menuBar.add(mnReport);
		
		JMenuItem mntmEmployeeTaxReport = new JMenuItem("Employee Tax Report");
		mnReport.add(mntmEmployeeTaxReport);
		
		JMenu mnTaxRule = new JMenu("Tax Rule");
		menuBar.add(mnTaxRule);
		
		JMenuItem mntmTaxRule = new JMenuItem("Tax Rule 2018");
		mnTaxRule.add(mntmTaxRule);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmWelcome = new JMenuItem("Welcome");
		mnHelp.add(mntmWelcome);
		
		JMenuItem mntmHelpContents = new JMenuItem("Help Contents");
		mnHelp.add(mntmHelpContents);
		
		JSeparator separator_1 = new JSeparator();
		mnHelp.add(separator_1);
		
		JMenuItem mntmCheckForUpdate = new JMenuItem("Check For Update");
		mnHelp.add(mntmCheckForUpdate);
		
		JMenuItem mntmAboutEmployeeMgt = new JMenuItem("About Employee Mgt");
		mnHelp.add(mntmAboutEmployeeMgt);

		mntmNew.addActionListener(this);
		mntmOpen.addActionListener(this);
		mntmExit.addActionListener(this);
		mntmNewEmployee.addActionListener(this);
		mntmListOfEmployee.addActionListener(this);
		mntmEmployeeTaxReport.addActionListener(this);
		mntmTaxRule.addActionListener(this);
		mntmWelcome.addActionListener(this);
		mntmHelpContents.addActionListener(this);
		mntmAboutEmployeeMgt.addActionListener(this);
		mntmCheckForUpdate.addActionListener(this);
		
	}
	
	public void createJTree() {
		DefaultMutableTreeNode employeeMgtTree = new DefaultMutableTreeNode("Employee Mgt");
		DefaultMutableTreeNode newEmployeeTree = new DefaultMutableTreeNode("New Employee");
		DefaultMutableTreeNode lstEmployeeTree = new DefaultMutableTreeNode("List of Employee");
		employeeMgtTree.add(newEmployeeTree); employeeMgtTree.add(lstEmployeeTree);
	
		DefaultMutableTreeNode reportTree = new DefaultMutableTreeNode("Report");
		DefaultMutableTreeNode employeeTaxReportTree = new DefaultMutableTreeNode("Report");
		reportTree.add(employeeTaxReportTree);
		
		DefaultMutableTreeNode taxRuleTree = new DefaultMutableTreeNode("Tax Rule");
		DefaultMutableTreeNode taxRule18Tree = new DefaultMutableTreeNode("Tax Rule 2018");
		DefaultMutableTreeNode taxCalculateTree = new DefaultMutableTreeNode("Tax Calculate");
		taxRuleTree.add(taxRule18Tree); taxRuleTree.add(taxCalculateTree);
		
		DefaultMutableTreeNode root= new DefaultMutableTreeNode();
		
		root.add(employeeMgtTree);
		root.add(reportTree);
		root.add(taxRuleTree);

		tree = new JTree(root);
		tree.addTreeSelectionListener(this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 470, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//add menuBar to North
		this.createMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		//add Splitpane
		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.10);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		//add tree to left splitpane
		this.createJTree();
		splitPane.setLeftComponent(tree);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);	

		}

	public void valueChanged(TreeSelectionEvent arg0) {
		if(tree.getLastSelectedPathComponent().toString().equals("New Employee")) {
			
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
