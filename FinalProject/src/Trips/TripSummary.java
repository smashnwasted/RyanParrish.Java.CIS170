package Trips;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import Login.Application;
import Login.Users;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextPane;
import java.awt.Insets;
import java.awt.PrintJob;

import javax.print.event.PrintEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class TripSummary extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TripSummary frame = new TripSummary();
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
	public TripSummary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTripSummary = new JLabel("Trip Summary");
		lblTripSummary.setFont(new Font("Calibri", Font.BOLD, 28));
		GridBagConstraints gbc_lblTripSummary = new GridBagConstraints();
		gbc_lblTripSummary.insets = new Insets(0, 0, 5, 0);
		gbc_lblTripSummary.gridwidth = 5;
		gbc_lblTripSummary.fill = GridBagConstraints.VERTICAL;
		gbc_lblTripSummary.gridx = 0;
		gbc_lblTripSummary.gridy = 0;
		contentPane.add(lblTripSummary, gbc_lblTripSummary);
		
		TextArea summaryTxt = new TextArea();
		GridBagConstraints gbc_summaryTxt = new GridBagConstraints();
		gbc_summaryTxt.fill = GridBagConstraints.VERTICAL;
		gbc_summaryTxt.gridheight = 6;
		gbc_summaryTxt.insets = new Insets(0, 0, 0, 5);
		gbc_summaryTxt.gridx = 0;
		gbc_summaryTxt.gridy = 1;
		contentPane.add(summaryTxt, gbc_summaryTxt);
		
		Button printbtn = new Button("Print");
		printbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob pjob = PrinterJob.getPrinterJob();
				PageFormat preformat = pjob.defaultPage();
				preformat.setOrientation(PageFormat.LANDSCAPE);
				PageFormat postformat = pjob.pageDialog(preformat);
				//If user does not hit cancel then print.
				if (preformat != postformat) {
				  //Set print component
				  pjob.setPrintable((Printable) summaryTxt);
				  if (pjob.printDialog()) {
				    try {
						pjob.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  }
				}
			}

		});
		GridBagConstraints gbc_printbtn = new GridBagConstraints();
		gbc_printbtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_printbtn.insets = new Insets(0, 0, 5, 5);
		gbc_printbtn.gridx = 1;
		gbc_printbtn.gridy = 4;
		contentPane.add(printbtn, gbc_printbtn);
		
		Button exitbtn = new Button("Exit");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_exitbtn = new GridBagConstraints();
		gbc_exitbtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_exitbtn.insets = new Insets(0, 0, 5, 5);
		gbc_exitbtn.gridx = 1;
		gbc_exitbtn.gridy = 5;
		contentPane.add(exitbtn, gbc_exitbtn);
		
		for(Users u: Application.users) {
			if(u.userId == Application.currentuser) {
				summaryTxt.append("Name: " + u.fName + " " + u.lName + "\n");
				summaryTxt.append("Email: " + u.eMail + "\n");
				summaryTxt.append("Phone: " + u.phoneNumber + "\n");
				summaryTxt.append("-----------------------------------------" + "\n");
			}
		}
		for(Trips t: Application.trips) {
			if(t.user == Application.currentuser) {
				summaryTxt.append("Date for trip" + t.startDate + "\n");
				summaryTxt.append("Trail: " + t.trail + "\n");
				summaryTxt.append("Campsite: " + t.campsite + "\n");
				summaryTxt.append("-----------------------------------------" + "\n");
				summaryTxt.append("Please Check in with your Park Ranger by 6:00pm" + "\n");
				summaryTxt.append("Your check in officer: " + t.rName + "\n");
				summaryTxt.append(t.rPhone + "\n");	
			}
		}
	}

}
