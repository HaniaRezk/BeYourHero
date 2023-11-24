package univers;

public class Coach extends PersonnageDeBase {
	public Coach(String nom, Sport sport) {
		super(nom,sport);
	}
	@Override
    public String toString() {
        return (super.toString()+ " ,et vous etes coach de " + super.getSport());
    }
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
