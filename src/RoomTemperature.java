import java.io.*;

/*

 * This code is final project of JAVA Programming Lab.

 */

/**
 * * This is the class that stores ingredients in the room temperature
 * 
 * @version 1.0 5 June 2022
 * 
 * @author Jiyeon Park
 * 
 */
public class RoomTemperature extends Refrigerator{
	
	public RoomTemperature() {
		setSubclassFileName("room_temperature.txt"); // for storing the file name
		try {
			// create the "room_temperature.txt" file
			FileOutputStream fileObject = new FileOutputStream(getSubclassFileName(), true);
			PrintWriter rtFile = new PrintWriter(fileObject);
			rtFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
	/**
	 * Show shelf life of the ingredients on the GUI
	 */
	@Override
	public String showShelfLife() {
		// TODO Auto-generated method stub
		return super.showShelfLife();
	}

	/**
	 * Add ingredients on the file
	 */
	@Override
	public void addIngredients() {
		// TODO Auto-generated method stub
		super.addIngredients();
	}
	
	/**
	 * Delete the ingredients on the file
	 */
	@Override
	public void deleteIngredients() {
		super.deleteIngredients();
	}

	/**
	 * Sort the ingredients in the order of shelf life
	 */
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		super.sort();
	}
	
}
