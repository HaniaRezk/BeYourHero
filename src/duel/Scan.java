package duel;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

//this class will allow us to manage the use of Scanner for the whole program
public class Scan {
	    private static Scanner scanner = new Scanner(System.in);

	    private Scan() {
	    }

	    public static Scanner getScanner() {
	        return scanner;
	    }

	    public static void closeScanner() {
	        scanner.close();
	    } 
	    //this method will be useful for our JUNIT classes
	    // Redirect the Scanner to read from a String
	    public static void redirectScannerToString(String input) {
	        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
	        scanner.close(); // Close the existing scanner
	        System.setIn(inputStream);
	        scanner = new Scanner(System.in);
	     
	    }


	    // Reset the Scanner to read from System.in
	    public static void resetScanner(InputStream original) {
	    	 scanner.close(); // Close the existing scanner
	    	 System.setIn(original);
	    	
	         // Reopen the scanner with the original input stream
	    	 scanner = new Scanner(System.in);
	       
	    }
	}

