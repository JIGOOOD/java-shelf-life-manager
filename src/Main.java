
import javax.swing.JDialog;

/*

 * This code is final project of JAVA Programming Lab.

 */

/**
 * * This is the class in which the program starts
 * 
 * @version 1.0 5 June 2022
 * 
 * @author Jiyeon Park
 * 
 */
public class Main {

	/**
	 * open shelf life manager
	 */
	public Main() {
		ShelfLifeManager shelfLifeManager = new ShelfLifeManager();
		shelfLifeManager.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		shelfLifeManager.setVisible(true);
	}
	
	/**
	 * start program
	 */
	public static void main(String[] args) {
		Main app = new Main();	
	}
}
