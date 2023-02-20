/*

 * This code is final project of JAVA Programming Lab.

 */

/**
 * * This is the interface that declares the functions necessary to input and
 * delete the shelf life of the ingredients.
 * 
 * @version 1.0 5 June 2022
 * 
 * @author Jiyeon Park
 * 
 */
public interface RefrigeratorFunctions {

	/**
	 * Read shelf life and ingredients written on the file
	 */
	public void readFile();

	/**
	 * Write the shelf life and ingredients on the file
	 */
	public void writeFile();

	/**
	 * Add ingredients on the file
	 */
	public void addIngredients();

	/**
	 * Delete the ingredients on the file
	 */
	public void deleteIngredients();

	/**
	 * Sort the ingredients in the order of shelf life
	 */
	public void sort();

	/**
	 * Get today's date
	 */
	public String getDate();

	/**
	 * Show shelf life of the ingredients on the GUI
	 */
	public String showShelfLife();
}
