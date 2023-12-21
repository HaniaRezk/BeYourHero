package duel;

/**
 * This class will allow us to manage the Player selection from the buttons in the Graphic Interface using choix 
 * @param Choix will be set to 1 if the player presses on the sportif button, 2 if he chooses coach
 * 3 if he chooses judge and 4 if he chooses supporteur.
 */
public class CharacterSelectionListener{

    private int Choix;

    public CharacterSelectionListener() {
        this.Choix = 0;
    }

    

	public int getChoix() {
		return Choix;
	}

	public void setChoix(int choix) {
		Choix = choix;
	}
}
