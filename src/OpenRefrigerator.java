import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

/*

 * This code is final project of JAVA Programming Lab.

 */

/**
 * * This is the class is the digital refrigerator
 * 
 * @version 1.0 5 June 2022
 * 
 * @author Jiyeon Park
 * 
 */
public class OpenRefrigerator extends JFrame {

	private JPanel contentPane; // for storing all components
	private JMenuBar menuBar; // for indicating the menu bar
	private JMenu mnFridge; // for indicating the fridge menu
	private JMenu mnFreezer; // for indicating the freezer menu
	private JMenu mnRoomTemperature; // for indicating the room temperature menu
	private JMenu mnGoBack; // for indicating go back menu
	private JMenuItem mntmGoHome; // for indicating go home menu item
	private JMenuItem rt_DeleteIngredients; // for removing ingredients from the room temperature
	private JMenuItem rt_ShelfLife; // for indicating shelf life of ingredients at the room temperature
	private JMenuItem fri_ShelfLife; // for indicating shelf life of ingredients at the fridge
	private JMenuItem fri_DeleteIngredients; // for removing ingredients from the fridge
	private JMenuItem fre_ShelfLife; // for indicating shelf life of ingredients at the freezer
	private JMenuItem fre_DeleteIngredients; // for removing ingredients from the freezer
	private JMenuItem fri_AddIngredients; // for putting ingredients in the fridge
	private JMenuItem fre_AddIngredients;// for putting ingredients in the freezer
	private JMenuItem rt_AddIngredients; // for putting ingredients in the room temperature
	private JTextArea textArea; // for showing the shelf life of ingredients
	private JScrollPane scrollPane; // for indicating scroll bar
	private Refrigerator refrigerators[]; // for dividing the refrigerator into three (fridge, freezer, room temperature)
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenRefrigerator frame = new OpenRefrigerator();
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
	public OpenRefrigerator() {
		
		refrigerators = new Refrigerator[3]; // initialize refrigerators
		refrigerators[0] = new Fridge(); // store fridge information
		refrigerators[1] = new Freezer(); // store freezer information
		refrigerators[2] = new RoomTemperature(); // store room temperature information
		
		/**
		 * set contentPane
		 */
		setTitle("Refrigerator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 457);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		/**
		 * set textArea
		 */
		textArea = new JTextArea("Select the desired operation from the menu bar.");
		textArea.setFont(new Font("Myanmar Text", Font.BOLD, 17));
		textArea.setEditable(false); // user cannot edit
		scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane);
		
		/**
		 * set menuBar
		 */
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		/**
		 * set mnFridge
		 */
		mnFridge = new JMenu("Fridge");
		mnFridge.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		menuBar.add(mnFridge);
		
		/**
		 * fri_ShelfLife
		 */
		fri_ShelfLife = new JMenuItem("Shelf Life");
		fri_ShelfLife.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		fri_ShelfLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String shelfLife = refrigerators[0].showShelfLife(); // for storing all the ingredients in the fridge
				textArea.setText(shelfLife); // show all the ingredients in the fridge
			}
		});
		mnFridge.add(fri_ShelfLife);
		
		/**
		 * set fri_DeleteIngredients
		 */
		fri_DeleteIngredients = new JMenuItem("Delete ingredients");
		fri_DeleteIngredients.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		fri_DeleteIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrigerators[0].deleteIngredients(); // for deleting the ingredients in the fridge
				// show deleted information
				String shelfLife = refrigerators[0].showShelfLife();
				textArea.setText(shelfLife);
			}
		});
		
		/**
		 * set fri_AddIngredients
		 */
		fri_AddIngredients = new JMenuItem("Add ingredients");
		fri_AddIngredients.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		mnFridge.add(fri_AddIngredients);
		fri_AddIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrigerators[0].addIngredients(); // for adding the ingredients in the fridge
				// show added information
				String shelfLife = refrigerators[0].showShelfLife();
				textArea.setText(shelfLife);
			}
		});
		mnFridge.add(fri_DeleteIngredients);
		
		/**
		 * set mnFreezer
		 */
		mnFreezer = new JMenu("Freezer");
		mnFreezer.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		menuBar.add(mnFreezer);
		
		/**
		 * set fre_ShelfLife
		 */
		fre_ShelfLife = new JMenuItem("Shelf Life");
		fre_ShelfLife.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		fre_ShelfLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String shelfLife = refrigerators[1].showShelfLife(); // for storing all the ingredients in the freezer
				textArea.setText(shelfLife); // show all the ingredients in the freezer
			}
		});
		mnFreezer.add(fre_ShelfLife);
		
		/**
		 * set fre_AddIngredients
		 */
		fre_AddIngredients = new JMenuItem("Add ingredients");
		fre_AddIngredients.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		mnFreezer.add(fre_AddIngredients);
		fre_AddIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrigerators[1].addIngredients(); // for adding the ingredients in the freezer
				// show added information
				String shelfLife = refrigerators[1].showShelfLife();
				textArea.setText(shelfLife);
			}
		});
		
		/**
		 * set fre_fri_DeleteIngredients
		 */
		fre_DeleteIngredients = new JMenuItem("Delete Ingredients");
		fre_DeleteIngredients.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		fre_DeleteIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrigerators[1].deleteIngredients(); // for deleting the ingredients in the freezer
				// show deleted information
				String shelfLife = refrigerators[1].showShelfLife(); 
				textArea.setText(shelfLife);
			}
		});
		mnFreezer.add(fre_DeleteIngredients);
		
		/**
		 * set mnRoomTemperature
		 */
		mnRoomTemperature = new JMenu("Room Temperature");
		mnRoomTemperature.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		menuBar.add(mnRoomTemperature);
		
		rt_ShelfLife = new JMenuItem("Shelf Life");
		rt_ShelfLife.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		rt_ShelfLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String shelfLife = refrigerators[2].showShelfLife(); // for storing all the ingredients in the room temperature
				textArea.setText(shelfLife); // show all the ingredients in the fridge
			}
		});
		mnRoomTemperature.add(rt_ShelfLife);
		
		/**
		 * set rt_AddIngredients
		 */
		rt_AddIngredients = new JMenuItem("Add ingredients");
		rt_AddIngredients.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		mnRoomTemperature.add(rt_AddIngredients);
		rt_AddIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrigerators[2].addIngredients() ;// for adding the ingredients in the room temperature
				// show added information
				String shelfLife = refrigerators[2].showShelfLife();
				textArea.setText(shelfLife);
			}
		});
		
		/**
		 * set rt_DeleteIngredients
		 */
		rt_DeleteIngredients = new JMenuItem("Delete Ingredients");
		rt_DeleteIngredients.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		rt_DeleteIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// for deleting the ingredients in the room temperature
				refrigerators[2].deleteIngredients();
				// show deleted information
				String shelfLife = refrigerators[2].showShelfLife(); 
				textArea.setText(shelfLife);
			}
		});
		mnRoomTemperature.add(rt_DeleteIngredients);
		mnRoomTemperature.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		
		/**
		 * set mnGoBack
		 */
		mnGoBack = new JMenu("Go back");
		mnGoBack.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		menuBar.add(mnGoBack);
		
		/**
		 * set mntmGoHome
		 */
		mntmGoHome = new JMenuItem("Go main home");
		mntmGoHome.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
		mntmGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// go back the shelf life manager
				ShelfLifeManager frame = new ShelfLifeManager();
				frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		mnGoBack.add(mntmGoHome);
	}

}
