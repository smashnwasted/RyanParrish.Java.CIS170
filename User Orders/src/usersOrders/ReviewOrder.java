package usersOrders;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logIn.Login;
import userAddress.Address;
import userInfo.Users;

import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ReviewOrder extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewOrder frame = new ReviewOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String orderSummary;
	/**
	 * Create the frame.
	 */
	public ReviewOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea name = new JTextArea();
		name.setBounds(92, 11, 210, 22);
		contentPane.add(name);
		
		JTextArea address = new JTextArea();
		address.setBounds(92, 44, 332, 22);
		contentPane.add(address);
		
		JTextArea userId = new JTextArea();
		userId.setBounds(10, 11, 72, 22);
		contentPane.add(userId);
		
		//Exit App
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnFinish.setBounds(335, 227, 89, 23);
		contentPane.add(btnFinish);
		
		//Go back to login
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 414, 108);
		contentPane.add(scrollPane);
			
		JTextArea ordersummary = new JTextArea();
		scrollPane.setViewportView(ordersummary);
		
		//get Order, list of items & quantity, Subtotal, Shipping, Total
		String userIdString = "";
		String userName = "";
		
		//get user
		for(Users u : Application.users) 
		{
			if(u.userId == Application.currentuser) {
				userIdString = "User ID : " + u.userId;
				userId.setText(userIdString);
				userName = "Name : " + u.fName + ", " + u.lName;
				name.setText(userName);
			}
		}
		//get Address
		for (Address a: Application.address) {
			if(a.userId == Application.currentuser) {
				address.append(a.street + ", ");
				address.append(a.city + ", ");
				address.append(a.state + ", ");
				address.append(a.zipCode);
				
			}
		}
		//get order
		for (Orders o : Application.orders) {
			if (o.bolt18quantity != 0) {
				ordersummary.append("1/8 Bolt"+ ": " + o.bolt18quantity + " \n");
			}
			if (o.bolt14quantity != 0) {
				ordersummary.append("1/4 Bolt"+ ": " + o.bolt14quantity + " \n");
			}
			if (o.bolt38quantity != 0) {
				ordersummary.append("3/8 Bolt"+ ": " + o.bolt38quantity + " \n");
			}
			if (o.bolt12quantity != 0) {
				ordersummary.append("1/2 Bolt"+ ": " + o.bolt12quantity + " \n");
			}
			ordersummary.append("Subtotal : " + o.combinedprice + "\n");
			ordersummary.append("Shipping : " + o.shipping + "\n");
			ordersummary.append("Total : " + o.total + "\n");
			ordersummary.append("-----------------------------------------" + "\n");
		}
	}
}
