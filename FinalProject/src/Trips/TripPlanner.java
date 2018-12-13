package Trips;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.JList;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.FlowLayout;
import java.awt.List;
import javax.swing.JSpinner;
import com.toedter.components.JSpinField;

import Login.Application;
import Login.Rangers;

import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class TripPlanner extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TripPlanner frame = new TripPlanner();
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
	public TripPlanner() {
		setTitle("Trip Planner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 384);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		//array of trails to choose from the list
		String[] trails = {"Blue","Yellow","Red"};
		
		//Array for the Campsites
		String[] campsites = {"A", "B", "C", "D"};
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(6, 194, 114, 20);
		getContentPane().add(dateChooser);
		
		ButtonGroup trailGroup = new ButtonGroup();
		
		JRadioButton rdbtnBlueTrail = new JRadioButton("Blue Trail");
		rdbtnBlueTrail.setBounds(6, 59, 89, 23);
		getContentPane().add(rdbtnBlueTrail);
		
		JRadioButton rdbtnYellowTrail = new JRadioButton("Yellow Trail");
		rdbtnYellowTrail.setBounds(6, 79, 89, 23);
		getContentPane().add(rdbtnYellowTrail);
		
		JRadioButton redTrailbtn = new JRadioButton("Red Trail");
		redTrailbtn.setBounds(6, 99, 89, 23);
		getContentPane().add(redTrailbtn);
		
		//Group for Trails
		trailGroup.add(rdbtnYellowTrail);
		trailGroup.add(rdbtnBlueTrail);
		trailGroup.add(redTrailbtn);
		
		//Group for Campsites
		ButtonGroup campGroup = new ButtonGroup();
		
		JRadioButton rdbtnSiteA = new JRadioButton("Site A");
		rdbtnSiteA.setBounds(180, 59, 64, 23);
		getContentPane().add(rdbtnSiteA);
		
		JRadioButton rdbtnSiteB = new JRadioButton("Site B");
		rdbtnSiteB.setBounds(256, 59, 64, 23);
		getContentPane().add(rdbtnSiteB);
		
		JRadioButton rdbtnSiteC = new JRadioButton("Site C");
		rdbtnSiteC.setBounds(180, 79, 64, 23);
		getContentPane().add(rdbtnSiteC);
		
		JRadioButton rdbtnSiteD = new JRadioButton("Site D");
		rdbtnSiteD.setBounds(256, 79, 64, 23);
		getContentPane().add(rdbtnSiteD);
		
		campGroup.add(rdbtnSiteA);
		campGroup.add(rdbtnSiteB);
		campGroup.add(rdbtnSiteC);
		campGroup.add(rdbtnSiteD);
		rdbtnSiteA.setVisible(false);
		rdbtnSiteB.setVisible(false);
		rdbtnSiteC.setVisible(false);
		rdbtnSiteD.setVisible(false);
		
		JLabel lblChooseACampsite = new JLabel("Choose a Campsite");
		lblChooseACampsite.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblChooseACampsite.setBounds(180, 35, 157, 21);
		getContentPane().add(lblChooseACampsite);
		
		JLabel lblChooseATrail = new JLabel("Choose a Trail");
		lblChooseATrail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblChooseATrail.setBounds(6, 38, 129, 14);
		getContentPane().add(lblChooseATrail);
		
		JLabel lblChooseADate = new JLabel("Choose a Date");
		lblChooseADate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblChooseADate.setBounds(6, 169, 115, 14);
		getContentPane().add(lblChooseADate);
		
		JLabel lblYourCheckinRanger = new JLabel("Your Check-in Ranger");
		lblYourCheckinRanger.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblYourCheckinRanger.setBounds(6, 255, 221, 20);
		getContentPane().add(lblYourCheckinRanger);
		
		JTextPane rangertxtpn = new JTextPane();
		rangertxtpn.setBounds(6, 280, 221, 20);
		getContentPane().add(rangertxtpn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 156, 318, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 225, 318, 2);
		getContentPane().add(separator_1);
		
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnYellowTrail.isSelected()) {
					rdbtnSiteC.setVisible(true);
					rdbtnSiteD.setVisible(true);
					rdbtnSiteA.setVisible(false);
					rdbtnSiteB.setVisible(false);
					
					for (Rangers r: Application.rangers) {
						if (r.rank.equals("Lieutenant"))
						rangertxtpn.setText(r.rank + " " + r.lName);
					}
				}
				
				else if(rdbtnBlueTrail.isSelected()) {
					rdbtnSiteA.setVisible(true);
					rdbtnSiteB.setVisible(true);
					rdbtnSiteC.setVisible(false);
					rdbtnSiteD.setVisible(false);
					for (Rangers r: Application.rangers) {
						if (r.rank.equals("Captain"))
						rangertxtpn.setText(r.rank + " " + r.lName);
					}
				}
				else if(redTrailbtn.isSelected()) {
					rdbtnSiteA.setVisible(true);
					rdbtnSiteB.setVisible(true);
					rdbtnSiteC.setVisible(true);
					rdbtnSiteD.setVisible(true);
					for (Rangers r: Application.rangers) {
						if (r.rank.equals("Sargent"))
						rangertxtpn.setText(r.rank + " " + r.lName);
					}
				}
				
			}
		});
		btnSelect.setBounds(6, 129, 89, 23);
		getContentPane().add(btnSelect);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String trail = null;
				String campsite = null;
				DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				String startdate = df.format(dateChooser.getDate());
				String ranger = null;
				String rPhone = null;
				String datechoosen = null;
				int user = Application.currentuser;
				
				
				if(rdbtnYellowTrail.isSelected()) { 
					trail = "Yellow";
					for (Rangers r: Application.rangers) {
						if (r.rank.equals("Lieutenant"))
						ranger = r.rank + " " + r.fName + " " + r.lName;
						rPhone = r.phoneNumber;
					}
					if (rdbtnSiteC.isSelected()) {
						campsite = "Site C";
					}
					else if (rdbtnSiteD.isSelected()) {
						campsite = "Site D";
					}
				}
				if(rdbtnBlueTrail.isSelected()) {
					trail = "Blue";
					for (Rangers r: Application.rangers) {
						if (r.rank.equals("Captain"))
						ranger = r.rank + " " + r.fName + " " + r.lName;
						rPhone = r.phoneNumber;
					}
					if (rdbtnSiteA.isSelected()) {
						campsite = "Site A";
					}
					else if (rdbtnSiteB.isSelected()) {
						campsite = "Site B";
					}
				}
				if(redTrailbtn.isSelected()) {
					trail = "Red";
					for (Rangers r: Application.rangers) {
						if (r.rank.equals("Sargent"))
						ranger = r.rank + " " + r.fName + " " + r.lName;
						rPhone = r.phoneNumber;
					}
					if (rdbtnSiteA.isSelected()) {
						campsite = "Site A";
					}
					else if (rdbtnSiteB.isSelected()) {
						campsite = "Site B";
					}
					else if (rdbtnSiteC.isSelected()) {
						campsite = "Site C";
					}
					else if (rdbtnSiteD.isSelected()) {
						campsite = "Site D";
					}
				}
				
				Trips addtrip = new Trips(user, startdate, trail, campsite,  ranger, rPhone);
				Application.trips.add(addtrip);
				TripSummary ts = new TripSummary();
				ts.main(null);
				setVisible(false);

			}
		});
		btnNext.setBounds(105, 311, 89, 23);
		getContentPane().add(btnNext);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 311, 89, 23);
		getContentPane().add(btnBack);

		
	}
}
