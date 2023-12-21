package univers;

import java.io.Serializable;

/**
 * The PersonnageDeBase class is an abstract class representing a basic character in the context of the Olympics.
 * It implements the Player interface and provides common functionality for all characters,
 * such as storing the character's name and the sport they are associated with.
 */

public abstract class PersonnageDeBase implements Player, Serializable {
	 private static final long serialVersionUID = 1L;

	/**
     * The name of the character.
     */
	private String nom;
	
	/**
     * The sport associated with the character.
     */
	private Sport sport;
	
	/**
     * Constructs a PersonnageDeBase with the specified name and sport.
     *
     * @param nom   The name of the character.
     * @param sport The sport associated with the character.
     */
	public PersonnageDeBase(String nom,Sport sport) {
		this.setNom(nom);
		this.sport=sport;
	}
	
	/**
     * Gets the sport associated with the character.
     *
     * @return The sport associated with the character.
     */
	public Sport getSport() {
		return sport;
	}
	
	/**
     * Sets the sport associated with the character.
     *
     * @param sport The sport to be associated with the character.
     */
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	/**
     * Gets the name of the character.
     *
     * @return The name of the character.
     */
	public String getNom() {
		return nom;
	}

	/**
     * Sets the name of the character.
     *
     * @param nom The name to be set for the character.
     */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	 /**
     * Returns a string representation of the character, including their name.
     *
     * @return A string representation of the character.
     */
	 @Override
	    public String toString() {
	        return ("Nom: " + nom );
	    }
	 

}
