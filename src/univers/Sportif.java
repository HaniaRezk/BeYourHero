package univers;
/**
 * The Sportif class represents an athlete character in our context: The OLympics.
 * It extends the PersonnageDeBase class and provides additional functionality
 * specific to athletes.
 */

public class Sportif extends PersonnageDeBase{
	private static final long serialVersionUID = 1L;
	/**
     * The level of the athlete.
     */
	private int niveau;
	
	/**
     * Constructs a Sportif with the specified name, sport, and level.
     *
     * @param nom    The name of the athlete.
     * @param sport  The sport associated with the athlete.
     * @param niveau The level of the athlete.
     */
	public Sportif(String nom, Sport sport, int niveau) {
		super(nom,sport);
		this.niveau=niveau;
	}
	
	/**
     * Returns a string representation of the athlete, including their name, sport, and level.
     *
     * @return A string representation of the athlete.
     */
	 @Override
	    public String toString() {
	        return (super.toString()+ " ,le sport que vous pratiquez est: " + super.getSport()+" ,votre niveau est "+ niveau);
	    }
	 
	 /**
	     * Checks if this athlete is equal to another athlete character. Athletes are considered equal if
	     * they have the same name, practice the same sport, and have the same level.
	     *
	     * @param obj The object(Athlete) to compare.
	     * @return True if the athletes are equal, false otherwise.
	     */
	 @Override
	 public boolean equals(Object obj) {
	        if (obj instanceof Sportif) {
	        	Sportif c=(Sportif) obj;
	        	if (getNom().equals(c.getNom()) && getSport().equals(c.getSport()) && (c.niveau==niveau)) {
	        		return true;
	        		
	        	}  	
	        }
	       	return false;
	    }
	 

}
