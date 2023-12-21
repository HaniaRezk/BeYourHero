package univers;
/**
 * The Coach class represents a coach character in our context: The OLympics.
 * It extends the PersonnageDeBase class and provides additional functionality
 * specific to coaches.
 */
public class Coach extends PersonnageDeBase {
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a Coach with the specified name and sport.
     *
     * @param nom   The name of the coach.
     * @param sport The sport associated with the coach.
     */
	public Coach(String nom, Sport sport) {
		super(nom,sport);
	}
	
	/**
     * Returns a string representation of the coach, including their name and associated sport.
     *
     * @return A string representation of the coach.
     */
	@Override
    public String toString() {
        return (super.toString()+ " ,et vous etes coach de " + super.getSport());
    }
	
	/**
     * Checks if this coach is equal to another coach character. Coaches are considered equal if
     * they have the same name and are associated with the same sport.
     *
     * @param obj The object(coach) to compare.
     * @return True if the coaches are equal, false otherwise.
     */
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof Coach) {
        	Coach c=(Coach) obj;
        	if (getNom().equals(c.getNom()) && getSport().equals(c.getSport())) {
        		return true;
        		
        	}  	
        }
       	return false;
    }

	 
}
