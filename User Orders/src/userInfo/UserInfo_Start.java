package userInfo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class UserInfo_Start extends JFrame {

	private JPanel contentPane;
	private JTextField fName_textField;
	private JTextField lName_textField;
	private JTextField eMail_textField;
	private JTextField password_textField;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo_Start frame = new UserInfo_Start();
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
	public UserInfo_Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblFirstName = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 1;
		contentPane.add(lblFirstName, gbc_lblFirstName);
		
		fName_textField = new JTextField();
		GridBagConstraints gbc_fName_textField = new GridBagConstraints();
		gbc_fName_textField.insets = new Insets(0, 0, 5, 0);
		gbc_fName_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fName_textField.gridx = 2;
		gbc_fName_textField.gridy = 2;
		contentPane.add(fName_textField, gbc_fName_textField);
		fName_textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 3;
		contentPane.add(lblLastName, gbc_lblLastName);
		
		lName_textField = new JTextField();
		GridBagConstraints gbc_lName_textField = new GridBagConstraints();
		gbc_lName_textField.insets = new Insets(0, 0, 5, 0);
		gbc_lName_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lName_textField.gridx = 2;
		gbc_lName_textField.gridy = 4;
		contentPane.add(lName_textField, gbc_lName_textField);
		lName_textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 5;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		eMail_textField = new JTextField();
		GridBagConstraints gbc_eMail_textField = new GridBagConstraints();
		gbc_eMail_textField.insets = new Insets(0, 0, 5, 0);
		gbc_eMail_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_eMail_textField.gridx = 2;
		gbc_eMail_textField.gridy = 6;
		contentPane.add(eMail_textField, gbc_eMail_textField);
		eMail_textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 7;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		password_textField = new JTextField();
		GridBagConstraints gbc_password_textField = new GridBagConstraints();
		gbc_password_textField.insets = new Insets(0, 0, 5, 0);
		gbc_password_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_password_textField.gridx = 2;
		gbc_password_textField.gridy = 8;
		contentPane.add(password_textField, gbc_password_textField);
		password_textField.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 5, 0);
		gbc_btnNext.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNext.gridx = 2;
		gbc_btnNext.gridy = 9;
		contentPane.add(btnNext, gbc_btnNext);
		
		btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 10;
		contentPane.add(btnBack, gbc_btnBack);
	}

}
