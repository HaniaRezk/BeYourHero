package representation;
/**
 * The TerminalNode class represents a terminal node in a game tree, where the game ends.
 * It extends the Node class and provides a specific implementation for choosing the next node.
 */

public class TerminalNode extends Node{
	 private static final long serialVersionUID = 1L;

	/**
     * Constructs a TerminalNode with the specified ID, depth, and description.
     *
     * @param id          The unique identifier of the node.
     * @param depth       The depth of the node in the game tree.
     * @param description A description of the terminal node.
     */
	public TerminalNode(int id, int depth, String description) {
        super(id, depth,description);
    }
	
	
	 /**
     * Chooses the next node, which is the current terminal node.
     *
     * @return The current terminal node.
     */
	@Override
    public TerminalNode chooseNext() {
        return this;
    }
	
	/**
     * Creates and returns a clone of the TerminalNode with the same ID, depth, and description.
     *
     * @return A clone of the TerminalNode.
     */
	public TerminalNode cloneNode () {
		 TerminalNode newnode=new TerminalNode(this.getId(),this.getDepth(),this.getDescription());
		 return (newnode) ; 
	 }

}
