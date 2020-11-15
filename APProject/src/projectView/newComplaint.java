package projectView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class newComplaint extends JFrame {

	private JPanel complaintPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setTitle("Complaint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 503);
		complaintPane = new JPanel();
		complaintPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(complaintPane);
		complaintPane.setLayout(new FormLayout(new ColumnSpec[] {},
			new RowSpec[] {}));
	}

}
