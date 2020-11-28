package projectView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	private JPanel contentPane;
	public JTextField user;
	public JPasswordField pass;
	public JButton loginBtn = new JButton("Login");
	public JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(0, 0, 306, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(10, 51, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		user = new JTextField();
		user.setBounds(10, 76, 286, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(10, 107, 72, 14);
		contentPane.add(lblNewLabel_1_1);
		
		pass = new JPasswordField();
		pass.setBounds(10, 132, 286, 20);
		contentPane.add(pass);
		
		
		loginBtn.setBounds(107, 260, 89, 23);
		contentPane.add(loginBtn);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Type");
		lblNewLabel_1_1_1.setBounds(10, 163, 72, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Agent", "Representative"}));
		comboBox.setBounds(10, 179, 134, 20);
		contentPane.add(comboBox);
	}
	
	public void addLoginListener (ActionListener listenForLoginBtn) {
		loginBtn.addActionListener(listenForLoginBtn);
	}
}
