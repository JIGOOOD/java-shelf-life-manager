import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import java.io.*;
import java.text.ParseException;
import java.util.*;

/*

 * This code is final project of JAVA Programming Lab.

 */

/**
 * * This class shows the main home of the program.
 * This is where actions such as signing up for membership, 
 * logging in, opening the refrigerator, and cooking take place.
 * 
 * @version 1.0 5 June 2022
 * 
 * @author Jiyeon Park
 * 
 */
public class ShelfLifeManager extends JFrame {

	private JPanel contentPane; // for storing the all components
	private JLabel lblTitle; // for storing the title
	private JButton btnOpenRefrigerator; // for expressing a button for opening refrigerator
	private JButton btnCook; // for expressing a button for cooking
	private JLabel lblUserName; // for storing the user name
	private JLabel lblProfile; // for showing the profile image
	private JButton btnLogin; // for expressing a button for logging in
	private boolean logged_in; // for storing the login status
	private File userInfoFile = new File("user_info.txt"); // for storing the "user_info.txt" file
	private boolean registered = userInfoFile.exists(); // for storing the existence of a file
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShelfLifeManager frame = new ShelfLifeManager();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShelfLifeManager() {
		
		setLoggedIn();
		
		/**
		 * set contentPane
		 */
		setTitle("Shelf Life Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * set lblTitle
		 */
		lblTitle = new JLabel("Shelf Life Manager");
		lblTitle.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
		lblTitle.setBounds(126, 39, 244, 64);
		contentPane.add(lblTitle);
		
		/**
		 * set btnOpenRefrigerator
		 */
		btnOpenRefrigerator = new JButton("Open the refrigerator");
		btnOpenRefrigerator.setFont(new Font("Maiandra GD", Font.BOLD, 12));
		btnOpenRefrigerator.setForeground(Color.DARK_GRAY);
		btnOpenRefrigerator.setBackground(SystemColor.inactiveCaption);
		btnOpenRefrigerator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if user are logged in
				if(!prohibitUsage()) {
					dispose();
					// show OpenRefrigerator GUI
					OpenRefrigerator refrigerator = new OpenRefrigerator();
					refrigerator.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					refrigerator.setVisible(true);
				}
			}
		});
		btnOpenRefrigerator.setBounds(147, 149, 190, 23);
		contentPane.add(btnOpenRefrigerator);
		
		/**
		 * set btnCook
		 */
		btnCook = new JButton("Cooking with Ingredients in the Refrigerator");
		btnCook.setFont(new Font("Maiandra GD", Font.BOLD, 12));
		btnCook.setForeground(Color.DARK_GRAY);
		btnCook.setBackground(SystemColor.inactiveCaption);
		btnCook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if user are logged in
				if(!prohibitUsage()) { 
					dispose();
					try {
						// show CookingZone GUI
						CookingZone cookingZone = new CookingZone();
						cookingZone.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						cookingZone.setVisible(true);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnCook.setBounds(81, 218, 324, 23);
		contentPane.add(btnCook);
		
		/**
		 * set lblUserName
		 */
		lblUserName = new JLabel();
		// shows the logged in user's information
		if(registered && logged_in) {
			lblUserName.setText(getUserName());
		}
		lblUserName.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 10));
		lblUserName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUserName.setBounds(303, 10, 152, 15);
		contentPane.add(lblUserName);
		
		/**
		 * set lblProfile
		 */
		Icon profileIcon = new ImageIcon(getClass().getResource("/images/profile.png"));
		lblProfile = new JLabel(profileIcon);
		lblProfile.setBounds(457, 10, 17, 15);
		contentPane.add(lblProfile);
		
		/**
		 * set btnLogin
		 */
		btnLogin = new JButton();
		btnLogin.setFont(new Font("Maiandra GD", Font.BOLD, 10));
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setBackground(SystemColor.inactiveCaption);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// different actions are performed depending on whether user are signed up or logged in
				if(btnLogin.getText()=="Register") { // if user are not registered
					// go to refister GUI
					Register register = new Register();
					register.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					register.setVisible(true);
					dispose();
				}
				else if(btnLogin.getText()=="Login"){ // if user are not logged in
					// go to login GUI
					Login login = new Login();
					login.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					login.setVisible(true);
					dispose();
				}
				else { // if user are logged in and want to log out
					try {
						// to write "login.txt" file
						FileOutputStream fileObject = new FileOutputStream("login.txt", false); // overwrite
						PrintWriter logout = new PrintWriter(fileObject);
						logout.println("logout"); // write "logout" to the file
						
						dispose();
						logout.close();
						
						// logout message
						JOptionPane.showMessageDialog(null, "You are logged out.", "Log out",
								JOptionPane.INFORMATION_MESSAGE);
						
						// refresh GUI
						ShelfLifeManager frame = new ShelfLifeManager();
						frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		if(registered && (!logged_in)) { // logout status
			btnLogin.setText("Login");
		}
		else if(registered && logged_in) { // login status
			btnLogin.setText("Logout");
		}
		else { // no account
			btnLogin.setText("Register");
		}
		btnLogin.setBounds(12, 10, 95, 15);
		contentPane.add(btnLogin);
	}
	
	/**
	 * @return user name
	 */
	public String getUserName() {
		String name = null;
		try {
			// to read the "user_info.txt" file
			FileInputStream fileObject = new FileInputStream("user_info.txt");
			Scanner userInfo = new Scanner(fileObject);

			// read the "user_info.txt" file
			while (userInfo.hasNext()) {
				
				// for storing user information
				String lineContent[] = userInfo.nextLine().split(":");
				// extract and save the user name
				if (lineContent[0].equals("Name") && lineContent[1].length() > 0) {
					name = lineContent[1];
				}
			}
			userInfo.close();
		} catch (FileNotFoundException e) {
			
		}
		
		return name;
	}
	
	/**
	 * store whether user are logged in
	 */
	public void setLoggedIn() {
		try {
			// to read the "login.txt" file
			FileInputStream fileObject = new FileInputStream("login.txt");
			Scanner login = new Scanner(fileObject);
			
			// read the "login.txt" file
			while(login.hasNext()) {
				String lineContent = login.nextLine(); // for storing the contents of the login file
				
				// whether to log in depends on what is written in the file
				if(lineContent.equals("login")) {
					logged_in = true;
				}
				else if(lineContent.equals("logout")) {
					logged_in = false;
				}
				else { // if the file is empty
					logged_in= false;
				}
			}
			login.close();
			
		} catch (FileNotFoundException e) {
			logged_in = false;
		}
	}
	
	/**
	 * restrict use depending on account creation and login status
	 * and return whether limit
	 */
	public boolean prohibitUsage() {
		if(!registered) { // if an account has not been created
			// error message
			JOptionPane.showMessageDialog(null, "You cannot use the service because you are not a member."
					+ "\n Please register as a member by clicking the register button in the upper left corner.", 
					"Usage restrictions",
					JOptionPane.ERROR_MESSAGE);
			return true; // limited
		}
		else if(!logged_in) { // if you are not logged in
			// error message
			JOptionPane.showMessageDialog(null, "Please log in and try again.", "Usage restrictions",
					JOptionPane.ERROR_MESSAGE);
			return true; // limited
		}
		else { // if user have an account and are logged in
			return false; // no limited
		}
	}
	
}
