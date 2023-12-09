package duel;
/**
 * This class will allow us to handle all the exceptions caused by the player inputs.
 */
public class InputException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public InputException(String message) {
		super(message);
	}
	

}
