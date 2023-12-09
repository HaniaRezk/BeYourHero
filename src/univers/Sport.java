package univers;
/**
 * The Sport enum represents different sports that can be associated with characters in the context of the Olympics.
 */
public enum Sport {
	   TENNIS,
	    BASKETBALL,
	    FOOTBALL,
	    SWIMMING;

	/**
     * Displays all sports along with their corresponding indices.
     */
    public static void displayAllSports() {
        for (Sport sport : Sport.values()) {
        	 System.out.println((sport.ordinal() + 1) + ". " + sport.name());
        }
    }
   
}
