import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.*;

/*

 * This code is final project of JAVA Programming Lab.

 */

/**
 * * This is the class that users sign up for.
 * 
 * @version 1.0 5 June 2022
 * 
 * @author Jiyeon Park
 * 
 */
public class Register extends JDialog {
	private JPanel contentPanel; // for storing all panels except buttonpanel
	private JTextField textFieldID; // for storing the ID
	private JPasswordField passwordField; // for storing the password
	private JPasswordField comfirmPasswordField; // for storing the confirm password
	private JTextField textFieldName; // for storing the name
	private JTextField textFieldEmail; // for storing the eamil
	private JPanel panelInfo; // for containing the components related with information
	private JLabel lblDescription1; // for indicating the information
	private JLabel lblDescription2; // for indicating the information
	private JPanel panelEmail; // for containing the components related with email
	private JLabel lblEmail; // for indicating the email
	private JPanel panelName; // for containing the components related with name
	private JLabel lblName; // for indicating the name
	private JPanel panelID; // for containing the components related with ID
	private JLabel lblID; // for indicating the ID
	private JPanel panelPW; // for containing the components related with password
	private JLabel lblPassword; // for indicating the password
	private JPanel panelComfirmPW; // for containing the components related with confirm password
	private JLabel lblConfirmPassword; // for indicating the confirm password
	private JPanel buttonPane; // for containing the components related with button
	private JButton registerButton; // for indicating the register button
	private JButton cancelButton; // for indicating the cancel button

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Register dialog = new Register();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Register() {

		/**
		 * set contentPanel
		 */
		setTitle("Register");
		setBounds(100, 100, 454, 343);
		contentPanel = new JPanel();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(6, 0, 0, 0));
		{
			/**
			 * set panelInfo
			 */
			panelInfo = new JPanel();
			FlowLayout fl_panelInfo = (FlowLayout) panelInfo.getLayout();
			fl_panelInfo.setVgap(0);
			fl_panelInfo.setHgap(0);
			contentPanel.add(panelInfo);
			{
				/**
				 * set lblDescription1
				 */
				lblDescription1 = new JLabel("Welcome to the shelf life management service.");
				lblDescription1.setFont(new Font("Maiandra GD", Font.BOLD, 12));
				panelInfo.add(lblDescription1);
			}
			{
				/**
				 * set lblDescription2
				 */
				lblDescription2 = new JLabel("Please enter the information below to register as a member!");
				lblDescription2.setFont(new Font("Maiandra GD", Font.BOLD, 12));
				panelInfo.add(lblDescription2);
			}
		}
		{
			/**
			 * set panelEmail
			 */
			panelEmail = new JPanel();
			contentPanel.add(panelEmail);
			panelEmail.setLayout(null);
			{
				/**
				 * set lblEmail
				 */
				lblEmail = new JLabel("Email");
				lblEmail.setFont(new Font("Myanmar Text", Font.BOLD, 12));
				lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
				lblEmail.setBounds(134, 10, 81, 15);
				panelEmail.add(lblEmail);
			}
			{
				/**
				 * set textFieldEmail
				 */
				textFieldEmail = new JTextField();
				textFieldEmail.setColumns(10);
				textFieldEmail.setBounds(242, 7, 93, 21);
				panelEmail.add(textFieldEmail);
			}
		}
		{
			/**
			 * set panelName
			 */
			panelName = new JPanel();
			contentPanel.add(panelName);
			panelName.setLayout(null);
			{
				/**
				 * set lblName
				 */
				lblName = new JLabel("Name");
				lblName.setFont(new Font("Myanmar Text", Font.BOLD, 12));
				lblName.setHorizontalAlignment(SwingConstants.TRAILING);
				lblName.setBounds(132, 10, 82, 15);
				panelName.add(lblName);
			}
			{
				/**
				 * set textFieldName
				 */
				textFieldName = new JTextField();
				textFieldName.setColumns(10);
				textFieldName.setBounds(243, 7, 93, 21);
				panelName.add(textFieldName);
			}
		}
		{
			/**
			 * set panelID
			 */
			panelID = new JPanel();
			contentPanel.add(panelID);
			panelID.setLayout(null);
			{
				/**
				 * set lblID
				 */
				lblID = new JLabel("ID");
				lblID.setFont(new Font("Myanmar Text", Font.BOLD, 12));
				lblID.setHorizontalAlignment(SwingConstants.TRAILING);
				lblID.setBounds(143, 10, 68, 15);
				panelID.add(lblID);
			}
			{
				/**
				 * set textFieldID
				 */
				textFieldID = new JTextField();
				textFieldID.setBounds(243, 7, 93, 21);
				panelID.add(textFieldID);
				textFieldID.setColumns(10);
			}
		}
		{
			/**
			 * set panelPW
			 */
			panelPW = new JPanel();
			contentPanel.add(panelPW);
			panelPW.setLayout(null);
			{
				/**
				 * set lblPassword
				 */
				lblPassword = new JLabel("Password");
				lblPassword.setFont(new Font("Myanmar Text", Font.BOLD, 12));
				lblPassword.setBounds(153, 10, 60, 15);
				panelPW.add(lblPassword);
			}
			{
				/**
				 * set passwordField
				 */
				passwordField = new JPasswordField();
				passwordField.setBounds(242, 7, 93, 21);
				panelPW.add(passwordField);
			}
		}
		{
			/**
			 * set panelComfirmPW
			 */
			panelComfirmPW = new JPanel();
			contentPanel.add(panelComfirmPW);
			panelComfirmPW.setLayout(null);
			{
				/**
				 * set lblConfirmPassword
				 */
				lblConfirmPassword = new JLabel("Confirm Password");
				lblConfirmPassword.setFont(new Font("Myanmar Text", Font.BOLD, 12));
				lblConfirmPassword.setBounds(104, 10, 108, 15);
				panelComfirmPW.add(lblConfirmPassword);
			}
			{
				/**
				 * set comfirmPasswordField
				 */
				comfirmPasswordField = new JPasswordField();
				comfirmPasswordField.setBounds(242, 7, 93, 21);
				panelComfirmPW.add(comfirmPasswordField);
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
				 * set registerButton
				 */
				registerButton = new JButton("Register");
				registerButton.setFont(new Font("Maiandra GD", Font.BOLD, 12));
				registerButton.setBackground(SystemColor.inactiveCaption);
				registerButton.setForeground(Color.DARK_GRAY);
				registerButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						boolean result = writeUserInfo(); // for storing whether or not you signed up
						// signup successful
						if (result) {
							// show welcome message
							JOptionPane.showMessageDialog(null,
									"Thank you. You are registered. \n Welcome to Shelf Life Manager!",
									"Complete registration", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							// open login GUI
							Login login = new Login();
							login.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							login.setVisible(true);
						}

					}
				});
				registerButton.setActionCommand("OK");
				buttonPane.add(registerButton);
				getRootPane().setDefaultButton(registerButton);
			}
			{
				/**
				 * set cancelButton
				 */
				cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Maiandra GD", Font.BOLD, 12));
				cancelButton.setBackground(SystemColor.inactiveCaption);
				cancelButton.setForeground(Color.DARK_GRAY);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// show registeration cancle information
						JOptionPane.showMessageDialog(null, "Registration has been cancelled.", "Cancel registration",
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
	 * confirm and return whether an email exception is raised
	 */
	public boolean emailException() {
		Pattern emailPattern = Pattern.compile("\\w+@\\w+\\.\\w+(\\.\\w+)?"); // for storing the regular expression for
																				// email (example@some.some)
		Matcher emailMatcher = emailPattern.matcher(textFieldEmail.getText()); // for checking whether user input
																				// matches a regular expression
		if (emailMatcher.find() == false) { // Invalid format
			// show error message
			JOptionPane.showMessageDialog(null, "Please rewrite your email in the form example@some.some.",
					"Email Format Error", JOptionPane.ERROR_MESSAGE);
			return false; // An exception occurred.
		} else {
			return true; // An exception is not occurred.
		}
	}

	/**
	 * confirm return whether an name exception is raised
	 */
	public boolean nameException() {
		Pattern namePattern = Pattern.compile("^[a-zA-Z]+\\s[a-zA-Z]+$"); // for storing the regular expression for name
		Matcher nameMatcher = namePattern.matcher(textFieldName.getText()); // for checking whether user input matches a
																			// regular
		if (nameMatcher.find() == false) { //Invalid format
			// show error message
			JOptionPane.showMessageDialog(null, "Please write your first and last name correctly.", "Name Format Error",
					JOptionPane.ERROR_MESSAGE);
			return false; // An exception occurred.
		} else {
			return true;  // An exception is not occurred.
		}
	}

	/**
	 * confirm and return whether an ID exception is raised
	 */
	public boolean IDException() {
		if (textFieldID.getText().equals("")) { // empty ID text field
			// show error message
			JOptionPane.showMessageDialog(null, "Please enter your ID.", "ID Format Error", JOptionPane.ERROR_MESSAGE);
			return false; // An exception occurred.
		}
		return true; // An exception is not occurred.
	}

	/**
	 * save user's information to "user_info.txt" file
	 * and return whether the "user_info.txt" file exists
	 */
	public boolean writeUserInfo() {
		try {
			// for storing information about whether user entered password correctly
			// for storing whether password and confirm password are equal
			boolean password = passwordField.getText().equals(comfirmPasswordField.getText())
					&& (!(passwordField.getText().equals("") && comfirmPasswordField.getText().equals("")));
			boolean email = emailException(); // for storing whether an email exception is raised
			boolean name = nameException(); // for storing whether an name exception is raised
			boolean ID = IDException(); // for storing whether an ID exception is raised

			// password and confirm password are not entered
			if (passwordField.getText().equals("") && comfirmPasswordField.getText().equals("")) {
				// shw error message
				JOptionPane.showMessageDialog(null, "Please enter your password.", "Password Format Error",
						JOptionPane.ERROR_MESSAGE);
			} else if (!password) { // password and confirm password are different
				// show error message
				JOptionPane.showMessageDialog(null, "The password and confirmation password are different.",
						"Password Format Error", JOptionPane.ERROR_MESSAGE);
			}

			// no exception thrown
			if (name && email && password && ID) {
				// to write "user_info.txt" file
				FileOutputStream fileObject = new FileOutputStream("user_info.txt", false); // overwrite
				PrintWriter userInfo = new PrintWriter(fileObject);
				userInfo.println("Email:" + textFieldEmail.getText()); // write email to the file
				userInfo.println("Name:" + textFieldName.getText());// write name to the file
				userInfo.println("ID:" + textFieldID.getText());// write ID to the file
				userInfo.println("Password:" + passwordField.getText());// write password to the file
				userInfo.close();
				return true; // file exists
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; // file does not exist
	}
}
