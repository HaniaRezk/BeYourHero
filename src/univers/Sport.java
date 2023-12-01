package univers;

public enum Sport {
	   TENNIS,
	    BASKETBALL,
	    FOOTBALL,
	    SWIMMING;
	 // Method to display all sports
    public static void displayAllSports() {
        for (Sport sport : Sport.values()) {
        	 System.out.println((sport.ordinal() + 1) + ". " + sport.name());
        }
    }

}
