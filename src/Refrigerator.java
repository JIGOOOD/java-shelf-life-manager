import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;

/*

 * This code is final project of JAVA Programming Lab.

 */

/**
 * * This is the class that defines the functions necessary to input and delete
 * the shelf life of the ingredients.
 * 
 * @version 1.0 5 June 2022
 * 
 * @author Jiyeon Park
 * 
 */
public class Refrigerator extends JFrame implements RefrigeratorFunctions{

	private String subclassFileName; // for storing the file names corresponding to subclass
	private String thirty[] = { "4", "6", "9", "11" }; // for storing the months made up of 30 days
	private String thirty_one[] = { "1", "3", "5", "7", "8", "10", "12" }; // for storing the months made up of 31 days
	ArrayList<String> ingredient; // for storing the ingredients read from the file
	
	/**
	 * 
	 */
	public Refrigerator() {
		ingredient = new ArrayList<String>(); // initialize the variable ingredient
	}

	/**
	 * Read shelf life and ingredients written on the file
	 */
	@Override
	public void readFile() {
		try {

			// To read a file whose name is the return value of calling function
			// getSubclassFileName()
			FileInputStream fileObject1 = new FileInputStream(getSubclassFileName());
			Scanner scanner = new Scanner(fileObject1);

			// reads the value from the file and puts it in the array list
			while (scanner.hasNext()) {
				ingredient.add(scanner.nextLine());
			}
			scanner.close();
			Collections.sort(ingredient); // sort by shelf life in ascending order
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Write the shelf life and ingredients on the file
	 */
	@Override
	public void writeFile() {
		try {

			// To write a file whose name is the return value of calling function
			// getSubclassFileName()
			FileOutputStream fileObject2 = new FileOutputStream(getSubclassFileName(), false); // overwrite the file
			PrintWriter writer = new PrintWriter(fileObject2);

			Iterator iterator = ingredient.iterator(); // for visiting through all values in an arraylist
			// write the values of the array list to a file
			while (iterator.hasNext()) {
				writer.println(iterator.next());
			}
			writer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Add ingredients on the file
	 */
	@Override
	public void addIngredients() {
		//
		String inputIngredient = JOptionPane.showInputDialog(null,
				"Enter the shelf life in the order of year, month, day. "
						+ "\nThen, enter the ingredients with a space. (ex. 20220604 potato)",
				"Add ingredients individually", JOptionPane.INFORMATION_MESSAGE);

		if (inputIngredient == null) { // when the user presses the cancel button on the dialog
			// empty
		} else { // when the user presses the ok button on the dialog

			Pattern pattern = Pattern.compile("^\\d{8}\\s[a-zA-Z]+$"); // for storing the regular expression for date
																		// and ingredients (yyyyMMdd ingredient)
			Matcher matcher = pattern.matcher(inputIngredient);// for checking whether user input matches a regular
																// expression

			if (inputIngredient.equals("")) { // if a space is entered

				// error message
				JOptionPane.showMessageDialog(null,
						"You didn't enter anything. \nPlease enter the shelf life and ingredients.", "Empty input",
						JOptionPane.WARNING_MESSAGE);
				addIngredients(); // open the input dialog
			} else if (matcher.find() == false) { // when the input format (yyyyMMdd ingredient) is not observed

				// error message
				JOptionPane.showMessageDialog(null, "Please enter in the correct format.", "Wrong format",
						JOptionPane.WARNING_MESSAGE);
				addIngredients(); // open the input dialog
			} else { // when the input format (yyyyMMdd ingredient) is observed

				String lineContent[] = inputIngredient.split(" "); // divide and store the date and ingredients
				int date = Integer.parseInt(lineContent[0]); // for storing the date
				int year = date / 10000; // for storing the year
				int month = (date % 10000) / 100; // for storing the month
				int day = date % 100; // for storing the day
				int today = Integer.parseInt(getDate()); // for storing the today's date
				
				if (today >= date) { // if user want to enter an expired ingredients
					// error message
					JOptionPane.showMessageDialog(null, "The ingredient that have already expired cannot be entered.",
							"Wrong format", JOptionPane.WARNING_MESSAGE);
					addIngredients(); // open the input dialog
				} else if ((month > 12) || (month == 2 && day > 29) // date out of range
						|| (Arrays.asList(thirty).contains(Integer.toString(month)) && day > 30)
						|| (Arrays.asList(thirty_one).contains(Integer.toString(month)) && day > 31)) {

					// error message
					JOptionPane.showMessageDialog(null, "You are out of the range of months or days you can enter.",
							"Wrong format", JOptionPane.WARNING_MESSAGE);
					addIngredients(); // open the input dialog
				} else { // if no error occurs
					try {
						// To read a file whose name is the return value of calling function
						// getSubclassFileName()
						FileOutputStream fileObject = new FileOutputStream(getSubclassFileName(), true); // append
						PrintWriter friFile = new PrintWriter(fileObject);
						friFile.println(inputIngredient); // write inputIngredient to the file
						sort(); // sort ingredients in ascending order by shelf life
						friFile.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}

	/**
	 * Delete the ingredients on the file
	 */
	@Override
	public void deleteIngredients() {
		// TODO Auto-generated method stub

		readFile(); // read the file and sort the ingredients in ascending order, and store it in
					// the array list
		String[] arrayIngredients = new String[ingredient.size()]; // for storing an arraylist as an array
		int size = 0; // for representing the index of an array
		// store the values of an array list in an array
		for (String temp : ingredient) {
			arrayIngredients[size++] = temp;
		}

		// 40개 넘어가면 나눠서 출력

		JList listOfIngredients = new JList(arrayIngredients); // for storing the array as a JList
		// Display all array values in a dialog
		JOptionPane.showConfirmDialog(null, listOfIngredients, "Select the ingredients to be deleted",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		String seletedValue = String.valueOf(listOfIngredients.getSelectedValue()); // for storing the value selected by
																					// the user
		ingredient.remove(seletedValue); // delete seletedValue from file
		writeFile(); // store the value of arraylist to the file
		ingredient.clear(); // clear the arraylist
	}

	/**
	 * Sort the ingredients in the order of shelf life
	 */
	@Override
	public void sort() {
		readFile(); // read the file and sort the ingredients in ascending order, and store it in
		// the array list
		writeFile(); // store the value of arraylist to the file
		ingredient.clear(); // clear the arraylist
	}

	/**
	 * Get today's date
	 */
	@Override
	public String getDate() {
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd"); // format a date as yyyyMMdd like 20220604
		Calendar calendar = Calendar.getInstance(); // get and store the current date and time information of the system
		String today = date.format(calendar.getTime()); // store today's date
		return today;
	}

	/**
	 * show shelf life of the ingredients on the GUI
	 */
	@Override
	public String showShelfLife() {
		String shelfLife = ""; // for storing the all ingredients on the file as string

		sort(); // sort the ingredients in the order of shelf life

		try {
			// To read a file whose name is the return value of calling function
			// getSubclassFileName()
			File file = new File(getSubclassFileName());
			Scanner scan = new Scanner(file);
			// reads a file line by line
			while (scan.hasNext()) {
				shelfLife += scan.nextLine();
				shelfLife += "\n";
			}
			shelfLife.replace("\n", "br"); // express the new line in the GUI
			scan.close();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return shelfLife;
	}

	/**
	 * get @param fileName and set the variable subclassFileName
	 */
	public void setSubclassFileName(String fileName) {
		subclassFileName = fileName;
	}

	/**
	 * @return subclassFileName
	 */
	public String getSubclassFileName() {
		return subclassFileName;
	}

}
