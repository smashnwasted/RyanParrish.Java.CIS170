package userInfo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logIn.Login;
import userAddress.AddressInfo_Window;
import usersOrders.Application;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.event.ActionEvent;

public class UserInfo_Window extends JFrame {

	private JPanel contentPane;
	private JTextField txtfName;
	private JTextField txtlName;
	private JTextField txteMail;
	private JTextField txtPassword;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo_Window frame = new UserInfo_Window();
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
	public UserInfo_Window() {
		setTitle("Create New User");
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
		
		txtfName = new JTextField();
		GridBagConstraints gbc_txtfName = new GridBagConstraints();
		gbc_txtfName.insets = new Insets(0, 0, 5, 0);
		gbc_txtfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfName.gridx = 2;
		gbc_txtfName.gridy = 2;
		contentPane.add(txtfName, gbc_txtfName);
		txtfName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 3;
		contentPane.add(lblLastName, gbc_lblLastName);
		
		txtlName = new JTextField();
		GridBagConstraints gbc_txtlName = new GridBagConstraints();
		gbc_txtlName.insets = new Insets(0, 0, 5, 0);
		gbc_txtlName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtlName.gridx = 2;
		gbc_txtlName.gridy = 4;
		contentPane.add(txtlName, gbc_txtlName);
		txtlName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 5;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		txteMail = new JTextField();
		GridBagConstraints gbc_txteMail = new GridBagConstraints();
		gbc_txteMail.insets = new Insets(0, 0, 5, 0);
		gbc_txteMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txteMail.gridx = 2;
		gbc_txteMail.gridy = 6;
		contentPane.add(txteMail, gbc_txteMail);
		txteMail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 7;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		txtPassword = new JTextField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 8;
		contentPane.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);
		
		//Add all fields to the User List
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create an ID for the new user
				int addid = 0 ;
				for (Users u: Application.users) {
					addid = u.userId + 1;
				}
				
				//make that id the current id
				Application.currentuser = addid;
				
				//instance of the new user
				Users addUser = new Users(Application.currentuser, txtfName.getText(), txtlName.getText(), txteMail.getText(), txtPassword.getText());
				
				//if the fields are empty
				if(txtfName.getText().trim().isEmpty() || txtlName.getText().trim().isEmpty() || txteMail.getText().trim().isEmpty() || txtPassword.getText().trim().isEmpty() ) 
				{
					//error
					JOptionPane.showMessageDialog(null, "Invalid Account Details", "Account Error", JOptionPane.ERROR_MESSAGE);	
				}
				//Else add the user to the List
				else 
				{
					Application.users.add(addUser);
					// move to the address
					AddressInfo_Window.main(null);
					setVisible(false);
				}
			}
		});
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 5, 0);
		gbc_btnNext.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNext.gridx = 2;
		gbc_btnNext.gridy = 9;
		contentPane.add(btnNext, gbc_btnNext);
		
		//back to login
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 10;
		contentPane.add(btnBack, gbc_btnBack);
	}

}
