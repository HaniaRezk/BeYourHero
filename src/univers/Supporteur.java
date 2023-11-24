package univers;

public class Supporteur extends PersonnageDeBase{
	public Supporteur(String nom, Sport sport) {
		super(nom,sport);
	}
	 @Override
	    public String toString() {
	        return (super.toString()+ " ,et le sport que vous supportez: " + super.getSport());
	    }
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
