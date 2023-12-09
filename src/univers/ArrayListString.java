package univers;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * The ArrayListString class is a basic wrapper around an ArrayList of Strings.
 * It provides methods for adding strings to the list, retrieving strings by index,
 * and displaying the contents of the list.
 */


public class ArrayListString {
	/**
     * The underlying ArrayList to store strings.
     */
	private ArrayList<String> list;
	
	 /**
     * Constructs an ArrayListString with an empty ArrayList.
     */
	public ArrayListString(){
		list=new ArrayList<String>();
		
	}
	
	 /**
     * Adds a string to the list.
     *
     * @param s The string to add.
     */
	public void add(String s) {
		try {
            list.add(s);
        } catch (NullPointerException e) {
            System.out.println("Erreure dans add.");
          
        }

			
		}
	
	
	/**
     * Retrieves a string from the list by index.
     *
     * @param n The index of the string to retrieve.
     * @return The string at the specified index.
     */
	public String get(int n) {
		try {
            return list.get(n);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erreure: indice invalide");
           return "Err";
        }
	
		
	}
	
	/**
     * Displays the contents of the list.
     */
	public void display() {
		 try {
	            Iterator<String> it = list.iterator();
	            while (it.hasNext()) {
	                System.out.println(it.next());
	            }
	        } catch (NullPointerException e) {
	            System.out.println("Erreure: Iterator Null.");
	            
	        }
		
	}
	
	
	

}
