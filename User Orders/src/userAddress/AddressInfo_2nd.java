package userAddress;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddressInfo_2nd extends JFrame {

	private JPanel contentPane;
	private JTextField State_textField;
	private JTextField city_textField;
	private JTextField street_textField;
	private JTextField zipcode_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressInfo_2nd frame = new AddressInfo_2nd();
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
	public AddressInfo_2nd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblState = new JLabel("State");
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 1;
		gbc_lblState.gridy = 1;
		contentPane.add(lblState, gbc_lblState);
		
		State_textField = new JTextField();
		GridBagConstraints gbc_State_textField = new GridBagConstraints();
		gbc_State_textField.insets = new Insets(0, 0, 5, 5);
		gbc_State_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_State_textField.gridx = 2;
		gbc_State_textField.gridy = 2;
		contentPane.add(State_textField, gbc_State_textField);
		State_textField.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 1;
		gbc_lblCity.gridy = 3;
		contentPane.add(lblCity, gbc_lblCity);
		
		city_textField = new JTextField();
		GridBagConstraints gbc_city_textField = new GridBagConstraints();
		gbc_city_textField.gridwidth = 2;
		gbc_city_textField.insets = new Insets(0, 0, 5, 5);
		gbc_city_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_city_textField.gridx = 2;
		gbc_city_textField.gridy = 4;
		contentPane.add(city_textField, gbc_city_textField);
		city_textField.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 1;
		gbc_lblStreet.gridy = 5;
		contentPane.add(lblStreet, gbc_lblStreet);
		
		street_textField = new JTextField();
		GridBagConstraints gbc_street_textField = new GridBagConstraints();
		gbc_street_textField.gridwidth = 2;
		gbc_street_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_street_textField.insets = new Insets(0, 0, 5, 5);
		gbc_street_textField.gridx = 2;
		gbc_street_textField.gridy = 6;
		contentPane.add(street_textField, gbc_street_textField);
		street_textField.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		GridBagConstraints gbc_lblZipCode = new GridBagConstraints();
		gbc_lblZipCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblZipCode.gridx = 1;
		gbc_lblZipCode.gridy = 7;
		contentPane.add(lblZipCode, gbc_lblZipCode);
		
		zipcode_textField = new JTextField();
		GridBagConstraints gbc_zipcode_textField = new GridBagConstraints();
		gbc_zipcode_textField.insets = new Insets(0, 0, 5, 5);
		gbc_zipcode_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_zipcode_textField.gridx = 2;
		gbc_zipcode_textField.gridy = 8;
		contentPane.add(zipcode_textField, gbc_zipcode_textField);
		zipcode_textField.setColumns(10);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_Back = new GridBagConstraints();
		gbc_Back.insets = new Insets(0, 0, 0, 5);
		gbc_Back.gridx = 2;
		gbc_Back.gridy = 10;
		contentPane.add(Back, gbc_Back);
		
		JButton btnNext = new JButton("Next");
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNext.gridx = 3;
		gbc_btnNext.gridy = 10;
		contentPane.add(btnNext, gbc_btnNext);
	}

}
