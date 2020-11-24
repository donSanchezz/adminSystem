package projectView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import projectModel.DateTime;

public class newQuery extends JFrame {


	private JPanel queryPane;
	public JTextField stuIdTxtField;
	public JTextField dateTxtField;
	public  JTextField timeTxtField;
	public JButton clearBttn = new JButton("Clear");
	public JButton exitBttn = new JButton("Exit");
	public JTextArea queryTxtArea = new JTextArea();
	public JComboBox queryCmbBox = new JComboBox();
	JButton submitBttn = new JButton("Submit");

	
	DateTime dt = new DateTime();
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newQuery frame = new newQuery();
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
	public newQuery() {
		setResizable(false);
		setTitle("Complaint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 503);
		queryPane = new JPanel();
		queryPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(queryPane);
		queryPane.setLayout(null);
		
		JLabel headerLbl = new JLabel("New Query");
		headerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		headerLbl.setFont(new Font("Tahoma", Font.PLAIN, 21));
		headerLbl.setBounds(188, 11, 294, 19);
		queryPane.add(headerLbl);
		
		JLabel queryTypeLbl = new JLabel("Query Type:");
		queryTypeLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		queryTypeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		queryTypeLbl.setBounds(55, 197, 127, 20);
		queryPane.add(queryTypeLbl);
		
		JLabel lblQuery = new JLabel("Query:");
		lblQuery.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuery.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuery.setBounds(55, 245, 127, 20);
		queryPane.add(lblQuery);
		
		JLabel dateLbl = new JLabel("Date:");
		dateLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		dateLbl.setHorizontalAlignment(SwingConstants.LEFT);
		dateLbl.setBounds(55, 105, 46, 14);
		queryPane.add(dateLbl);
		
		JLabel timeLbl = new JLabel("Time:");
		timeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		timeLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		timeLbl.setBounds(55, 148, 46, 14);
		queryPane.add(timeLbl);
		
		JLabel studentId = new JLabel("Student ID:");
		studentId.setHorizontalAlignment(SwingConstants.LEFT);
		studentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		studentId.setBounds(55, 60, 94, 14);
		queryPane.add(studentId);
		
		stuIdTxtField = new JTextField();
		stuIdTxtField.setBounds(233, 59, 147, 20);
		queryPane.add(stuIdTxtField);
		stuIdTxtField.setColumns(10);
		
		dateTxtField = new JTextField();
		dateTxtField.setText(dt.Date());
		dateTxtField.setEditable(false);
		dateTxtField.setColumns(10);
		dateTxtField.setBounds(233, 104, 147, 20);
		queryPane.add(dateTxtField);
		
		timeTxtField = new JTextField();
		timeTxtField.setEditable(false);
		timeTxtField.setText(dt.Time());
		timeTxtField.setColumns(10);
		timeTxtField.setBounds(233, 147, 147, 20);
		queryPane.add(timeTxtField);
		
	
		queryCmbBox.setModel(new DefaultComboBoxModel(new String[] {"Financial", "Administration", "Student Services"}));
		queryCmbBox.setBounds(233, 197, 147, 20);
		queryPane.add(queryCmbBox);
		
		
		queryTxtArea.setLineWrap(true);
		queryTxtArea.setBounds(55, 270, 603, 125);
		queryPane.add(queryTxtArea);
		
		
		submitBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		submitBttn.setBounds(55, 416, 89, 23);
		queryPane.add(submitBttn);
		
		clearBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearBttn.setBounds(176, 416, 89, 23);
		queryPane.add(clearBttn);
		
		exitBttn.setFont(new Font("Tahoma", Font.BOLD, 15));
		exitBttn.setBounds(569, 416, 89, 23);
		queryPane.add(exitBttn);
	}
	

	public void addClearListenerQ (ActionListener listenForClearBttnQ) {
		clearBttn.addActionListener(listenForClearBttnQ);

		
	}

	public void addExitListenerQ (ActionListener listenForExitBttnQ) {
		exitBttn.addActionListener(listenForExitBttnQ);
	}
	
	public void addSubmitListenerQ (ActionListener listenForSubmitBttnQ) {
		submitBttn.addActionListener(listenForSubmitBttnQ);
	}

}
