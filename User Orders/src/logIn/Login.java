package logIn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField eMail_textfield;
	private JTextField password_textField;

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
		eMail_textfield.setBounds(66, 80, 131, 20);
		contentPane.add(eMail_textfield);
		eMail_textfield.setColumns(10);
		
		JLabel lblPassowrd = new JLabel("Passowrd");
		lblPassowrd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassowrd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPassowrd.setBounds(0, 109, 64, 14);
		contentPane.add(lblPassowrd);
		
		password_textField = new JTextField();
		password_textField.setBounds(66, 111, 131, 20);
		contentPane.add(password_textField);
		password_textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(10, 156, 118, 23);
		contentPane.add(btnLogin);
		
		JButton btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateNewAccount.setBounds(138, 156, 165, 23);
		contentPane.add(btnCreateNewAccount);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(313, 156, 111, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 143, 414, 2);
		contentPane.add(separator_1);
	}
}