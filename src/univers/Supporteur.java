package univers;
/**
 * The Supporteur class represents a fan character in our context: The OLympics.
 * It extends the PersonnageDeBase class and provides additional functionality
 * specific to fans.
 */
public class Supporteur extends PersonnageDeBase{
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a Supporteur with the specified name and supported sport.
     *
     * @param nom   The name of the fan.
     * @param sport The sport supported by the fan.
     */
	public Supporteur(String nom, Sport sport) {
		super(nom,sport);
	}
	
	/**
     * Returns a string representation of the fan, including their name and the sport they support.
     *
     * @return A string representation of the fan.
     */
	 @Override
	    public String toString() {
	        return (super.toString()+ " ,et le sport que vous supportez: " + super.getSport());
	    }
	 
	 /**
	     * Checks if this fan is equal to another fan character. Fans are considered equal if
	     * they have the same name and support the same sport.
	     *
	     * @param obj The object(fan) to compare.
	     * @return True if the fans are equal, false otherwise.
	     */
	 @Override
	 public boolean equals(Object obj) {
	        if (obj instanceof Supporteur) {
	        	Supporteur c=(Supporteur) obj;
	        	if (getNom().equals(c.getNom()) && getSport().equals(c.getSport())) {
	        		return true;
	        		
	        	}  	
	        }
	       	return false;
	    }
	 

}
