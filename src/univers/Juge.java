package univers;

public class Juge extends PersonnageDeBase {
	public Juge(String nom, Sport sport) {
		super(nom,sport);
	}

	 @Override
	    public String toString() {
	        return (super.toString()+ " ,et le sport que vous jugez est: " + super.getSport());
	    }
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
