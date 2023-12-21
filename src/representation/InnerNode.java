package representation;

import java.util.List;
/**
 * The InnerNode class represents a node in a game tree that has multiple children,
 * each corresponding to a different possible path or choice. 
 * It will be mainly used t create the initial graph of possibilities for each character.
 */


public class InnerNode extends Node {
	 private static final long serialVersionUID = 1L;
	/**
     * The list of child nodes representing different possible paths or choices.
     */
	private List<Node> children;
	
	/**
     * Constructs an InnerNode with the specified ID, depth, description, and list of children.
     *
     * @param id          The unique identifier of the node.
     * @param depth       The depth of the node in the game tree.
     * @param description A description of the node.
     * @param children    The list of child nodes.
     */
	public InnerNode(int id, int depth,String description, List<Node> children) {
		  super(id, depth, description);
		  try {
	            if (children == null) {
	                throw new InvalidNodeArgument();
	            }

	            this.children = children;
	        } catch (IllegalArgumentException e) {
	            System.out.println("InnerNode erreure de construction: " + e.getMessage());
	           
	        }
		  
		
	}
	
	 /**
     * Gets the list of child nodes representing different possible paths.
     *
     * @return The list of child nodes.
     */
	public List<Node> getChildren() {
		return children;
	}
	
	 /**
     * Sets the list of child nodes representing different possible paths or choices.
     *
     * @param children The list of child nodes to set.
     */
	public void setChildren(List<Node> children) {
		try {
            if (children == null) {
                throw new InvalidNodeArgument();
            }

            this.children = children;
        } catch (IllegalArgumentException e) {
            System.out.println("Erreure during setChildren: " + e.getMessage());
           
        }
	
	}

	 /**
     * Adds a child node to the list of children. 
     * It will allow us to define the children of each node in the initial graph of possibilities for each child.
     *
     * @param child The child node to add.
     */
	public void addChild(Node child) {
	    try {
            if (child == null) {
                throw new InvalidNodeArgument();
            }

            this.children.add(child);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreure: " + e.getMessage());
       
        }
		
	        
	    }
	
	/**
	 * Creates and returns a clone of the InnerNode with the same ID, depth, description,
	 * and list of children.
	 *
	 * @return A clone of the InnerNode.
	 */
	public InnerNode cloneNode (){
		 InnerNode newnode=new InnerNode(this.getId(),this.getDepth(),this.getDescription(),this.getChildren());
		 return (newnode) ;
		
	 }
		
	/**
     * This method will never be used but has to be redefined because InnerNode extends Node and chooseNext is an abstract method.
     */
	@Override
    public Node chooseNext() {
		try {
            if (children.isEmpty()) {
                throw new InvalidNodeArgument();
            }
            return children.get(0);
        } catch (IllegalStateException e) {
            System.out.println("Erreure: " + e.getMessage());
            return getDefaultNode();
        }
    }
	/**
     *To handle an exception
     */
	public Node getDefaultNode() {
	    return (new InnerNode(0,0,"Erreure",null));
	}
	

}
