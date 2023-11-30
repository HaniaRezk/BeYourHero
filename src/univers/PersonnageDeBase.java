package univers;

public abstract class PersonnageDeBase implements Player {
	private String nom;
	private Sport sport;
	
	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public PersonnageDeBase(String nom,Sport sport) {
		this.setNom(nom);
		this.sport=sport;
	}
	 @Override
	    public String toString() {
	        return ("Nom: " + nom );
	    }
	 

}
