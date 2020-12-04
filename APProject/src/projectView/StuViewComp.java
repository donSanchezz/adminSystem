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
import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class StuViewComp extends JFrame {

	private JPanel contentPane;
	public JTextField cmpIdTxt;
	public JTable table;
	DefaultTableModel model, model2;
	private JScrollPane scrollPane;
	JButton loadBttn = new JButton("Load");
	JButton updateBttn = new JButton("Update");
	public JTable table_1;
	JButton exitBttn = new JButton("Exit");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuViewComp frame = new StuViewComp();
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
	public StuViewComp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1124, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel complaintIdLbl = new JLabel("Complaint ID:");
		complaintIdLbl.setBounds(10, 26, 127, 19);
		complaintIdLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(complaintIdLbl);
		
		cmpIdTxt = new JTextField();
		cmpIdTxt.setBounds(147, 27, 117, 20);
		cmpIdTxt.setEditable(false);
		cmpIdTxt.setColumns(10);
		contentPane.add(cmpIdTxt);
		
		
		model= new DefaultTableModel();
		Object [] column = {"CmpId", "Date", "Time", "Type", "Complaint"};
		//Object [] row = new Object [0];
		model.setColumnIdentifiers(column);;
		
		model2 = new DefaultTableModel();
		Object [] column2 = {"ID", "Date", "Time", "Comment", "CmpID", "RepID","FName", "LName"};
		model2.setColumnIdentifiers(column2);
		
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 15, 718, 231);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
	
		loadBttn.setBounds(10, 475, 89, 23);
		contentPane.add(loadBttn);
		

		exitBttn.setBounds(258, 475, 89, 23);
		contentPane.add(exitBttn);
		updateBttn.setBounds(134, 475, 89, 23);
		contentPane.add(updateBttn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(380, 301, 718, 231);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(model2);
		
	}
	
		public void addUpdateListener (ActionListener listenForUpdateBttn3) {
			updateBttn.addActionListener(listenForUpdateBttn3);
	}
		
		public void addLoadBttnListener (ActionListener listenForLoadBttnStu ) {
			loadBttn.addActionListener( listenForLoadBttnStu);
		}
		
		public void addUpdateListener2 (ActionListener listenForUpdateBttnStu) {
			updateBttn.addActionListener(listenForUpdateBttnStu);
		}
		
		public void addJTableListener (MouseListener listenForJTableClickedStu) {
			table.addMouseListener( listenForJTableClickedStu);
		}
		
		public void AddExitBtnListener (ActionListener listenForExitBttn) {
			exitBttn.addActionListener(listenForExitBttn);
		}
		
		
}

