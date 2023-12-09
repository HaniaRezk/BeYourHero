package duel;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * The Scan class provides utility methods to manage the use of the Scanner
 * for input throughout the program. It includes methods to get the Scanner
 * instance, close the Scanner, redirect the Scanner to read from a String,
 * and reset the Scanner to read from the original input stream.
 */
public class Scan {
	    private static Scanner scanner = new Scanner(System.in);

	    private Scan() {
	    }
	    /**
	     * Gets the global Scanner instance used for input in the program.
	     *
	     * @return The Scanner instance.
	     */
	    public static Scanner getScanner() {
	        return scanner;
	    }

	    /**
	     * Closes the global Scanner instance. Should be called at the end of the program
	     * to release resources associated with the Scanner.
	     */
	    public static void closeScanner() {
	        scanner.close();
	    } 
	    /**
	     * Redirects the global Scanner to read input from the provided String.
	     * Will be useful for the Tests 
	     * 
	     * @param input The String to set as the new input for the Scanner.
	     */
	    public static void redirectScannerToString(String input) {
	    	try {
	            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
	            scanner.close(); // Close the existing scanner
	            System.setIn(inputStream);
	            scanner = new Scanner(System.in);
	        } catch (IllegalStateException e) {
	            System.out.println("Erreure: redirection de scanner a echoue.");
	           
	        }
	      
	     
	    }


	    /**
	     * Resets the global Scanner to read input from the original input stream.
	     *
	     * @param original The original input stream to reset the Scanner to.
	     */
	    public static void resetScanner(InputStream original) {
	    	try {
	            scanner.close(); // Close the existing scanner
	            System.setIn(original);
	            scanner = new Scanner(System.in);// Reopen the scanner with the original input stream
	        } catch (IllegalStateException e) {
	            System.out.println("Erreure: redirection de scanner a echoue.");
	            
	        }
	    }
	}

