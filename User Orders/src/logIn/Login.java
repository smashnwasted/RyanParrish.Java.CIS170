package logIn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import userInfo.UserInfo_Window;
import userInfo.Users;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import usersOrders.Application;
import usersOrders.OrderWindow;;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField eMail_textfield;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(98, 11, 205, 24);
		contentPane.add(lblLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 414, 2);
		contentPane.add(separator);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(10, 83, 46, 14);
		contentPane.add(lblEmail);
		
		eMail_textfield = new JTextField();
		eMail_textfield.setText("admin");
		eMail_textfield.setBounds(66, 80, 131, 20);
		contentPane.add(eMail_textfield);
		eMail_textfield.setColumns(10);
		
		JLabel lblPassowrd = new JLabel("Password");
		lblPassowrd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassowrd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPassowrd.setBounds(0, 109, 64, 14);
		contentPane.add(lblPassowrd);
		
		
		//when login process
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usermail = eMail_textfield.getText();
				String password = pwdPassword.getText();
				
				//booleans to test if the user is valid or logged in
				boolean loggedin = false;
				boolean validuser = false;
		
				// if the user is not logged in or a valid user
				if(!validuser && !loggedin) 
				{
					//get the users info
					for(Users u : Application.users) 
					{
						//if the password matched the email
						if (password.contains(u.password) && usermail.contains(u.eMail)) 
						{
							//set the Current User to the user Id matching the email and password of the user
							Application.currentuser = u.userId;
							//reset the text fields
							eMail_textfield.setText(null);
							pwdPassword.setText(null);
							//the log in passes the test
							loggedin = true;
							validuser = true;
						}
						else
						{
							//rest the text fields
							eMail_textfield.setText(null);
							pwdPassword.setText(null);
						}
					}
				}
				//If the user is valid and passes login
				if(loggedin && validuser) 
				{
				//rest text fields
				eMail_textfield.setText(null);
				pwdPassword.setText(null);
				//Open the Order Window
				OrderWindow newOrder = new OrderWindow();
				newOrder.main(null);
				//hide the login window
				setVisible(false);
				}
				//show an error
				else 
				{
					JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
		}
		});
		btnLogin.setBounds(10, 156, 118, 23);
		contentPane.add(btnLogin);
		
		//go to create a new user
		JButton btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//open UserInfo Window and hide the login window
				UserInfo_Window newUser = new UserInfo_Window();
				newUser.main(null);
				setVisible(false);
			}
		});
		
		btnCreateNewAccount.setBounds(138, 156, 165, 23);
		contentPane.add(btnCreateNewAccount);
		
		//Close the App
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(313, 156, 111, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 143, 414, 2);
		contentPane.add(separator_1);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("admin");
		pwdPassword.setBounds(66, 111, 131, 20);
		contentPane.add(pwdPassword);
	}
}
