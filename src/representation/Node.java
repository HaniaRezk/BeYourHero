package representation;

import java.io.Serializable;

/**
 * The Node class is an abstract class representing a node in a game tree.
 * It implements the Event interface and provides basic functionality for
 * managing node properties and choosing the next node in the game.
 * The exceptions in Node and its subclasses are going to mainly concern the ChooseNext methods
 */

public abstract class Node implements Event, Serializable{
	private static final long serialVersionUID = 1L;

	/**
     * The unique identifier of the node.
     */
	private int id;
	
	 /**
     * The description of the node.
     */
	private String description;
	
    /**
     * The next node in the game tree.
     */
	private Node nextNode;
	
    /**
     * The depth of the node in the game tree.
     */
	private int depth;

    /**
     * The total number of nodes created in the graph.
     */
    static int nbNode=0; 
	
    /**
     * Constructs a Node with the specified ID, depth, and description.
     *
     * @param id          The unique identifier of the node.
     * @param depth       The depth of the node in the game tree.
     * @param description A description of the node.
     */
	public Node(int id,int depth, String description) {
		this.description=description;
		this.id=id;
		this.setDepth(depth);
		nbNode++;
		
	}	
	
	 /**
     * Gets the description of the node.
     *
     * @return The description of the node.
     */
	public String getDescription() {
		return description;
	}
	
	 /**
     * Sets the description of the node.
     *
     * @param description The description to set.
     */
	public void setDescription(String description) {
		this.description = description;
	}
	
	 /**
     * Gets the unique identifier of the node.
     *
     * @return The unique identifier of the node.
     */
	public int getId() {
		return id;
	}
	
	 /**
     * Sets the unique identifier of the node.
     *
     * @param id The unique identifier to set.
     */
	public void setId(int id) {
		this.id = id;
	}	
	
	/**
     * Gets the next node in the game tree.
     *
     * @return The next node in the game tree.
     */
	public Node getNextNode() {
		return nextNode;
	}
	

	 /**
     * Gets the depth of the node in the game tree.
     *
     * @return The depth of the node.
     */
	public int getDepth() {
		return depth;
	}	

	/**
	 * Sets the depth of the node in the game tree.
	 *
	 * @param depth The depth to set.
	 */
	public void setDepth(int depth) {
		if (depth < 0) {
	        throw new InvalidNodeArgument();
	    }
		this.depth = depth;
	}
	
	
	 /**
     * Abstract method to be implemented differently for each subclass for choosing the next node.
     *
     * @return The next node chosen based on the type of Node.
     */
	public abstract Node chooseNext();


	
	/**
     * Binds the current node to the specified next node.
     * Used to bind the nodes when the player is making choices so that we can keep track of the state of the game.
     *
     * @param nextNode The next node to bind.
     */
	 public void setNext(Node nextNode) {
		 if (nextNode == null) {
		        throw new InvalidNodeArgument();
		    }
	        this.nextNode=nextNode;
	    }
	 
	 
	 /**
	     * Displays information about the node.
	     * Same implementation for all subclasses.
	     */
	 public void display() {
			System.out.println(description);
			
		}
	 
	 /**
	     * Checks if this node is equal to another object. Nodes are considered equal if
	     * they have the same ID and description.
	     *
	     * @param obj The object to compare.
	     * @return True if the nodes are equal, False otherwise.
	     */
	 
	 @Override
	 public boolean equals(Object obj) {
		 if(obj instanceof Node) {
			 Node n=(Node) obj;
			 if ((n.id==id) && description.equals(n.description)) {
				 return true;
				 
			 }
		 }
		 return false;
		 }
	 
	
	 
	
}

