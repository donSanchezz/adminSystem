package projectView;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import projectModel.DateTime;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class newComplaint extends JFrame {

	private JPanel complaintPane;
	public JTextField stuIdTxtField;
	public JTextField dateTxtField;
	public JTextField timeTxtField;
	public JButton clearBttn = new JButton("Clear");
	public JButton exitBttn = new JButton("Exit");
	public JTextArea compTxtArea = new JTextArea();
	public JComboBox compCmbBox = new JComboBox();
	JButton submitBttn = new JButton("Submit");
	/**
	 * Launch the application.
	 */
	
	DateTime dt = new DateTime();
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newComplaint frame = new newComplaint();
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
	public newComplaint() {
		setResizable(false);
		setTitle("Complaint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 503);
		complaintPane = new JPanel();
		complaintPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(complaintPane);
		complaintPane.setLayout(null);
		
		JLabel headerLbl = new JLabel("New Complaint");
		headerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		headerLbl.setFont(new Font("Tahoma", Font.PLAIN, 21));
		headerLbl.setBounds(188, 11, 294, 19);
		complaintPane.add(headerLbl);
		
		JLabel complaintTypeLbl = new JLabel("Complaint Type:");
		complaintTypeLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		complaintTypeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		complaintTypeLbl.setBounds(55, 198, 127, 14);
		complaintPane.add(complaintTypeLbl);
		
		JLabel lblComplaint = new JLabel("Complaint:");
		lblComplaint.setHorizontalAlignment(SwingConstants.LEFT);
		lblComplaint.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblComplaint.setBounds(55, 245, 127, 14);
		complaintPane.add(lblComplaint);
		
		JLabel dateLbl = new JLabel("Date:");
		dateLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		dateLbl.setHorizontalAlignment(SwingConstants.LEFT);
		dateLbl.setBounds(55, 105, 46, 14);
		complaintPane.add(dateLbl);
		
		JLabel timeLbl = new JLabel("Time:");
		timeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		timeLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		timeLbl.setBounds(55, 148, 46, 14);
		complaintPane.add(timeLbl);
		
		JLabel studentId = new JLabel("Student ID:");
		studentId.setHorizontalAlignment(SwingConstants.LEFT);
		studentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		studentId.setBounds(55, 60, 94, 14);
		complaintPane.add(studentId);
		
		stuIdTxtField = new JTextField();
		stuIdTxtField.setBounds(233, 59, 147, 20);
		complaintPane.add(stuIdTxtField);
		stuIdTxtField.setColumns(10);
		
		dateTxtField = new JTextField();
		dateTxtField.setText(dt.Date());
		dateTxtField.setEditable(false);
		dateTxtField.setColumns(10);
		dateTxtField.setBounds(233, 104, 147, 20);
		complaintPane.add(dateTxtField);
		
		timeTxtField = new JTextField();
		timeTxtField.setEditable(false);
		timeTxtField.setText(dt.Time());
		timeTxtField.setColumns(10);
		timeTxtField.setBounds(233, 147, 147, 20);
		complaintPane.add(timeTxtField);
		
	
		compCmbBox.setModel(new DefaultComboBoxModel(new String[] {"Financial", "Administration", "Student Services"}));
		compCmbBox.setBounds(233, 197, 147, 20);
		complaintPane.add(compCmbBox);
		
		
		compTxtArea.setLineWrap(true);
		compTxtArea.setBounds(55, 270, 603, 125);
		complaintPane.add(compTxtArea);
		
		
		submitBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		submitBttn.setBounds(55, 416, 89, 23);
		complaintPane.add(submitBttn);
		
		clearBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearBttn.setBounds(176, 416, 89, 23);
		complaintPane.add(clearBttn);
		
		exitBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		exitBttn.setBounds(569, 416, 89, 23);
		complaintPane.add(exitBttn);
	}
	
	
	public void addClearListenerC (ActionListener listenForClearBttnC) {
		clearBttn.addActionListener(listenForClearBttnC);

		
	}

	public void addExitListenerC (ActionListener listenForExitBttnC) {
		exitBttn.addActionListener(listenForExitBttnC);
	}
	
	public void addSubmitListenerC (ActionListener listenForSubmitBttnC) {
		submitBttn.addActionListener(listenForSubmitBttnC);
	}
	
	
	

}
