package representation;

import java.util.List;

public class InnerNode extends Node {
	private List<Node> children;
	//in this first part of the project we will suppose that the list has 4 nodes
	
	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public InnerNode(int id, int depth,String description, List<Node> children) {
		  super(id, depth, description);
		  this.children=children;
		
	}
	
	///this function will be used to create the initial graph with all the possibilities for each player
	public void addChild(Node child) {
		this.children.add(child);
        
    }
	
	public InnerNode cloneNode (){
		 InnerNode newnode=new InnerNode(this.getId(),this.getDepth(),this.getDescription(),this.getChildren());
		 return (newnode) ;
	 }
	/*REMARK: i saw in the rest of the project that it will be asked to use a collection of nodes for this and not a list
	and i plan on modifying that once we finish the class on collection*/
	
	
	
	
	//still figuring out how to implement this method
		@Override
		public Node chooseNext() {
			 return children.get(0);
		 }
}
