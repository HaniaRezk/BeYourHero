package duel;
import java.util.Scanner;
public class Scan {

		//this class will allow us to manage the use of Scanner for the whole program
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


