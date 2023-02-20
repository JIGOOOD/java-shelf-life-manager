import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import java.io.*;
import java.util.*;

/*

 * This code is final project of JAVA Programming Lab.

 */

/**
 * * This is the class where the user logs in
 * 
 * @version 1.0 5 June 2022
 * 
 * @author Jiyeon Park
 * 
 */
public class Login extends JDialog {

	private JPanel contentPanel; // for storing the components related with ID and  password
	private JTextField textFieldID; // for storing the ID
	private JTextField textFieldPassword; // for storing the password
	private JPanel panelID; // for storing the components related with ID
	private FlowLayout fl_panelID; // for storing the layout of ID panel
	private JLabel lblID; // for indicating ID
	private JPanel panelPW; // for storing the components related with password
	private JLabel lblPassword; // for indicating password
	private FlowLayout fl_panelPW; // for storing the layout of password panel
	private JPanel buttonPane; // for storing the components related with buttons
	private JButton loginButton; // for indicating login button
	private JButton cancelButton; // for indicating cancel button
	private String name; // for storing the user name

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		
		/**
		 * set contentPanel
		 */
		setTitle("Log in");
		contentPanel = new JPanel();
		setBounds(100, 100, 383, 221);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 1, 0, 0));
		{
			/**
			 * set panelID
			 */
			panelID = new JPanel();
			fl_panelID = (FlowLayout) panelID.getLayout();
			fl_panelID.setHgap(20);
			fl_panelID.setVgap(30);
			contentPanel.add(panelID);
			{
				/**
				 * set lblID
				 */
				lblID = new JLabel("             ID");
				lblID.setFont(new Font("Myanmar Text", Font.BOLD, 12));
				panelID.add(lblID);
			}
			{
				/**
				 * set textFieldID
				 */
				textFieldID = new JTextField();
				panelID.add(textFieldID);
				textFieldID.setColumns(10);
			}
		}
		{
			/**
			 * set panelPW
			 */
			panelPW = new JPanel();
			fl_panelPW = (FlowLayout) panelPW.getLayout();
			fl_panelPW.setVgap(10);
			fl_panelPW.setHgap(20);
			contentPanel.add(panelPW);
			{
				/**
				 * set lblPassword
				 */
				lblPassword = new JLabel("Password");
				lblPassword.setFont(new Font("Myanmar Text", Font.BOLD, 12));
				panelPW.add(lblPassword);
			}
			{
				/**
				 * set textFieldPassword
				 */
				textFieldPassword = new JPasswordField();
				textFieldPassword.setColumns(10);
				panelPW.add(textFieldPassword);
			}
		}
		{
			/**
			 * set buttonPane
			 */
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				/**
				 * set loginButton
				 */
				loginButton = new JButton("Login");
				loginButton.setBackground(SystemColor.inactiveCaption);
				loginButton.setForeground(Color.DARK_GRAY);
				loginButton.setFont(new Font("Maiandra GD", Font.BOLD, 12));
				loginButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						// for storing the user information
						ArrayList<String> conditions = new ArrayList();
						conditions = readUserInfo();
						
						// login succeed
						if(conditions.size() == 2) {
							dispose();
							
							// welcome message
							JOptionPane.showMessageDialog(null, "Welcome to "+ name + "!", "Login complete",
									JOptionPane.INFORMATION_MESSAGE);
							try {
								// to write "login.txt" file
								FileOutputStream fileObject = new FileOutputStream("login.txt", false); // overwrite
								PrintWriter login = new PrintWriter(fileObject);
								login.println("login"); // write "login" to the file
								login.close();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							// open shelf life manager
							ShelfLifeManager shelfLifeManager = new ShelfLifeManager();
							shelfLifeManager.setVisible(true);
							
						}
						else { // login failed
							if(conditions.size() == 0) { // ID and password are wrong
								// error message
								JOptionPane.showMessageDialog(null, "ID and password are wrong.", "Login Error",
									JOptionPane.WARNING_MESSAGE);
							}
							else if(conditions.get(0).equals("ID")) { // password is wrong
								// error message
								JOptionPane.showMessageDialog(null, "Password is wrong.", "Login Error",
										JOptionPane.WARNING_MESSAGE);
							}
							else { // ID is wrong
								// error message
								JOptionPane.showMessageDialog(null, "ID is wrong.", "Login Error",
										JOptionPane.WARNING_MESSAGE);
							}
							
						}
					}
				});
				loginButton.setActionCommand("OK");
				buttonPane.add(loginButton);
				getRootPane().setDefaultButton(loginButton);
			}
			{
				/**
				 * set cancelButton
				 */
				cancelButton = new JButton("Cancel");
				cancelButton.setBackground(SystemColor.inactiveCaption);
				cancelButton.setForeground(Color.DARK_GRAY);
				cancelButton.setFont(new Font("Maiandra GD", Font.BOLD, 12));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// login cancel message
						JOptionPane.showMessageDialog(null, "Login has been canceled.", "Log in cancel",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	/**
	 * read user information and return Whether the ID and password match
	 */
	public ArrayList<String> readUserInfo() {
		ArrayList<String> flage = new ArrayList();
		try {
			// to read "user_info.txt" file
			FileInputStream fileObject = new FileInputStream("user_info.txt");
			Scanner userInfo = new Scanner(fileObject);

			// read "user_info.txt" file line by line
			while (userInfo.hasNext()) {
				// for storing information separately from tags
				String lineContent[] = userInfo.nextLine().split(":");
				// "Name" tag
				if (lineContent[0].equals("Name") && lineContent[1].length() > 0) {
					name = lineContent[1];
				}
				// "ID" tag
				if (lineContent[0].equals("ID") && lineContent[1].length() > 0) {
					// ID entered correctly
					if (lineContent[1].equals(textFieldID.getText()))
						flage.add("ID"); // set ID flage
				}
				// "Password" tag
				if (lineContent[0].equals("Password") && lineContent[1].length() > 0) {
					// password entered correctly
					if (lineContent[1].equals(textFieldPassword.getText()))
						flage.add("PW"); // set PW flage
				}
			}
			userInfo.close();

		} catch (FileNotFoundException e) {
			// open register GUI
			Register register = new Register();
			register.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			register.setVisible(true);
		}
		return flage; // return Whether the ID and password match
	}

}
