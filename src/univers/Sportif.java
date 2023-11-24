package univers;

public class Sportif extends PersonnageDeBase{
	private int niveau;
	public Sportif(String nom, Sport sport, int niveau) {
		super(nom,sport);
		this.niveau=niveau;
	}
	 @Override
	    public String toString() {
	        return (super.toString()+ " ,le sport que vous pratiquez est: " + super.getSport()+" ,son niveau est "+ niveau);
	    }
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
