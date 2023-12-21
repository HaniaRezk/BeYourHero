package representation;
import java.util.List;
import java.util.Random;
/**
 * The ChanceNode class represents a node in a game tree that has multiple possible
 * outcomes, and the next move is chosen randomly based on a probability distribution.
 * It extends the Node class and implements the random selection of possible outcomes.
 */

public class ChanceNode extends Node{

	private static final long serialVersionUID = 1L;
	private List<Node> possibilites;
    private Random random;
    
    /**
     * Constructs a ChanceNode with the specified ID, depth, description, and a list of possible outcomes.
     *
     * @param id          The unique identifier of the node.
     * @param depth       The depth of the node in the game tree.
     * @param description A description of the node.
     * @param possibilites A list of possible outcomes represented by child nodes.
     */
	 public ChanceNode(int id,int depth, String description, List<Node> possibilites) {
	        super(id, depth,description);
	        this.possibilites=possibilites;
	        if (possibilites == null) {
	            throw new InvalidNodeArgument();
	        }
	        this.random=new Random();
	    }
	 
	 /**
	     * Gets the list of possible outcomes represented by child nodes.
	     *
	     * @return The list of possible outcomes.
	     */
	public  List<Node>getPossibilites() {
		  if (possibilites == null) {
	            throw new InvalidNodeArgument();
	        }
			return possibilites;
		}
	
	 /**
     * Sets the list of possible outcomes represented by child nodes.
     *
     * @param possibilites The list of possible outcomes to set.
     */
	public void setPossibilites( List<Node> possibilites) {
		  if (possibilites == null) {
	            throw new InvalidNodeArgument();
	        }
			this.possibilites = possibilites;
		}
 
	 /**
     * Chooses the next move randomly based on the probability distribution of possible outcomes.
     *
     * @return The randomly chosen next node.
     */
	@Override
	public Node chooseNext() {
		try {
	    int randomIndex = random.nextInt(possibilites.size());
	    return possibilites.get(randomIndex);
		}catch (IndexOutOfBoundsException e) {
	       
	        System.err.println("Error: " + e.getMessage());
	        return getDefaultNode();
		}
	}
	
	
	 /**
     * Creates and returns a clone of the ChanceNode with the same ID, depth, description,
     * and list of possible outcomes.
     *
     * @return A clone of the ChanceNode.
     */
	public ChanceNode cloneNode () {
		ChanceNode newnode=new ChanceNode(this.getId(),this.getDepth(),this.getDescription(),this.getPossibilites());
		 return (newnode) ; 
	 }
	
	/**
     *To handle an exception
     */
	 public Node getDefaultNode() {
		    return (new ChanceNode(0,0,"Erreure",null));
		}
 

}
