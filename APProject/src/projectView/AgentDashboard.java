package projectView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AgentDashboard extends JFrame {

	private JPanel dashViewPane;
	private JTextField stuNameHeader;
	private JTextField finUnsolvedTxt;
	private JTextField finSolvedTxt;
	public JTextField admUnsolvedTxt;
	public JTextField admSolvedTxt;
	public JTextField hlthUnsolvedTxt;
	public JTextField hlthSolvedTxt;
	JMenuItem viewFin = new JMenuItem("View Financial");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgentDashboard frame = new AgentDashboard();
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
	public AgentDashboard() {
		setResizable(false);
		setBackground(new Color(0, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 503);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu compMenu = new JMenu("Complaint");
		menuBar.add(compMenu);
		
		JMenu viewComp = new JMenu("View Complaint");
		compMenu.add(viewComp);
		
		
		viewComp.add(viewFin);
		
		JMenuItem viewAdm = new JMenuItem("View Administration");
		viewComp.add(viewAdm);
		
		JMenuItem viewHlth = new JMenuItem("View Health");
		viewComp.add(viewHlth);
		
		JMenu queryMenu = new JMenu("Query");
		menuBar.add(queryMenu);
		
		JMenu viewQuery = new JMenu("View Query");
		queryMenu.add(viewQuery);
		
		JMenuItem viewFinQ = new JMenuItem("View Financial");
		viewQuery.add(viewFinQ);
		
		JMenuItem viewAdmQ = new JMenuItem("View Administration");
		viewQuery.add(viewAdmQ);
		
		JMenuItem viewHlthQ = new JMenuItem("View Health");
		viewQuery.add(viewHlthQ);
		
		dashViewPane = new JPanel();
		dashViewPane.setBackground(Color.LIGHT_GRAY);
		dashViewPane.setForeground(new Color(0, 0, 0));
		dashViewPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(dashViewPane);
		dashViewPane.setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(null);
		headerPanel.setBounds(0, 0, 722, 60);
		dashViewPane.add(headerPanel);
		headerPanel.setLayout(null);
		
		stuNameHeader = new JTextField();
		stuNameHeader.setBackground(Color.WHITE);
		stuNameHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		stuNameHeader.setFont(new Font("Times New Roman", Font.BOLD, 15));
		stuNameHeader.setText("Agents Name");
		stuNameHeader.setBounds(574, 0, 138, 26);
		headerPanel.add(stuNameHeader);
		stuNameHeader.setColumns(10);
		
		JLabel stuHeaderLbl = new JLabel("Student Services Agent");
		stuHeaderLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		stuHeaderLbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		stuHeaderLbl.setBounds(499, 37, 213, 23);
		headerPanel.add(stuHeaderLbl);
		
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
		
		finUnsolvedTxt = new JTextField();
		finUnsolvedTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		finUnsolvedTxt.setText("10");
		finUnsolvedTxt.setHorizontalAlignment(SwingConstants.CENTER);
		finUnsolvedTxt.setBounds(10, 66, 88, 61);
		financialPanel.add(finUnsolvedTxt);
		finUnsolvedTxt.setColumns(10);
		
		finSolvedTxt = new JTextField();
		finSolvedTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		finSolvedTxt.setText("5");
		finSolvedTxt.setHorizontalAlignment(SwingConstants.CENTER);
		finSolvedTxt.setColumns(10);
		finSolvedTxt.setBounds(157, 66, 86, 61);
		financialPanel.add(finSolvedTxt);
		
		JPanel adminPanel = new JPanel();
		adminPanel.setBounds(381, 92, 260, 150);
		dashViewPane.add(adminPanel);
		adminPanel.setLayout(null);
		
		JLabel adminLbl = new JLabel("ADMINISTRATION");
		adminLbl.setBounds(57, 5, 145, 19);
		adminLbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		adminPanel.add(adminLbl);
		
		JLabel adminUnsolvedLbl = new JLabel("UNSOLVED");
		adminUnsolvedLbl.setHorizontalAlignment(SwingConstants.CENTER);
		adminUnsolvedLbl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		adminUnsolvedLbl.setBounds(10, 35, 75, 14);
		adminPanel.add(adminUnsolvedLbl);
		
		JLabel adminSolvedLbl = new JLabel("SOLVED");
		adminSolvedLbl.setHorizontalAlignment(SwingConstants.CENTER);
		adminSolvedLbl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		adminSolvedLbl.setBounds(158, 35, 75, 14);
		adminPanel.add(adminSolvedLbl);
		
		admUnsolvedTxt = new JTextField();
		admUnsolvedTxt.setText("2");
		admUnsolvedTxt.setHorizontalAlignment(SwingConstants.CENTER);
		admUnsolvedTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		admUnsolvedTxt.setColumns(10);
		admUnsolvedTxt.setBounds(10, 60, 88, 61);
		adminPanel.add(admUnsolvedTxt);
		
		admSolvedTxt = new JTextField();
		admSolvedTxt.setText("4");
		admSolvedTxt.setHorizontalAlignment(SwingConstants.CENTER);
		admSolvedTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		admSolvedTxt.setColumns(10);
		admSolvedTxt.setBounds(158, 60, 88, 61);
		adminPanel.add(admSolvedTxt);
		
		JPanel healthPanel = new JPanel();
		healthPanel.setLayout(null);
		healthPanel.setBounds(208, 274, 260, 150);
		dashViewPane.add(healthPanel);
		
		JLabel healthLbl = new JLabel("UNSOLVED");
		healthLbl.setHorizontalAlignment(SwingConstants.CENTER);
		healthLbl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		healthLbl.setBounds(10, 41, 75, 14);
		healthPanel.add(healthLbl);
		
		JLabel healthUnsolvedLbl = new JLabel("HEALTH");
		healthUnsolvedLbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		healthUnsolvedLbl.setBounds(89, 9, 88, 19);
		healthPanel.add(healthUnsolvedLbl);
		
		JLabel healthSolvedLbl = new JLabel("SOLVED");
		healthSolvedLbl.setHorizontalAlignment(SwingConstants.CENTER);
		healthSolvedLbl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		healthSolvedLbl.setBounds(157, 41, 75, 14);
		healthPanel.add(healthSolvedLbl);
		
		hlthUnsolvedTxt = new JTextField();
		hlthUnsolvedTxt.setText("4");
		hlthUnsolvedTxt.setHorizontalAlignment(SwingConstants.CENTER);
		hlthUnsolvedTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		hlthUnsolvedTxt.setColumns(10);
		hlthUnsolvedTxt.setBounds(10, 66, 88, 61);
		healthPanel.add(hlthUnsolvedTxt);
		
		hlthSolvedTxt = new JTextField();
		hlthSolvedTxt.setText("0");
		hlthSolvedTxt.setHorizontalAlignment(SwingConstants.CENTER);
		hlthSolvedTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		hlthSolvedTxt.setColumns(10);
		hlthSolvedTxt.setBounds(157, 66, 86, 61);
		healthPanel.add(hlthSolvedTxt);
	}
	
	public void addNewComplaintListener (ActionListener listenForNewComp) {
		//newCompItem.addActionListener(listenForNewComp);
	}
	
	public void addNewQueryListener (ActionListener listenForNewQuery) {
		//newQueryItem.addActionListener(listenForNewQuery);
	}
	
	public void addViewCompListener (ActionListener listenForViewCompMenuBttn) {
		viewFin.addActionListener(listenForViewCompMenuBttn);
	}
	
	
}
