package usersOrders;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logIn.Login;
import userAddress.Address;
import userInfo.Users;

import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtSubtotal;
	private JTextField txtTaxShipping;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderWindow frame = new OrderWindow();
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
	public OrderWindow() {
		setTitle("Bolt Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbx_18Bolt = new JCheckBox("1/8\" Bolt");
		chckbx_18Bolt.setHorizontalAlignment(SwingConstants.CENTER);
		chckbx_18Bolt.setBounds(6, 32, 97, 23);
		contentPane.add(chckbx_18Bolt);
		
		JSpinner bolt18_spinner = new JSpinner();
		bolt18_spinner.setBounds(96, 33, 37, 20);
		contentPane.add(bolt18_spinner);
		
		JCheckBox chckbx_14Bolt = new JCheckBox("1/4\" Bolt");
		chckbx_14Bolt.setHorizontalAlignment(SwingConstants.CENTER);
		chckbx_14Bolt.setBounds(6, 58, 97, 23);
		contentPane.add(chckbx_14Bolt);
		
		JSpinner bolt14_spinner = new JSpinner();
		bolt14_spinner.setBounds(96, 59, 37, 20);
		contentPane.add(bolt14_spinner);
		
		JCheckBox chckbx_38Bolt = new JCheckBox("3/8\" Bolt");
		chckbx_38Bolt.setHorizontalAlignment(SwingConstants.CENTER);
		chckbx_38Bolt.setBounds(6, 84, 97, 23);
		contentPane.add(chckbx_38Bolt);
		
		JSpinner bolt38_spinner = new JSpinner();
		bolt38_spinner.setBounds(96, 85, 37, 20);
		contentPane.add(bolt38_spinner);
		
		JCheckBox chckbx_12Bolt = new JCheckBox("1/2\" Bolt");
		chckbx_12Bolt.setHorizontalAlignment(SwingConstants.CENTER);
		chckbx_12Bolt.setBounds(6, 110, 97, 23);
		contentPane.add(chckbx_12Bolt);
		
		JSpinner bolt12_spinner = new JSpinner();
		bolt12_spinner.setBounds(96, 111, 37, 20);
		contentPane.add(bolt12_spinner);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setText("SubTotal");
		txtSubtotal.setBounds(409, 33, 86, 20);
		contentPane.add(txtSubtotal);
		txtSubtotal.setColumns(10);
		
		txtTaxShipping = new JTextField();
		txtTaxShipping.setText("Tax & Shipping");
		txtTaxShipping.setBounds(409, 59, 86, 20);
		contentPane.add(txtTaxShipping);
		txtTaxShipping.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setText("Total");
		txtTotal.setBounds(409, 85, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		Orders priceInfo = new Orders();
		
		//Add Items to the Order
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//If a check box is selected add the value of the item X the quantity and the spinner is greater than 0
				if (chckbx_18Bolt.isSelected()) 
				{
					priceInfo.setBolt18quantity((int) bolt18_spinner.getValue());
				}
				else if(chckbx_18Bolt.isSelected() && Integer.parseInt((String) bolt18_spinner.getValue()) <= 0) {
					JOptionPane.showMessageDialog(null, "Please add a quantity", "Orders Error", JOptionPane.ERROR_MESSAGE);
					
				}
				if (chckbx_14Bolt.isSelected() && Integer.parseInt((String) bolt14_spinner.getValue()) > 0)
				{
					priceInfo.setBolt14quantity((int) bolt14_spinner.getValue());
				}
				if (chckbx_38Bolt.isSelected() && Integer.parseInt((String) bolt38_spinner.getValue()) > 0) 
				{
					priceInfo.setBolt38quantity((int) bolt38_spinner.getValue());
				}
				if (chckbx_12Bolt.isSelected() && Integer.parseInt((String) bolt12_spinner.getValue()) > 0) 
				{
					priceInfo.setBolt12quantity((int) bolt12_spinner.getValue());
				}
				
				//Set the Subtotal to the items X their quantities summed
				priceInfo.setCombinedprice((priceInfo.getBolt18quantity() * priceInfo.bolt18) + (priceInfo.getBolt14quantity() * priceInfo.bolt14) + (priceInfo.getBolt38quantity() * priceInfo.bolt38) + (priceInfo.getBolt12quantity() * priceInfo.bolt12));
				
				//If the subtotal is 0 then show error
				if (priceInfo.combinedprice == 0) 
				{
					JOptionPane.showMessageDialog(null, "Please add something to cart ", "Orders Error", JOptionPane.ERROR_MESSAGE);
					
				}
				//Else set the values of the fields in Orders
				else
				{
					//set the subtotal, shipping, total
					String stringsubtotal = String.valueOf(priceInfo.getCombinedprice());
					txtSubtotal.setText(stringsubtotal);
					String shipping = String.valueOf(priceInfo.shipping);
					txtTaxShipping.setText(shipping);
					priceInfo.setTotal(priceInfo.getCombinedprice() + priceInfo.shipping);
					String total = String.valueOf(priceInfo.getTotal());
					txtTotal.setText(total);
					
				}
			}
		});
		btnAdd.setBounds(143, 32, 89, 23);
		contentPane.add(btnAdd);
		
		//Update the cart
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String shipping = String.valueOf(priceInfo.shipping);
				txtTaxShipping.setText(shipping);
				
				priceInfo.setTotal(priceInfo.getCombinedprice() + priceInfo.shipping);
				String total = String.valueOf(priceInfo.getTotal());
				txtTotal.setText(total);
			}	
		});
		btnUpdate.setBounds(310, 32, 89, 23);
		contentPane.add(btnUpdate);
		
		//Add the order to the Orders List and set it to the UserId
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				priceInfo.setUserId(Application.currentuser);
				Application.orders.add(priceInfo);
				ReviewOrder.main(null);
				setVisible(false);	
			}
		});
		btnSubmit.setBounds(310, 110, 185, 23);
		contentPane.add(btnSubmit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(258, 11, 1, 143);
		contentPane.add(separator);
		
		//Clear all Fields
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_18Bolt.setSelected(false);
				chckbx_14Bolt.setSelected(false);
				chckbx_38Bolt.setSelected(false);
				chckbx_12Bolt.setSelected(false);
				
				bolt18_spinner.setValue(0);
				bolt14_spinner.setValue(0);
				bolt38_spinner.setValue(0);
				bolt12_spinner.setValue(0);
				
				priceInfo.setBolt18quantity(0);
				priceInfo.setBolt14quantity(0);
				priceInfo.setBolt38quantity(0);
				priceInfo.setBolt12quantity(0);
				priceInfo.setCombinedprice(0);
				priceInfo.setTotal(0);
				
				
				txtSubtotal.setText(null);
				txtTaxShipping.setText(null);
				txtTotal.setText(null);
				
			}
		});
		btnClear.setBounds(143, 58, 89, 23);
		contentPane.add(btnClear);
		
		JButton backBttn = new JButton("Back");
		backBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
				setVisible(false);
			}
		});
		backBttn.setBounds(143, 110, 116, 23);
		contentPane.add(backBttn);
	}
}
