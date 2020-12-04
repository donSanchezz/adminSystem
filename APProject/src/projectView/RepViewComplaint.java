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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class RepViewComplaint extends JFrame {

	private JPanel contentPane;
	public JTextField cmpIdTxt;
	public JTextField dateTxt;
	public JTextField timeTxt;
	public JTextField typeTxt;
	public JTextField stuIdTxt;
	public JTable table;
	DefaultTableModel model;
	private JScrollPane scrollPane;
	JButton loadBttn = new JButton("Load");
	public JTextArea commentTxt = new JTextArea();
	public JComboBox statusComboBox = new JComboBox();
	JButton updateBttn = new JButton("Update");
	public JTextArea textArea =new JTextArea();
	JButton exitBttn = new JButton("Exit");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RepViewComplaint frame = new RepViewComplaint();
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
	public RepViewComplaint() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1124, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel complaintIdLbl = new JLabel("Complaint ID:");
		complaintIdLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		complaintIdLbl.setBounds(10, 26, 127, 19);
		contentPane.add(complaintIdLbl);
		
		JLabel complaintDateLbl = new JLabel(" Date:");
		complaintDateLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		complaintDateLbl.setBounds(10, 56, 127, 19);
		contentPane.add(complaintDateLbl);
		
		JLabel contactTimeLbl = new JLabel("Time:");
		contactTimeLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		contactTimeLbl.setBounds(10, 86, 127, 19);
		contentPane.add(contactTimeLbl);
		
		JLabel complaintTypeLbl = new JLabel("Complaint Type:");
		complaintTypeLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		complaintTypeLbl.setBounds(10, 116, 160, 19);
		contentPane.add(complaintTypeLbl);
		
		JLabel stuIdLbl = new JLabel("Student ID:");
		stuIdLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		stuIdLbl.setBounds(10, 146, 127, 19);
		contentPane.add(stuIdLbl);
		
		cmpIdTxt = new JTextField();
		cmpIdTxt.setEditable(false);
		cmpIdTxt.setColumns(10);
		cmpIdTxt.setBounds(147, 27, 117, 20);
		contentPane.add(cmpIdTxt);
		
		dateTxt = new JTextField();
		dateTxt.setEditable(false);
		dateTxt.setColumns(10);
		dateTxt.setBounds(147, 57, 117, 20);
		contentPane.add(dateTxt);
		
		timeTxt = new JTextField();
		timeTxt.setEditable(false);
		timeTxt.setColumns(10);
		timeTxt.setBounds(147, 87, 117, 20);
		contentPane.add(timeTxt);
		
		typeTxt = new JTextField();
		typeTxt.setEditable(false);
		typeTxt.setColumns(10);
		typeTxt.setBounds(147, 117, 117, 20);
		contentPane.add(typeTxt);
		
		stuIdTxt = new JTextField();
		stuIdTxt.setEditable(false);
		stuIdTxt.setColumns(10);
		stuIdTxt.setBounds(147, 146, 117, 20);
		contentPane.add(stuIdTxt);
		model= new DefaultTableModel();
		Object [] column = {"CmpId", "Date", "Time", "Type", "Complaint", "Stu ID", "Status"};
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
		loadBttn.setToolTipText("Populate the table with financial related complaints.");
		
	
		loadBttn.setBounds(10, 475, 89, 23);
		contentPane.add(loadBttn);
		
		JButton deleteBttn = new JButton("Delete");
		deleteBttn.setBounds(258, 475, 89, 23);
		contentPane.add(deleteBttn);
		
		
		exitBttn.setBounds(258, 509, 89, 23);
		contentPane.add(exitBttn);
		
		JButton clearBttn = new JButton("Clear");
		clearBttn.setBounds(10, 509, 89, 23);
		contentPane.add(clearBttn);
		updateBttn.setToolTipText("Adds a comment to the currently selected complaint.");
		
		
		updateBttn.setBounds(134, 475, 89, 23);
		contentPane.add(updateBttn);
		
		JLabel commentLbl = new JLabel("Comment:");
		commentLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		commentLbl.setBounds(10, 337, 127, 19);
		contentPane.add(commentLbl);
		
		commentTxt.setBounds(20, 354, 337, 91);
		contentPane.add(commentTxt);
		
		JLabel statusLbl = new JLabel("Status:");
		statusLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		statusLbl.setBounds(10, 179, 127, 19);
		contentPane.add(statusLbl);
		
		
		statusComboBox.setModel(new DefaultComboBoxModel(new String[] {"solved", "unsolved"}));
		statusComboBox.setBounds(148, 180, 116, 20);
		contentPane.add(statusComboBox);
		
		JLabel lblComplaint_1 = new JLabel("Complaint:");
		lblComplaint_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblComplaint_1.setBounds(10, 213, 127, 19);
		contentPane.add(lblComplaint_1);
		
	
		textArea.setEditable(false);
		textArea.setBounds(20, 235, 337, 91);
		contentPane.add(textArea);
		
	}
	
		public void addUpdateListener (ActionListener listenForUpdateBttn3) {
			updateBttn.addActionListener(listenForUpdateBttn3);
	}
		
		public void addLoadBttnListener (ActionListener listenForLoadBttn ) {
			loadBttn.addActionListener( listenForLoadBttn);
		}
		
		public void addUpdateListener2 (ActionListener listenForUpdateBttn2) {
			updateBttn.addActionListener(listenForUpdateBttn2);
		}
		
		public void addJTableListener (MouseListener listenForJTableClickedRep) {
			table.addMouseListener( listenForJTableClickedRep);
		}
		
		public void AddExitBtnListener (ActionListener listenForExitBttn) {
			exitBttn.addActionListener(listenForExitBttn);
		}
}

