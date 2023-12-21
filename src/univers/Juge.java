package univers;
/**
 * The Juge class represents a judge character in our context: The OLympics.
 * It extends the PersonnageDeBase class and provides additional functionality
 * specific to judges.
 */
public class Juge extends PersonnageDeBase {
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a Juge with the specified name and sport.
     *
     * @param nom   The name of the judge.
     * @param sport The sport associated with the judge.
     */
	public Juge(String nom, Sport sport) {
		super(nom,sport);
	}

	
	/**
     * Returns a string representation of the judge, including their name and the sport they judge.
     *
     * @return A string representation of the judge.
     */
	 @Override
	    public String toString() {
	        return (super.toString()+ " ,et le sport que vous jugez est: " + super.getSport());
	    }
	 
	 /**
	     * Checks if this judge is equal to another judge character. Judges are considered equal if
	     * they have the same name and judge the same sport.
	     *
	     * @param obj The object(judge) to compare.
	     * @return True if the judges are equal, false otherwise.
	     */
	 @Override
	 public boolean equals(Object obj) {
	        if (obj instanceof Juge) {
	        	Juge c=(Juge) obj;
	        	if (getNom().equals(c.getNom()) && getSport().equals(c.getSport())) {
	        		return true;
	        		
	        	}  	
	        }
	       	return false;
	    }
	 
	
	 
}
