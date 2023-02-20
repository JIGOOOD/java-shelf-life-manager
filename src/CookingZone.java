import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

import java.awt.event.*;

/*

 * This code is final project of JAVA Programming Lab.

 */
/**
 * * This is a class that helps user cook with ingredients that are near the shelf life.
 * 
 * @version 1.0 5 June 2022
 * 
 * @author Jiyeon Park
 * 
 */
public class CookingZone extends JFrame {

	private JPanel contentPane; // for storing all components
	private JPanel cookPanel; // for storing components related with cook
	private JPanel refrigeratorPanel; // for storing components related with refrigerator
	private JPanel friPanel; // for storing components related with fridge
	private JPanel frePanel; // for storing components related with freezer
	private JPanel rtPanel; // for storing components related with room temperature
	private JScrollPane friScrollPane; // for indicating scroll bar
	private JLabel lblFridge; // for indicating fridge
	private JTextArea friTextArea; // for showing the ingredient in fridge
	private JScrollPane freScrollPane; // for indicating scroll bar
	private JLabel lblFreezer; // for indicating freezer
	private JTextArea freTextArea; // for showing the ingredient in freezer
	private JScrollPane rtScrollPane; // for indicating scroll bar
	private JTextArea rtTextArea; // for showing the ingredient in room temperature
	private JLabel lblRoomTemperature; // for indicating room temperature
	private JButton btnGoBack; // for indicating go back button
	private JLabel lblinfo1; // for indicating information
	private JLabel lblinfo2; // for indicating information
	private JButton btnRecipeSite1; // for showing recipe website
	private JButton btnRecipeSite2; // for showing recipe website
	private JButton btnYoutube; // for showing youtube website
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CookingZone frame = new CookingZone();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public CookingZone() throws ParseException {
		/**
		 * set contentpane
		 */
		setTitle("Cooking Zone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		/**
		 * set refrigeratorPanel
		 */
		refrigeratorPanel = new JPanel();
		contentPane.add(refrigeratorPanel);
		refrigeratorPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		/**
		 * set friPanel
		 */
		friPanel = new JPanel();
		refrigeratorPanel.add(friPanel);
		friPanel.setLayout(new BorderLayout(0, 0));
		
		/**
		 * set friTextArea
		 */
		friTextArea = new JTextArea(showShortShelfLife("fridge.txt"));
		friTextArea.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		friScrollPane = new JScrollPane(friTextArea);
		friPanel.add(friScrollPane, BorderLayout.CENTER);
		friTextArea.setEditable(false); // user cannot edit
		
		/**
		 * set lblFridge
		 */
		lblFridge = new JLabel("Fridege");
		lblFridge.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		lblFridge.setHorizontalAlignment(SwingConstants.CENTER);
		friScrollPane.setColumnHeaderView(lblFridge);
		
		/**
		 * set frePanel
		 */
		frePanel = new JPanel();
		refrigeratorPanel.add(frePanel);
		frePanel.setLayout(new BorderLayout(0, 0));
		
		/**
		 * set freTextArea
		 */
		freTextArea = new JTextArea(showShortShelfLife("freezer.txt"));
		freTextArea.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		freScrollPane = new JScrollPane(freTextArea);
		frePanel.add(freScrollPane, BorderLayout.CENTER);
		freTextArea.setEditable(false); // user cannot edit
		
		/**
		 * set lblFreezer
		 */
		lblFreezer = new JLabel("Freezer");
		lblFreezer.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		lblFreezer.setHorizontalAlignment(SwingConstants.CENTER);
		freScrollPane.setColumnHeaderView(lblFreezer);
		
		/**
		 * set rtPanel
		 */
		rtPanel = new JPanel();
		refrigeratorPanel.add(rtPanel);
		rtPanel.setLayout(new BorderLayout(0, 0));
		
		/**
		 * set rtTextArea
		 */
		rtTextArea = new JTextArea(showShortShelfLife("room_temperature.txt"));
		rtTextArea.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		rtScrollPane = new JScrollPane(rtTextArea);
		rtPanel.add(rtScrollPane, BorderLayout.CENTER);
		rtTextArea.setEditable(false); // user cannot edit
		
		/**
		 * set lblRoomTemperature
		 */
		lblRoomTemperature = new JLabel("Room Temperature");
		lblRoomTemperature.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		lblRoomTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		rtScrollPane.setColumnHeaderView(lblRoomTemperature);
		
		/**
		 * set cookPanel
		 */
		cookPanel = new JPanel();
		contentPane.add(cookPanel);
		cookPanel.setLayout(null);
		
		/**
		 * set btnGoBack
		 */
		btnGoBack = new JButton("Go main home");
		btnGoBack.setFont(new Font("Maiandra GD", Font.BOLD, 12));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// open shelf life manager
				ShelfLifeManager frame = new ShelfLifeManager();
				frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		btnGoBack.setBackground(SystemColor.inactiveCaption);
		btnGoBack.setBounds(408, 201, 155, 23);
		cookPanel.add(btnGoBack);
		
		/**
		 * set lblinfo1
		 */
		lblinfo1 = new JLabel("The above ingredients have a shelf life of less than or equal to 7 days.");
		lblinfo1.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		lblinfo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblinfo1.setBounds(0, 10, 575, 15);
		cookPanel.add(lblinfo1);
		
		/**
		 * set lblinfo2
		 */
		lblinfo2 = new JLabel("Try cooking with the above ingredients!");
		lblinfo2.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		lblinfo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblinfo2.setBounds(0, 26, 575, 15);
		cookPanel.add(lblinfo2);
		
		/**
		 * set btnRecipeSite1
		 */
		btnRecipeSite1 = new JButton("Recipe Website1");
		btnRecipeSite1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// open recipe website
					Desktop.getDesktop().browse(new URI("https://www.10000recipe.com/"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRecipeSite1.setBackground(SystemColor.info);
		btnRecipeSite1.setBounds(12, 96, 155, 33);
		btnRecipeSite1.setFont(new Font("Maiandra GD", Font.BOLD, 12));
		cookPanel.add(btnRecipeSite1);
		
		/**
		 * set btnRecipeSite2
		 */
		btnRecipeSite2 = new JButton("Recipe Website2");
		btnRecipeSite2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// open recipe website
					Desktop.getDesktop().browse(new URI("https://wtable.co.kr/store/"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRecipeSite2.setBackground(SystemColor.info);
		btnRecipeSite2.setBounds(211, 96, 155, 33);
		btnRecipeSite2.setFont(new Font("Maiandra GD", Font.BOLD, 12));
		cookPanel.add(btnRecipeSite2);
		
		/**
		 * btnYoutube
		 */
		btnYoutube = new JButton("Youtube");
		btnYoutube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// open youtube website
					Desktop.getDesktop().browse(new URI("https://www.youtube.com/"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnYoutube.setBackground(SystemColor.info);
		btnYoutube.setBounds(408, 96, 155, 33);
		btnYoutube.setFont(new Font("Maiandra GD", Font.BOLD, 12));
		cookPanel.add(btnYoutube);
	}
	
	/**
	 * show short shelf life ingredients
	 */
	public String showShortShelfLife(String fileName) throws ParseException {
		
		String shelfLifeString = ""; // for storing the all ingredients in fileName
		Refrigerator refrigerator = new Refrigerator(); //
		String todayString = refrigerator.getDate(); // to storing the totay date
		String dateString; // to storing the date of ingredients
		
		// to save todayString in yyyyMMdd format
		Date today = new SimpleDateFormat("yyyyMMdd").parse(todayString);
		
		
		try {
			// to read the fileName file
			FileInputStream fileObject = new FileInputStream(fileName);
			Scanner scanner = new Scanner(fileObject);
			
			// reda fileName file
			while(scanner.hasNext()) {
				
				// to distinguish between shelf life and ingredients
				String lineContents[] = scanner.nextLine().split(" ");
				dateString = lineContents[0]; // for storing the shelf life
				// to save dateString in yyyyMMdd format
				Date date = new SimpleDateFormat("yyyyMMdd").parse(dateString);
				
				// for storing the difference in seconds between dateString and todayString
				long diffSec = (date.getTime() - today.getTime()) / 1000;
				// for storing the difference in days between dateString and todayString
				long diffDays = diffSec / (24*60*60); 
				
				// if the day difference is 7 or less
				if(diffDays<=7) {
					shelfLifeString = shelfLifeString + lineContents[0] + " " + lineContents[1] + "  -  " + diffDays + "days" +"\n";
				}
				else {
					break;
				}
			}
			shelfLifeString.replace("\n", "<br>"); // to express a new line in the GUI
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shelfLifeString;
	}
	
}
