package duel;
import java.util.Scanner;

public class Scan {
	package duel;
	import java.util.Scanner;

	//this class will allow us to manage the use of Scanner for the whole program
	public class Scan {
		    private static final Scanner scanner = new Scanner(System.in);

		    private Scan() {
		    }

		    public static Scanner getScanner() {
		        return scanner;
		    }

		    public static void closeScanner() {
		        scanner.close();
		    }
		}



}
