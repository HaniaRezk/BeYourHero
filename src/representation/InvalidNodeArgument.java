package representation;
/**
 * This class will allow us to handle all the exceptions that are specific to our Node definition.
 */

public class InvalidNodeArgument extends IllegalArgumentException{
    private static final long serialVersionUID = 1L;
   
	public InvalidNodeArgument() {
        super("Argument non valide pour les nodes");
    }
}