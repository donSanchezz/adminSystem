package projectView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

public class StuDashboard extends JFrame {

	private JPanel dashViewPane;
	private JTextField stuNameHeader;
	private JTextField unsolvedTxt;
	private JTextField solvedTxt;
	JMenuItem newCompItem = new JMenuItem("New complaint");
	JMenuItem newQueryItem = new JMenuItem("New query");
	JMenuItem viewQueryItem = new JMenuItem("View query");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuDashboard frame = new StuDashboard();
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
	public StuDashboard() {
		setResizable(false);
		setBackground(new Color(0, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 503);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu compMenu = new JMenu("Complaint");
		menuBar.add(compMenu);
		
	
		compMenu.add(newCompItem);
		
		JMenuItem viewCompItem = new JMenuItem("View complaint");
		compMenu.add(viewCompItem);
		
		JMenu queryMenu = new JMenu("Query");
		menuBar.add(queryMenu);
		

		queryMenu.add(newQueryItem);
		queryMenu.add(viewQueryItem);
		
		dashViewPane = new JPanel();
		dashViewPane.setBackground(Color.LIGHT_GRAY);
		dashViewPane.setForeground(new Color(0, 0, 0));
		dashViewPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(dashViewPane);
		dashViewPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 710, 60);
		dashViewPane.add(panel);
		panel.setLayout(null);
		
		stuNameHeader = new JTextField();
		stuNameHeader.setBackground(Color.WHITE);
		stuNameHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		stuNameHeader.setFont(new Font("Times New Roman", Font.BOLD, 15));
		stuNameHeader.setText("Student Name");
		stuNameHeader.setBounds(562, 0, 138, 26);
		panel.add(stuNameHeader);
		stuNameHeader.setColumns(10);
		
		JLabel stuHeaderLbl = new JLabel("Student");
		stuHeaderLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		stuHeaderLbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		stuHeaderLbl.setBounds(572, 37, 128, 23);
		panel.add(stuHeaderLbl);
		
		JPanel financialPanel = new JPanel();
		financialPanel.setBounds(62, 92, 260, 150);
		dashViewPane.add(financialPanel);
		financialPanel.setLayout(null);
		
		JLabel unsolvedLbl = new JLabel("UNSOLVED");
		unsolvedLbl.setHorizontalAlignment(SwingConstants.CENTER);
		unsolvedLbl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		unsolvedLbl.setBounds(10, 41, 75, 14);
		financialPanel.add(unsolvedLbl);
		
		JLabel financialLbl = new JLabel("FINANCIAL");
		financialLbl.setBounds(89, 9, 88, 19);
		financialLbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		financialPanel.add(financialLbl);
		
		JLabel solvedLbl = new JLabel("SOLVED");
		solvedLbl.setHorizontalAlignment(SwingConstants.CENTER);
		solvedLbl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		solvedLbl.setBounds(157, 41, 75, 14);
		financialPanel.add(solvedLbl);
		
		unsolvedTxt = new JTextField();
		unsolvedTxt.setBounds(10, 66, 88, 61);
		financialPanel.add(unsolvedTxt);
		unsolvedTxt.setColumns(10);
		
		solvedTxt = new JTextField();
		solvedTxt.setColumns(10);
		solvedTxt.setBounds(157, 66, 86, 61);
		financialPanel.add(solvedTxt);
		
		JPanel adminPanel = new JPanel();
		adminPanel.setBounds(381, 92, 260, 150);
		dashViewPane.add(adminPanel);
		
		JLabel adminLbl = new JLabel("ADMINISTRATION");
		adminLbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		adminPanel.add(adminLbl);
	}
	
	public void addNewComplaintListener (ActionListener listenForNewComp) {
		newCompItem.addActionListener(listenForNewComp);
	}
	
	public void addNewQueryListener (ActionListener listenForNewQuery) {
		newQueryItem.addActionListener(listenForNewQuery);
	}
	
	
}
