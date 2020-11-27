package projectView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AgentViewCompaint extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameTxt;
	private JTextField textField;
	private JTextField emailTxt;
	private JTextField contactLbl;
	public JTextField cmpIdTxt;
	public JTextField dateTxt;
	public JTextField timeTxt;
	public JTextField typeTxt;
	public JTextField stuIdTxt;
	public JTable table;
	DefaultTableModel model;
	private JScrollPane scrollPane;
	JButton loadBttn = new JButton("Load");
	public JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgentViewCompaint frame = new AgentViewCompaint();
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
	public AgentViewCompaint() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1124, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel firstNameLbl = new JLabel("First Name:");
		firstNameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		firstNameLbl.setBounds(10, 11, 127, 19);
		contentPane.add(firstNameLbl);
		
		JLabel lastNameLbl = new JLabel("Last Name:");
		lastNameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		lastNameLbl.setBounds(10, 41, 127, 19);
		contentPane.add(lastNameLbl);
		
		JLabel emailLbl = new JLabel("Email:");
		emailLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLbl.setBounds(10, 71, 127, 19);
		contentPane.add(emailLbl);
		
		JLabel contactNumLbl = new JLabel("Contact Num:");
		contactNumLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		contactNumLbl.setBounds(10, 101, 127, 19);
		contentPane.add(contactNumLbl);
		
		JLabel complaintIdLbl = new JLabel("Complaint ID:");
		complaintIdLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		complaintIdLbl.setBounds(10, 144, 127, 19);
		contentPane.add(complaintIdLbl);
		
		JLabel complaintDateLbl = new JLabel(" Date:");
		complaintDateLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		complaintDateLbl.setBounds(10, 174, 127, 19);
		contentPane.add(complaintDateLbl);
		
		JLabel contactTimeLbl = new JLabel("Time:");
		contactTimeLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		contactTimeLbl.setBounds(10, 204, 127, 19);
		contentPane.add(contactTimeLbl);
		
		JLabel complaintTypeLbl = new JLabel("Complaint Type:");
		complaintTypeLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		complaintTypeLbl.setBounds(10, 234, 160, 19);
		contentPane.add(complaintTypeLbl);
		
		JLabel stuIdLbl = new JLabel("Student ID:");
		stuIdLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		stuIdLbl.setBounds(10, 264, 127, 19);
		contentPane.add(stuIdLbl);
		
		firstNameTxt = new JTextField();
		firstNameTxt.setBounds(148, 12, 116, 20);
		contentPane.add(firstNameTxt);
		firstNameTxt.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(147, 42, 117, 20);
		contentPane.add(textField);
		
		emailTxt = new JTextField();
		emailTxt.setColumns(10);
		emailTxt.setBounds(147, 72, 117, 20);
		contentPane.add(emailTxt);
		
		contactLbl = new JTextField();
		contactLbl.setColumns(10);
		contactLbl.setBounds(147, 102, 117, 20);
		contentPane.add(contactLbl);
		
		cmpIdTxt = new JTextField();
		cmpIdTxt.setColumns(10);
		cmpIdTxt.setBounds(147, 145, 117, 20);
		contentPane.add(cmpIdTxt);
		
		dateTxt = new JTextField();
		dateTxt.setColumns(10);
		dateTxt.setBounds(147, 175, 117, 20);
		contentPane.add(dateTxt);
		
		timeTxt = new JTextField();
		timeTxt.setColumns(10);
		timeTxt.setBounds(147, 205, 117, 20);
		contentPane.add(timeTxt);
		
		typeTxt = new JTextField();
		typeTxt.setColumns(10);
		typeTxt.setBounds(147, 235, 117, 20);
		contentPane.add(typeTxt);
		
		stuIdTxt = new JTextField();
		stuIdTxt.setColumns(10);
		stuIdTxt.setBounds(147, 264, 117, 20);
		contentPane.add(stuIdTxt);
		model= new DefaultTableModel();
		Object [] column = {"CmpId", "Date", "Time", "Type", "Complaint", "Stu ID"};
		Object [] row = new Object [0];
		model.setColumnIdentifiers(column);;
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 15, 718, 433);
		contentPane.add(scrollPane);
		
		table = new JTable();
		/*table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});*/
		scrollPane.setViewportView(table);
		table.setModel(model);
		
	
		loadBttn.setBounds(10, 475, 89, 23);
		contentPane.add(loadBttn);
		
		JButton deleteBttn = new JButton("Delete");
		deleteBttn.setBounds(258, 475, 89, 23);
		contentPane.add(deleteBttn);
		
		JButton exitBttn = new JButton("Exit");
		exitBttn.setBounds(258, 509, 89, 23);
		contentPane.add(exitBttn);
		
		JButton clearBttn = new JButton("Clear");
		clearBttn.setBounds(10, 509, 89, 23);
		contentPane.add(clearBttn);
		
		JButton updateBttn = new JButton("Update");
		updateBttn.setBounds(134, 475, 89, 23);
		contentPane.add(updateBttn);
		
		JLabel lblComplaint = new JLabel("Complaint:");
		lblComplaint.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblComplaint.setBounds(10, 294, 127, 19);
		contentPane.add(lblComplaint);
		
		textArea.setBounds(10, 313, 337, 135);
		contentPane.add(textArea);
		
	}
	
		public void addUpdateListener (ActionListener listenForUpdateBttn) {
		loadBttn.addActionListener(listenForUpdateBttn);
	}
		
		public void addJTableListener (MouseListener listenForJTableClicked) {
			table.addMouseListener( listenForJTableClicked);
		}
}
